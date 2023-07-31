package dao;

import controller.FabricaDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModeloMySql;

import model.Categoria;

public class CategoriaDAO {

    ModeloMySql modelo = new ModeloMySql("root", "", "localhost", "3306", "yearsoftrefatoramento");
    
    public boolean cadastrar(Categoria categoria){
        
        boolean status= true;
        Connection con = FabricaDeConexao.getConnection(modelo);

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco");
            return false;
        }

        String sql = "INSERT INTO categorias (nome, cor, contraste, loginProprietario)"
                    + "VALUES(?,?,?,?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, categoria.getNome());
            statement.setString(2, categoria.getCor());
            statement.setInt(3, categoria.getContraste());
            statement.setString(4, categoria.getLoginProprietario());

            statement.executeUpdate();
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa categoria já foi cadastrada. Tente novamente.");
            status = false;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }
        return status;
        
    }
    
    public Categoria pesquisar(String nome, String loginUsuario){
        
        Connection con = FabricaDeConexao.getConnection(modelo);
        Categoria categoria = new Categoria();
            
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
	
        String sql = "SELECT * FROM categorias WHERE nome='"+nome+"' AND "
                + "loginProprietario='"+loginUsuario+"'";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                categoria.setNome(result.getString("nome"));
                categoria.setCor(result.getString("cor"));
                categoria.setContraste(result.getInt("contraste"));
                categoria.setLoginProprietario(result.getString("loginProprietario"));
            }else{
                categoria = null;
            }

        }catch(SQLException e){
            categoria = null;
        }finally{
            FabricaDeConexao.closeConnection(con);
        }

        if(categoria==null){
            if(!nome.equals("Padrão"))
                JOptionPane.showMessageDialog(null, "O nome da categoria pesquisada é inexistente.");
        }
        
        return categoria;
    }
    
    public ArrayList <Categoria> listar(ArrayList <Categoria> categorias, String loginUsuarioLogado){

        Connection con = FabricaDeConexao.getConnection(modelo);
            
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
	
        String sql = "SELECT * FROM categorias WHERE loginProprietario='"+loginUsuarioLogado+"' "
                + " AND nome!='Padrão' order by nome";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Categoria categoria;

            while (result.next()) {
                categoria = new Categoria();
                categoria.setNome(result.getString("nome"));
                categoria.setCor(result.getString("cor"));
                categoria.setContraste(result.getInt("contraste"));
                categoria.setLoginProprietario(result.getString("loginProprietario"));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na listagem de Categorias.");
            categorias = null;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }

        return categorias;
    }
    
    public boolean editar(Categoria novaCategoria, String nomeCategoriaSubstituida){
        boolean status = true;
        Connection con = FabricaDeConexao.getConnection(modelo);
        String sql = null;

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão ao banco");
        }
        
        try {
            Statement checagem = con.createStatement();
            checagem.execute("SET FOREIGN_KEY_CHECKS=0");
            checagem.close();
        } catch (SQLException e)  {
            status = false;
        }
        
        if(status){
            sql = "UPDATE eventos SET categoria= ? WHERE categoria= ?;";

            try {
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, novaCategoria.getNome());
                statement.setString(2, nomeCategoriaSubstituida);

                statement.executeUpdate();
                status = true;				
            } catch (SQLException e) {
                status = false;
            }
            
            if(status){
                sql = "UPDATE categorias SET nome= ?, cor= ?, contraste= ? WHERE nome= ?;";

                try {
                    PreparedStatement statement = con.prepareStatement(sql);

                    statement.setString(1, novaCategoria.getNome());
                    statement.setString(2, novaCategoria.getCor());
                    statement.setInt(3, novaCategoria.getContraste());
                    statement.setString(4, nomeCategoriaSubstituida);

                    statement.executeUpdate();
                    status = true;

                } catch (SQLException e) {
                    status = false;
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
        
        return status;
    }
    
    public int checarOcorrencias(String nome){
        
        Connection con = FabricaDeConexao.getConnection(modelo);
        int ocorrencias = 0;    
        
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
	
        String sql = "SELECT count(*) FROM categorias, eventos WHERE eventos.categoria='"+nome+"' AND eventos.categoria=categorias.nome;";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ocorrencias = (result.getInt("count(*)"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na contagem de ocorrências da categoria.");
        } finally {
            FabricaDeConexao.closeConnection(con);
        }
        
        return ocorrencias;
    }
    
    public boolean excluir(String nome){
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
            sql = "DELETE FROM eventos WHERE categoria='"+nome+"';";
            try {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                status = false;
            } 

            if(status){
                sql = "DELETE FROM categorias WHERE nome='"+nome+"';";
                try {
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException e) {
                    status = false;
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
            JOptionPane.showMessageDialog(null, "Desculpe. Ocorreu um problema com a exclusão da categoria.");
        }
        
        return status;
    }
    
}
