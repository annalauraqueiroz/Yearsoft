package controller;

import dao.EventoDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Evento;

public class EventoCTRL {
    
    public boolean cadastrar(Evento evento){
        
        EventoDAO dao = new EventoDAO();
        
        // O JOptionPane será exibido apenas no pacote view
        return dao.cadastrar(evento);
        
    }
    
    public ArrayList <Evento> listar(ArrayList <Evento> eventos, String loginUsuarioLogado){
        
        EventoDAO dao = new EventoDAO();
        
        eventos = dao.listar(eventos, loginUsuarioLogado);
        
        return eventos;
    }
    
    public ArrayList <Evento> listarCalendario(ArrayList <Evento> eventos, String loginUsuarioLogado, Date data){
        
        EventoDAO dao = new EventoDAO();
        
        eventos = dao.listarCalendario(eventos, loginUsuarioLogado, data);
        
        return eventos;
    }
    
    public boolean editar (Evento evento){
        EventoDAO dao = new EventoDAO();
        return dao.editar(evento);
    }
 
    public boolean excluir (int idEvento){
        
        EventoDAO dao = new EventoDAO();
        
        // O JOptionPane será exibido apenas no pacote view
        return dao.excluir(idEvento);
        
    }
    
}
