/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.CategoriaCTRL;
import controller.EventoCTRL;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import model.Usuario;
import controller.UsuarioCTRL;
import model.Categoria;
import model.Evento;

/**
 *
 * @author natan
 */
public class UsuarioTestes {
    
    public UsuarioTestes() {}
    
    UsuarioCTRL controleUsuario = new UsuarioCTRL();
    CategoriaCTRL controleCategoria = new CategoriaCTRL();
    EventoCTRL controleEvento = new EventoCTRL();
    
    /** Antes de cada teste, serão excluídos os usuários cadastrados para o teste */
    @Before
    public void limparBaseInicio(){
        controleUsuario.excluir("teste");
        controleUsuario.excluir("teste1");
        controleUsuario.excluir("teste2");
        controleUsuario.excluir("novoUsuario");
    }

    /** Após cada teste, serão excluídos os usuários cadastrados para o teste */
    @After
    public void limparBaseFinal(){
        controleUsuario.excluir("teste");
        controleUsuario.excluir("teste1");
        controleUsuario.excluir("teste2");
        controleUsuario.excluir("novoUsuario");
    }
    
    @Test
    public void cadastroUsuarioTeste(){
        Usuario usuarioTeste = new Usuario("Usuario", "teste", "123", null);
        assertTrue(controleUsuario.cadastrar(usuarioTeste));
    }
    
    @Test
    public void pesquisaUsuarioTeste(){
        Usuario usuarioTeste = new Usuario("Usuario", "teste", "123", null);
        if(controleUsuario.cadastrar(usuarioTeste)){
            Usuario resultado = controleUsuario.pesquisar("teste");
            assertEquals(usuarioTeste.getNome(), resultado.getNome());
            assertEquals(usuarioTeste.getLogin(), resultado.getLogin());
            assertEquals(usuarioTeste.getSenha(), resultado.getSenha());
            assertEquals(usuarioTeste.getNascimento(), resultado.getNascimento());
        }
    }
    
    @Test
    public void listarUsuarioTeste(){
        Usuario usuarioLogado = new Usuario("Usuario", "teste", "123", null); // Usuário que irá requisitar a listagem
        Usuario usuarioTeste1 = new Usuario("Usuario1", "teste1", "1-123", new java.sql.Date(2000, 6, 25));
        Usuario usuarioTeste2 = new Usuario("Usuario2", "teste2", "2-123", new java.sql.Date(1999, 1, 13));
        if(controleUsuario.cadastrar(usuarioLogado) && controleUsuario.cadastrar(usuarioTeste1)
        && controleUsuario.cadastrar(usuarioTeste2)){
            ArrayList <Usuario> resultado = new ArrayList <Usuario>();
            resultado = controleUsuario.listar(resultado, "teste");
       
            assertEquals(usuarioTeste1.getNome(), resultado.get(0).getNome());
            assertEquals(usuarioTeste1.getLogin(), resultado.get(0).getLogin());
            assertEquals(usuarioTeste1.getSenha(), resultado.get(0).getSenha());
            assertEquals(usuarioTeste1.getNascimento(), resultado.get(0).getNascimento());
            
            assertEquals(usuarioTeste2.getNome(), resultado.get(1).getNome());
            assertEquals(usuarioTeste2.getLogin(), resultado.get(1).getLogin());
            assertEquals(usuarioTeste2.getSenha(), resultado.get(1).getSenha());
            assertEquals(usuarioTeste2.getNascimento(), resultado.get(1).getNascimento());
        }
    }
    
    @Test
    public void editarUsuarioTeste(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            Usuario usuarioNovo = new Usuario("Novo", "novoUsuario", "123456", null);
            controleUsuario.editar(usuarioNovo, "teste");

            // Como o login do usuario foi alterado, ele não deve encontrar nenhum usuario com esse nome
            // Irá aparecer um popUp informando que o usuairo não foi encontrado
            assertEquals(null, controleUsuario.pesquisar("teste"));

            // resultado deve receber o usuario já alterado nas linhas anteriores
            // É testado se os dados do usuario encontrado batem com os dados do usuario substituto
            Usuario resultadoUsuario = controleUsuario.pesquisar("novoUsuario");
            assertEquals(usuarioNovo.getNome(), resultadoUsuario.getNome());
            assertEquals(usuarioNovo.getLogin(), resultadoUsuario.getLogin());
            assertEquals(usuarioNovo.getSenha(), resultadoUsuario.getSenha());
            assertEquals(usuarioNovo.getNascimento(), resultadoUsuario.getNascimento());

            controleUsuario.excluir("novoUsuario");
        }
    }
    
    @Test
    public void excluirUsuarioTeste(){
        Usuario usuarioTeste = new Usuario("Usuario", "teste", "123", null);
        if(controleUsuario.cadastrar(usuarioTeste)){
            assertTrue(controleUsuario.excluir("teste"));
        }
    }
    
}
