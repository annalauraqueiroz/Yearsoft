/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import model.Usuario;
import model.Categoria;
import model.Evento;
import controller.CategoriaCTRL;
import controller.EventoCTRL;
import controller.UsuarioCTRL;
/**
 *
 * @author natan
 */
public class EventoTestes {
    
    public EventoTestes() {}
    
    UsuarioCTRL controleUsuario = new UsuarioCTRL();
    CategoriaCTRL controleCategoria = new CategoriaCTRL();
    EventoCTRL controleEvento = new EventoCTRL();
    
    @Before
    public void limparBase() {
        controleUsuario.excluir("teste");
    }
    
    @Test
    public void cadastroEventoTeste(){
        Usuario proprietarioDoEvento = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaDoEvento = new Categoria("Festas", "[0,0,0]", 1, "teste");
        Evento eventoTeste = new Evento(new java.sql.Date(2017, 12, 25),
        new java.sql.Date(2017, 12, 25), 18, 30, 23, 59, "Ceia de Natal", 3, null, "Festas", "teste");
        if(controleUsuario.cadastrar(proprietarioDoEvento)){
            if(controleCategoria.cadastrar(categoriaDoEvento)){
                assertTrue(controleEvento.cadastrar(eventoTeste));
            }
        }
    }
    
    @Test
    public void listarEventoTeste(){
        Usuario proprietarioDoEvento = new Usuario("Proprietario", "teste", "123", null);
        Categoria categoriaDoEvento = new Categoria("Festas", "[0,0,0]", 1, "teste");
        Evento eventoTeste1 = new Evento(new java.sql.Date(2017, 12, 25),
        new java.sql.Date(2017, 12, 25), 18, 30, 23, 59, "Ceia de Natal", 3, null, "Festas", "teste");
        Evento eventoTeste2 = new Evento(new java.sql.Date(2017, 12, 31),
        new java.sql.Date(2018, 1, 1), 22, 00, 1, 30, "Comemoração de Ano Novo", 2, null, "Festas", "teste");
        if(controleUsuario.cadastrar(proprietarioDoEvento)){
            if(controleCategoria.cadastrar(categoriaDoEvento)){
                if(controleEvento.cadastrar(eventoTeste1) && controleEvento.cadastrar(eventoTeste2)){
                    ArrayList <Evento> resultado = new ArrayList <Evento>();
                    resultado = controleEvento.listar(resultado, "teste");
                    // 4 atributos já são suficientes para identificar que os testes condizem
                    assertEquals(eventoTeste1.getDiaInicial(), resultado.get(0).getDiaInicial());
                    assertEquals(eventoTeste1.getDiaFinal(), resultado.get(0).getDiaFinal());
                    assertEquals(eventoTeste1.getDescricao(), resultado.get(0).getDescricao());
                    assertEquals(eventoTeste1.getImportancia(), resultado.get(0).getImportancia());
                    
                    assertEquals(eventoTeste2.getDiaInicial(), resultado.get(1).getDiaInicial());
                    assertEquals(eventoTeste2.getDiaFinal(), resultado.get(1).getDiaFinal());
                    assertEquals(eventoTeste2.getDescricao(), resultado.get(1).getDescricao());
                    assertEquals(eventoTeste2.getImportancia(), resultado.get(1).getImportancia());
                    
                }
            }
        }
    }
    
    // INFORMAÇÕES SOBRE OS MÉTODOS DE PESQUISA, EDIÇÃO E EXCLUSÃO
    // A criação dos métodos pesquisarEvento e excluirEvento não podem ser testadas:
    // pesquisarEvento - O método não existe, uma vez que o usuário não sabe qual o id de cada evento
    // editarEvento - O usuário não sabe o id de cada evento, sendo chamado por métodos não testáveis
    // excluirEvento - O usuário não sabe o id de cada evento, sendo chamado por métodos não testáveis
    
}
