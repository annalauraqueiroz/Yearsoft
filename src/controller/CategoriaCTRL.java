package controller;

import dao.CategoriaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categoria;

public class CategoriaCTRL {
    
    public boolean cadastrar(Categoria categoria){
        
        CategoriaDAO dao = new CategoriaDAO();
        
        // O JOptionPane será exibido apenas no pacote view
        return dao.cadastrar(categoria);
        
    }
    
    public Categoria pesquisar(String nome, String loginUsuario){
        
        CategoriaDAO dao = new CategoriaDAO();
        Categoria categoria = dao.pesquisar(nome, loginUsuario);
        
        return categoria;
    }
    
    public ArrayList <Categoria> listar(ArrayList <Categoria> categorias, String loginUsuarioLogado){
        
        CategoriaDAO dao = new CategoriaDAO();
        categorias = dao.listar(categorias, loginUsuarioLogado);
        
        return categorias;
    }
    
    public boolean editar(Categoria novaCategoria, String nomeCategoriaSubstituida){
        
        CategoriaDAO dao = new CategoriaDAO();
        
        return dao.editar(novaCategoria, nomeCategoriaSubstituida);
    }
    
    public int checarOcorrencias(Categoria categoria){
        CategoriaDAO dao = new CategoriaDAO();
        
        return dao.checarOcorrencias(categoria.getNome());
    }
    
    public boolean excluir(String nome){
        
        CategoriaDAO dao = new CategoriaDAO();
        
        // O JOptionPane será exibido apenas no pacote view
        return dao.excluir(nome);
    }
    
}
