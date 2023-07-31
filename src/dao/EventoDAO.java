package dao;

import controller.FabricaDeConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Evento;
import model.ModeloMySql;

public class EventoDAO {
    
    ModeloMySql modelo = new ModeloMySql("root", "", "localhost", "3306", "yearsoftrefatoramento");
    
    public boolean cadastrar(Evento evento){
        
        boolean status= true;
        Connection con = FabricaDeConexao.getConnection(modelo);

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco");
            return false;
        }

        String sql = "INSERT INTO eventos (diaInicial, diaFinal, horaInicial, minutoInicial, horaFinal, minutoFinal, descricao, importancia, categoria, loginProprietario)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?);";
        
        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setDate(1, evento.getDiaInicial());
            statement.setDate(2, evento.getDiaFinal());
            statement.setInt(3, evento.getHoraInicial());
            statement.setInt(4, evento.getMinutoInicial());
            statement.setInt(5, evento.getHoraFinal());
            statement.setInt(6, evento.getMinutoFinal());
            statement.setString(7, evento.getDescricao());
            statement.setInt(8, evento.getImportancia());
            statement.setString(9, evento.getCategoria());
            statement.setString(10, evento.getLoginProprietario());

            statement.executeUpdate();
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse evento já foi cadastrado. Tente novamente.");
            status = false;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }
        return status;
        
    }
    
    
    public ArrayList <Evento> listar(ArrayList <Evento> eventos, String loginUsuarioLogado){
        
        Connection con = FabricaDeConexao.getConnection(modelo);
            
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
        
	String sql = "SELECT DISTINCT eventos.*, categorias.cor, categorias.contraste FROM eventos,categorias " +
            "WHERE eventos.loginProprietario='"+loginUsuarioLogado+"' AND categorias.nome=eventos.categoria";

        try {
            
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Evento evento;
            
            while (result.next()) {
                evento = new Evento();
                
                evento.setIdEvento(result.getInt("idEvento"));
                evento.setDiaInicial(result.getDate("diaInicial"));
                evento.setDiaFinal(result.getDate("diaFinal"));
                evento.setHoraInicial(result.getInt("horaInicial"));
                evento.setMinutoInicial(result.getInt("minutoInicial"));
                evento.setHoraFinal(result.getInt("horaFinal"));
                evento.setMinutoFinal(result.getInt("minutoFinal"));
                evento.setDescricao(result.getString("descricao"));
                evento.setImportancia(result.getInt("importancia"));
                evento.setLoginProprietario(result.getString("loginProprietario"));
                evento.setCor(result.getString("cor"));
                evento.setContraste(result.getInt("contraste"));
                evento.setCategoria(result.getString("categoria"));
             
                eventos.add(evento);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na listagem de Eventos.");
            eventos = null;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }

        return eventos;
    }
    
    public ArrayList <Evento> listarCalendario(ArrayList <Evento> eventos, String loginUsuarioLogado, Date data){
        
        Connection con = FabricaDeConexao.getConnection(modelo);
            
        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco.");
        }
        
	String sql = "SELECT DISTINCT eventos.*, categorias.cor, categoria, categorias.contraste FROM eventos,categorias " +
        "WHERE eventos.loginProprietario='"+loginUsuarioLogado+"' AND categorias.nome=eventos.categoria" +
        " AND eventos.diaInicial='"+data+"';";

        try {
            
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Evento evento;
            eventos = new ArrayList <Evento>();
            
            while (result.next()) {
                evento = new Evento();
                
                evento.setIdEvento(result.getInt("idEvento"));
                evento.setDiaInicial(result.getDate("diaInicial"));
                evento.setDiaFinal(result.getDate("diaFinal"));
                evento.setHoraInicial(result.getInt("horaInicial"));
                evento.setMinutoInicial(result.getInt("minutoInicial"));
                evento.setHoraFinal(result.getInt("horaFinal"));
                evento.setMinutoFinal(result.getInt("minutoFinal"));
                evento.setDescricao(result.getString("descricao"));
                evento.setImportancia(result.getInt("importancia"));
                evento.setLoginProprietario(result.getString("loginProprietario"));
                evento.setCor(result.getString("cor"));
                evento.setContraste(result.getInt("contraste"));
                evento.setCategoria(result.getString("categoria"));

                eventos.add(evento);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na listagem de Eventos.");
            eventos = null;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }

        return eventos;
    }
    
    public boolean editar(Evento evento){
        boolean status;
        Connection con = FabricaDeConexao.getConnection(modelo);            

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão ao banco");
        }

        String sql = "UPDATE eventos SET diaInicial= ?,"
                + "diaFinal= ?, horaInicial= ?, minutoInicial= ?, horaFinal= ?, minutoFinal= ?,"
                + "descricao= ?, categoria= ?, importancia= ? WHERE idEvento= ?;";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setDate(1, evento.getDiaInicial());
            statement.setDate(2, evento.getDiaFinal());
            statement.setInt(3, evento.getHoraInicial());
            statement.setInt(4, evento.getMinutoInicial());
            statement.setInt(5, evento.getHoraFinal());
            statement.setInt(6, evento.getMinutoFinal());
            statement.setString(7, evento.getDescricao());
            statement.setString(8, evento.getCategoria());
            statement.setInt(9, evento.getImportancia());
            statement.setInt(10, evento.getIdEvento());

            statement.executeUpdate();
            status = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema com a alteração do evento. Tente novamente.");
            status = false;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }
        return status;
    }
    
    public boolean excluir(int idEvento){
        boolean status = true;
        
        Connection con = FabricaDeConexao.getConnection(modelo);            
        String sql = null;

        if(con == null){
            JOptionPane.showMessageDialog(null,"Erro de conexão ao banco");
            return false;
        }

        sql = "DELETE FROM eventos WHERE idEvento='"+idEvento+"';";

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            status = false;
        } finally {
            FabricaDeConexao.closeConnection(con);
        }
        
        if(!status){
            JOptionPane.showMessageDialog(null, "Desculpe. Ocorreu um problema com a exclusão do evento.");
        }
        
        return status;
    }
    
}
