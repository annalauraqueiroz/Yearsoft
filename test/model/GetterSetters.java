/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author natan
 */
public class GetterSetters {
    
    public GetterSetters() {
    }
    
    @Test
    public void UsuarioLogin(){
        Usuario user = new Usuario();
        user.setLogin("Login");
        assertEquals("Login", user.getLogin());
    }
    
    @Test
    public void EventoDiaInicial(){
        Evento evento = new Evento();
        evento.setDiaInicial(null);
        assertEquals(null, evento.getDiaInicial());
    }
    
    @Test
    public void EventoDescricao(){
        Evento evento = new Evento();
        evento.setDescricao("Descricao do Evento");
        assertEquals("Descricao do Evento", evento.getDescricao());
    }
    
    @Test
    public void CategoriaNome(){
        Categoria categoria = new Categoria();
        categoria.setNome("Nome");
        assertEquals("Nome", categoria.getNome());
    }
    
    @Test
    public void CategoriaCor(){
        Categoria categoria = new Categoria();
        categoria.setCor("[90,90,90]");
        assertEquals("[90,90,90]", categoria.getCor());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
