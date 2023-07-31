package dao;

import controller.FabricaDeConexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModeloMySql;
import model.Usuario;

public class UsuarioDAO {
    
    ModeloMySql modelo = new ModeloMySql("root", "", "localhost", "3306", "yearsoftrefatoramento");
    
    public boolean cadastrar(Usuario user){
        
        boolean status= true;
        Connection con = FabricaDeConexao.getConnection(modelo);

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco");
            return false;
        }

        String sql = "INSERT INTO usuarios (nome, login, senha, nascimento)"
                    + "VALUES(?,?,?,?);";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, user.getNome());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getSenha());
            statement.setDate(4, user.getNascimento());

            statement.executeUpdate();
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse login de usuário já foi cadastrado. Tente novamente.");
            status = false;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }
        return status;
        
    }
    
    public Usuario pesquisar(String login){
        
        Connection con = FabricaDeConexao.getConnection(modelo);
        Usuario user = new Usuario();
            
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
	
        String sql = "SELECT * FROM usuarios WHERE login='"+login+"'";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                user.setNome(result.getString("nome"));
                user.setLogin(result.getString("login"));
                user.setSenha(result.getString("senha"));
                user.setNascimento(result.getDate("nascimento"));
            }else{
                user = null;
            }

        }catch(SQLException e){
            user = null;
        }finally{
            FabricaDeConexao.closeConnection(con);
        }

        if(user == null){
            JOptionPane.showMessageDialog(null, "O login do usuario pesquisado é inexistente.");
        }
        
        return user;
    }
    
    public ArrayList <Usuario> listar(ArrayList <Usuario> usuarios, String loginUsuarioLogado){
        
        Connection con = FabricaDeConexao.getConnection(modelo);
            
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
	
        String sql = "SELECT * FROM usuarios WHERE login!='"+loginUsuarioLogado+"' order by nome";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Usuario user;

            while (result.next()) {
                user = new Usuario();
                user.setNome(result.getString("nome"));
                user.setLogin(result.getString("login"));
                user.setSenha(result.getString("senha"));
                user.setNascimento(result.getDate("nascimento"));

                usuarios.add(user);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na listagem de Usuários.");
            usuarios = null;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }

        return usuarios;
    }
    
    public boolean editar(Usuario novoUsuario, String loginUsuarioSubstituido){
        
        boolean status = true;
            Connection con = FabricaDeConexao.getConnection(modelo);            

        if(con == null){
		JOptionPane.showMessageDialog(null,"Erro de conexão ao banco");
            }
            
        try {
            Statement checagem = con.createStatement();
            checagem.execute("SET FOREIGN_KEY_CHECKS=0");
        } catch (SQLException e)  {
            status = false;
            JOptionPane.showMessageDialog(null, "SET FOREIGN KEY = 0");
        }
        
        if(status){
            String sql = "UPDATE eventos SET loginProprietario= ? WHERE loginProprietario= ?;";
            
            try {
		PreparedStatement statement = con.prepareStatement(sql);
			
                statement.setString(1, novoUsuario.getLogin());
                statement.setString(2, loginUsuarioSubstituido);

		statement.executeUpdate();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "EVENTO");
                status = false;
            }
            
            if(status){
                
                sql = "UPDATE categorias SET loginProprietario= ? WHERE loginProprietario= ?;";
                
                try {
                    PreparedStatement statement = con.prepareStatement(sql);

                    statement.setString(1, novoUsuario.getLogin());
                    statement.setString(2, loginUsuarioSubstituido);

                    statement.executeUpdate();
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "CATEGORIA");
                    status = false;
                }
                
                if(status){
                    sql = "UPDATE usuarios SET nome= ?, login= ?,"
                        + "senha= ?, nascimento= ? WHERE login= ?;";

                    try {
                        PreparedStatement statement = con.prepareStatement(sql);

                        statement.setString(1, novoUsuario.getNome());
                        statement.setString(2, novoUsuario.getLogin());
                        statement.setString(3, novoUsuario.getSenha());
                        statement.setDate(4, novoUsuario.getNascimento());
                        statement.setString(5, loginUsuarioSubstituido);

                        statement.executeUpdate();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "USUARIO");
                        status = false;
                    }
                }
            }
        }
        
        try {
            Statement checagem = con.createStatement();
            checagem.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException e)  {
            status = false;
        }
        FabricaDeConexao.closeConnection(con);
        if(!status){
            JOptionPane.showMessageDialog(null, "Desculpe. Ocorreu um problema com a edição do usuário.");
        }
        
        return status;
    }
    
    public boolean excluir(String loginUsuarioExcluido){
        boolean status = true;

        Connection con = FabricaDeConexao.getConnection(modelo);            
        String sql = null;

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão ao banco");
            return false;
        }

        try {
            Statement checagem = con.createStatement();
            checagem.execute("SET FOREIGN_KEY_CHECKS=0");
            checagem.close();
        } catch (SQLException e)  {
            status = false;
        }

        if(status){
            sql = "DELETE FROM eventos WHERE loginProprietario='"+loginUsuarioExcluido+"';";
            try {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                status = false;
            } 

            if(status){

                sql = "DELETE FROM categorias WHERE loginProprietario='"+loginUsuarioExcluido+"';";
                try {
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException e) {
                    status = false;
                }

                if(status){

                    sql = "DELETE FROM usuarios WHERE login='"+loginUsuarioExcluido+"';";

                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.executeUpdate();
                        statement.close();
                    } catch (SQLException e) {
                        status = false;
                    }
                }
            }
        }
        
        try {
            Statement checagem = con.createStatement();
            checagem.execute("SET FOREIGN_KEY_CHECKS=1");
            checagem.close();
        } catch (SQLException e)  {
            status = false;
        }
        FabricaDeConexao.closeConnection(con);
        if(!status){
            JOptionPane.showMessageDialog(null, "Desculpe. Ocorreu um problema com a exclusão do usuário.");
        }
        
        return status;
    }
    
}
