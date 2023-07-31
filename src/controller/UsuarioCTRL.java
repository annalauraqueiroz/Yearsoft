package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioCTRL {
    
    public boolean cadastrar(Usuario usuario){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        // O JOptionPane será exibido apenas no pacote view
        return dao.cadastrar(usuario);
        
    }
    
    public Usuario pesquisar(String nome){
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.pesquisar(nome);
        
        return usuario;
    }
    
    public ArrayList <Usuario> listar(ArrayList <Usuario> usuarios, String loginUsuarioLogado){
        
        UsuarioDAO dao = new UsuarioDAO();
        usuarios = dao.listar(usuarios, loginUsuarioLogado);
        
        return usuarios;
    }
    
    public boolean editar(Usuario novoUsuario, String loginUsuarioSubstituido){
        UsuarioDAO dao = new UsuarioDAO();
        
        return dao.editar(novoUsuario, loginUsuarioSubstituido);
    }
    
    public boolean excluir(String login){
        
        UsuarioDAO dao = new UsuarioDAO();
        
        // O JOptionPane será exibido apenas no pacote view
        return dao.excluir(login);
        
    }
    
}
