/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CategoriaCTRL;
import controller.EventoCTRL;
import controller.UsuarioCTRL;
import model.Usuario;
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
public class TelasTestes {
    
    public TelasTestes() {
    }
    
    private UsuarioCTRL controleUsuario;
    private CategoriaCTRL controleCategoria;
    private EventoCTRL controleEvento;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ValidacaoHorasCadastroEventos(){
        MenuPrincipal menu = new MenuPrincipal();
        Usuario usuario = new Usuario("teste", "teste", "teste", null);
        CadastroEvento cadastro = new CadastroEvento();

        assertTrue(cadastro.verificarPreenchimentoHoras(24, 66));
        assertTrue(cadastro.verificarPreenchimentoHoras(24, 20));
        assertTrue(cadastro.verificarPreenchimentoHoras(12, 70));
        assertFalse(cadastro.verificarPreenchimentoHoras(12, 30));
        
    }
    
}
