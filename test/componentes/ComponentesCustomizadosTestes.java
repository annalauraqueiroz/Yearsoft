/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import javax.swing.JPanel;
import model.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.MenuPrincipal;

/**
 *
 * @author natan
 */
public class ComponentesCustomizadosTestes {
    
    public ComponentesCustomizadosTestes() {
    }
    
    /** Testa se a definição da data de um componente do sistema que compoe o calendário (DiaCalendario) está correta de acordo com os valores inseridos */
    @Test
    public void validarDia(){
        DiaCalendario dia = new DiaCalendario();
        MenuPrincipal menu = new MenuPrincipal();
        JPanel panelDia = new JPanel();
        menu.add(panelDia);
        
        Usuario user = new Usuario();
        dia.setClassePai(menu, user, panelDia);
        dia.setData(10, 10, 2017);
        int ano = dia.getAno();
        assertEquals(ano, 2017);
    }
    
    /** Checa se o método responsável por zerar a pontuação de importância dada ao componente
     * componentes.Importancia realmente torna o valor da importância igual a '0' */
    @Test
    public void ClearStarsTeste(){
        PanelImportancia i = new PanelImportancia();
        i.setImportancia(3);
        i.clearStars();
        int importanciaEsperado = 0;
        int importancia = i.getImportancia();
        assertEquals(importanciaEsperado, importancia);
    }

}
