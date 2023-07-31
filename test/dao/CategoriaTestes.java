/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import model.Categoria;
import model.Usuario;
import model.Evento;
import controller.CategoriaCTRL;
import controller.UsuarioCTRL;
import controller.EventoCTRL;
import javax.swing.JOptionPane;

/**
 *
 * @author natan
 */
public class CategoriaTestes {
    
    public CategoriaTestes() {}
    
    UsuarioCTRL controleUsuario = new UsuarioCTRL();
    CategoriaCTRL controleCategoria = new CategoriaCTRL();
    EventoCTRL controleEvento = new EventoCTRL();
    
    /** Antes de cada teste, serão excluídos os usuários cadastrados para o teste */
    @Before
    public void limparBase(){
        // Esse método já exclui a categoria junto com o usuário
        controleUsuario.excluir("teste");
    }
    
    /** Após cada teste, serão excluídos os usuários cadastrados para o teste */
    @After
    public void limparBaseFinal(){
        // Esse método já exclui a categoria junto com o usuário
        controleUsuario.excluir("teste");
    }
   
    /** Verifica se o cadastro de categorias está funcionando corretamente */
    @Test
    public void cadastroCategoriaTeste(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaTeste = new Categoria("Nome", "[0,0,0]", 1, "teste");
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            assertTrue(controleCategoria.cadastrar(categoriaTeste));
        }
        
    }
    
    @Test
    public void pesquisaCategoriaTeste(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaTeste = new Categoria("Nome da Categoria", "[0,0,0]", 1, "teste");
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            if(controleCategoria.cadastrar(categoriaTeste)){
                Categoria resultado = controleCategoria.pesquisar("Nome da Categoria", "teste");
                assertEquals(categoriaTeste.getNome(), resultado.getNome());
                assertEquals(categoriaTeste.getCor(), resultado.getCor());
                assertEquals(categoriaTeste.getContraste(), resultado.getContraste());
                assertEquals(categoriaTeste.getLoginProprietario(), resultado.getLoginProprietario());
            }
        }
    }
    
    @Test
    public void listarCategoriaTeste(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaTeste = new Categoria("Categoria1", "[0,0,0]", 1, "teste");
        Categoria categoriaTeste2 = new Categoria("Categoria2", "[0,0,0]", 1, "teste");
        Categoria categoriaTeste3 = new Categoria("Categoria3", "[0,0,0]", 1, "teste");
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            if(controleCategoria.cadastrar(categoriaTeste) && controleCategoria.cadastrar(categoriaTeste2)
            && controleCategoria.cadastrar(categoriaTeste3)){
                ArrayList <Categoria> resultado = new ArrayList <Categoria>();
                controleCategoria.listar(resultado, "teste");
                assertEquals(categoriaTeste.getNome(), resultado.get(0).getNome());
                assertEquals(categoriaTeste.getCor(), resultado.get(0).getCor());
                assertEquals(categoriaTeste.getContraste(), resultado.get(0).getContraste());
                assertEquals(categoriaTeste.getLoginProprietario(), resultado.get(0).getLoginProprietario());
                
                assertEquals(categoriaTeste2.getNome(), resultado.get(1).getNome());
                assertEquals(categoriaTeste2.getCor(), resultado.get(1).getCor());
                assertEquals(categoriaTeste2.getContraste(), resultado.get(1).getContraste());
                assertEquals(categoriaTeste2.getLoginProprietario(), resultado.get(1).getLoginProprietario());
                
                assertEquals(categoriaTeste3.getNome(), resultado.get(2).getNome());
                assertEquals(categoriaTeste3.getCor(), resultado.get(2).getCor());
                assertEquals(categoriaTeste3.getContraste(), resultado.get(2).getContraste());
                assertEquals(categoriaTeste3.getLoginProprietario(), resultado.get(2).getLoginProprietario());
            }
            controleUsuario.excluir("teste"); // Ese método já exclui a categoria junto com o usuário
        }
    }
    
    @Test
    public void editarCategoriaTeste(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaTeste = new Categoria("Nome da Categoria", "[0,0,0]", 1, "teste");
        Evento eventoTeste = new Evento(new java.sql.Date(2017, 12, 25),
        new java.sql.Date(2017, 12, 25), 18, 30, 23, 59, "Ceia de Natal", 3, null, "Nome da Categoria", "teste");
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            if(controleCategoria.cadastrar(categoriaTeste)){
                if(controleEvento.cadastrar(eventoTeste)){
                    Categoria categoriaNova = new Categoria("nova", "[0,0,0]", 2, "teste");
                    controleCategoria.editar(categoriaNova, "Nome da Categoria");

                    // Como o nome da categoria foi alterado, ele não deve encontrar nenhuma categoria com esse nome
                    // Irá aparecer um popUp informando que a categoria não foi encontrada
                    assertEquals(null, controleCategoria.pesquisar("Nome da Categoria", "teste"));
                    
                    // resultado deve receber a categoria já alterada nas linhas anteriores
                    // É testado se os dados da categoria encontrada batem com os dados da categoria substituta
                    Categoria resultadoCategoria = controleCategoria.pesquisar("nova", "teste");
                    assertEquals(categoriaNova.getNome(), resultadoCategoria.getNome());
                    assertEquals(categoriaNova.getCor(), resultadoCategoria.getCor());
                    assertEquals(categoriaNova.getContraste(), resultadoCategoria.getContraste());
                    
                    // É testado se o evento que possuía tal categoria teve sua categoria alterada com a edição
                    ArrayList <Evento> resultadoEvento = new ArrayList <Evento>();
                    resultadoEvento = controleEvento.listar(resultadoEvento, "teste");
                    for(int i=0;i<resultadoEvento.size();i++){
                        if(resultadoEvento.get(i).getDescricao().equals(eventoTeste.getDescricao())){
                            assertEquals(resultadoEvento.get(i).getCategoria(), categoriaNova.getNome());
                        }
                    }
                }
            }
        }
    }
    
    @Test
    public void excluirCategoriaTeste(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaTeste = new Categoria("Nome", "[0,0,0]", 1, "teste");
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            if(controleCategoria.cadastrar(categoriaTeste)){
                assertTrue(controleCategoria.excluir("Nome"));
            }
            controleUsuario.excluir("teste");
        }
    }
 
    @Test
    public void numerarOcorrenciasDaCategoriaEventos(){
        Usuario proprietarioDaCategoria = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaTeste = new Categoria("Nome", "[0,0,0]", 1, "teste");
        Evento eventoTeste1 = new Evento(new java.sql.Date(2017, 12, 25),
        new java.sql.Date(2017, 12, 25), 18, 30, 23, 59, "Ceia de Natal", 3, null, "Nome", "teste");
        Evento eventoTeste2 = new Evento(new java.sql.Date(2017, 12, 25),
        new java.sql.Date(2017, 12, 25), 18, 30, 23, 59, "Ano Novo", 3, null, "Nome", "teste");
        if(controleUsuario.cadastrar(proprietarioDaCategoria)){
            if(controleCategoria.cadastrar(categoriaTeste)){
                if(controleEvento.cadastrar(eventoTeste1) && controleEvento.cadastrar(eventoTeste2)){
                    int ocorrencias = controleCategoria.checarOcorrencias(categoriaTeste);
                    assertEquals(2, ocorrencias);
                }
            }
        }
    }
    
    
}
