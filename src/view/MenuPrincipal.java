/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.components.JSpinField;
import componentes.ButtonOpcoesMenu;
import componentes.ButtonToolBar;
import componentes.DiaCalendario;
import componentes.ListaCategoriaEvento;
import componentes.ListaEventoCalendario;
import componentes.ListaEventoEvento;
import componentes.PanelImportanciaFixo;
import componentes.importanciaCalendarioFixo;
import controller.CategoriaCTRL;
import controller.EventoCTRL;
import controller.UsuarioCTRL;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import model.Usuario;
import model.Categoria;
import model.Evento;

/**
 *
 * @author 14161000025
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    private Usuario usuarioLogado;
    
    private Categoria categoriaListadaSelecionada = null;
    private Evento eventoListadoSelecionado = null;
    
    private Evento eventoSelecionadoCalendario = null;
    
    private int mes;
    private int ano;
    
    /* Componentes externos utilizados na classe */
    
    /* Componentes do Calendário */
    private ButtonOpcoesMenu btnEditarEventoCalendario;
    private ButtonOpcoesMenu btnExcluirEventoCalendario;
    private ButtonOpcoesMenu btnCadastrarEventoCalendario;
    private int[] diasPreenchidos = new int[42]; 
    importanciaCalendarioFixo importanciaCalendario = new importanciaCalendarioFixo();
    private DiaCalendario dia1 = new DiaCalendario();
    private DiaCalendario dia2 = new DiaCalendario();
    private DiaCalendario dia3 = new DiaCalendario();
    private DiaCalendario dia4 = new DiaCalendario();
    private DiaCalendario dia5 = new DiaCalendario();
    private DiaCalendario dia6 = new DiaCalendario();
    private DiaCalendario dia7 = new DiaCalendario();
    private DiaCalendario dia8 = new DiaCalendario();
    private DiaCalendario dia9 = new DiaCalendario();
    private DiaCalendario dia10 = new DiaCalendario();
    private DiaCalendario dia11 = new DiaCalendario();
    private DiaCalendario dia12 = new DiaCalendario();
    private DiaCalendario dia13 = new DiaCalendario();
    private DiaCalendario dia14 = new DiaCalendario();
    private DiaCalendario dia15 = new DiaCalendario();
    private DiaCalendario dia16 = new DiaCalendario();
    private DiaCalendario dia17 = new DiaCalendario();
    private DiaCalendario dia18 = new DiaCalendario();
    private DiaCalendario dia19 = new DiaCalendario();
    private DiaCalendario dia20 = new DiaCalendario();
    private DiaCalendario dia21 = new DiaCalendario();
    private DiaCalendario dia22 = new DiaCalendario();
    private DiaCalendario dia23 = new DiaCalendario();
    private DiaCalendario dia24 = new DiaCalendario();
    private DiaCalendario dia25 = new DiaCalendario();
    private DiaCalendario dia26 = new DiaCalendario();
    private DiaCalendario dia27 = new DiaCalendario();
    private DiaCalendario dia28 = new DiaCalendario();
    private DiaCalendario dia29 = new DiaCalendario();
    private DiaCalendario dia30 = new DiaCalendario();
    private DiaCalendario dia31 = new DiaCalendario();
    private DiaCalendario dia32 = new DiaCalendario();
    private DiaCalendario dia33 = new DiaCalendario();
    private DiaCalendario dia34 = new DiaCalendario();
    private DiaCalendario dia35 = new DiaCalendario();
    private DiaCalendario dia36 = new DiaCalendario();
    private DiaCalendario dia37 = new DiaCalendario();
    private DiaCalendario dia38 = new DiaCalendario();
    private DiaCalendario dia39 = new DiaCalendario();
    private DiaCalendario dia40 = new DiaCalendario();
    private DiaCalendario dia41 = new DiaCalendario();
    private DiaCalendario dia42 = new DiaCalendario();
    
    /* Componentes da Barra de Navegação */
    private ButtonToolBar btnPerfil;
    private ButtonToolBar btnCategoria;
    private ButtonToolBar btnEvento;
    private ButtonToolBar btnCalendario;
    
    /* Componentes do Menu Categorias */
    private ButtonOpcoesMenu btnCadastrarCategoria;
    private ButtonOpcoesMenu btnExcluirCategoria;
    private ButtonOpcoesMenu btnEditarCategoria;
    private ButtonOpcoesMenu btnPesquisarCategoria;
    
    /* Componentes do Menu evento*/
    private ButtonOpcoesMenu btnCadastrarEvento;
    private ButtonOpcoesMenu btnExcluirEvento;
    private ButtonOpcoesMenu btnEditarEvento;
    private PanelImportanciaFixo importanciaEvento;
    
    /* Compoonentes TelaPerfil */
    private ButtonOpcoesMenu btnEditarPerfil;
    private ButtonOpcoesMenu btnExcluirPerfil;
    private ButtonOpcoesMenu btnLogoutPerfil;
    /* Compoonentes TelaPerfil */
    
    public MenuPrincipal() {
        initComponents();
    }
    
    /** Métodos que envolvem a configuração do menu e da barra de navegação*/
    
    /** Inicializa todos os componentes que precisam ser carregados do pacote 'componentes', assim como define o usuário logado e inicializa o menu. */
    public void abrirMenu(Usuario usuario){
        usuarioLogado = usuario;
        this.setVisible(true);
        
        /* Componentes da barra de navegação */
        btnPerfil = new ButtonToolBar();
        btnCategoria = new ButtonToolBar();
        btnEvento = new ButtonToolBar();
        btnCalendario = new ButtonToolBar();
        
        btnPerfil.setLocation(0, 0);
        btnPerfil.setSize(panelPerfil.getSize());
        btnPerfil.setVisible(true);
        btnPerfil.setText("Home - "+ usuarioLogado.getNome());
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPerfilMouseReleased(evt);
            }
        });
        
        btnCategoria.setLocation(0, 0);
        btnCategoria.setSize(panelCategoria.getSize());
        btnCategoria.setVisible(true);
        btnCategoria.setText("Categoria");
        btnCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCategoriaMouseReleased(evt);
            }
        });
        
        btnEvento.setLocation(0, 0);
        btnEvento.setSize(panelEvento.getSize());
        btnEvento.setVisible(true);
        btnEvento.setText("Evento");
        btnEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEventoMouseReleased(evt);
            }
        });
        
        btnCalendario.setLocation(0, 0);
        btnCalendario.setSize(panelCalendario.getSize());
        btnCalendario.setVisible(true);
        btnCalendario.setText("Calendário");
        btnCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCalendarioMouseReleased(evt);
            }
        });
        
        panelPerfil.add(btnPerfil);
        panelCategoria.add(btnCategoria);
        panelEvento.add(btnEvento);
        panelCalendario.add(btnCalendario);
        /* Componentes da barra de navegação */
        
        /* Componentes do Menu Categorias */
        btnCadastrarCategoria = new ButtonOpcoesMenu();
        btnExcluirCategoria = new ButtonOpcoesMenu();
        btnEditarCategoria = new ButtonOpcoesMenu();
        btnPesquisarCategoria = new ButtonOpcoesMenu();
        
        btnCadastrarCategoria.setLocation(0, 0);
        btnCadastrarCategoria.setSize(panelCadastrarCategoria.getSize());
        btnCadastrarCategoria.setVisible(true);
        btnCadastrarCategoria.setText("Cadastrar");
        btnCadastrarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCadastrarCategoriaMouseReleased(evt);
            }
        });
        
        btnExcluirCategoria.setLocation(0, 0);
        btnExcluirCategoria.setSize(panelExcluirCategoria.getSize());
        btnExcluirCategoria.setVisible(true);
        btnExcluirCategoria.setText("Excluir");
        btnExcluirCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExcluirCategoriaMouseReleased(evt);
            }
        });
        
        btnEditarCategoria.setLocation(0, 0);
        btnEditarCategoria.setSize(panelEditarCategoria.getSize());
        btnEditarCategoria.setVisible(true);
        btnEditarCategoria.setText("Editar");
        btnEditarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEditarCategoriaMouseReleased(evt);
            }
        });
        
        btnPesquisarCategoria.setLocation(0, 0);
        btnPesquisarCategoria.setSize(panelPesquisarCategoria.getSize());
        btnPesquisarCategoria.setVisible(true);
        btnPesquisarCategoria.setText("Pesquisar");
        btnPesquisarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPesquisarCategoriaMouseReleased(evt);
            }
        });
        
        panelCadastrarCategoria.add(btnCadastrarCategoria);
        panelExcluirCategoria.add(btnExcluirCategoria);
        panelEditarCategoria.add(btnEditarCategoria);
        panelPesquisarCategoria.add(btnPesquisarCategoria);
        /* Componentes do Menu Categorias */
        
        listarCategorias();
        
        /* Componentes do Menu Evento */       
        btnCadastrarEvento = new ButtonOpcoesMenu();
        btnExcluirEvento = new ButtonOpcoesMenu();
        btnEditarEvento = new ButtonOpcoesMenu();
        
        btnCadastrarEvento.setLocation(0, 0);
        btnCadastrarEvento.setSize(panelCadastrarCategoria1.getSize());
        btnCadastrarEvento.setVisible(true);
        btnCadastrarEvento.setText("Cadastrar");
        btnCadastrarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCadastrarEventoMouseReleased(evt);
            }
        });
                
        btnEditarEvento.setLocation(0, 0);
        btnEditarEvento.setSize(panelEditarCategoria1.getSize());
        btnEditarEvento.setVisible(true);
        btnEditarEvento.setText("Editar");
        btnEditarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEditarEventoMouseReleased(evt);
            }
        });
                
        btnExcluirEvento.setLocation(0, 0);
        btnExcluirEvento.setSize(panelExcluirCategoria1.getSize());
        btnExcluirEvento.setVisible(true);
        btnExcluirEvento.setText("Excluir");
        btnExcluirEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExcluirEventoMouseReleased(evt);
            }
        });       
        
        importanciaEvento = new PanelImportanciaFixo();
        importanciaEvento.setVisible(true);
        importanciaEvento.setLocation(0,0);
        importanciaEvento.setSize(panelImportancia.getSize());
        
        panelCadastrarCategoria1.add(btnCadastrarEvento);
        panelEditarCategoria1.add(btnEditarEvento);
        panelExcluirCategoria1.add(btnExcluirEvento);
        panelImportancia.add(importanciaEvento);
        /* Componentes do Menu Evento */
        
        /* Componentes do Menu Perfil */
        
        btnEditarPerfil = new ButtonOpcoesMenu();
        btnExcluirPerfil = new ButtonOpcoesMenu();
        btnLogoutPerfil = new ButtonOpcoesMenu();
        
        btnEditarPerfil.setLocation(0, 0);
        btnEditarPerfil.setSize(panelEditarPerfil.getSize());
        btnEditarPerfil.setVisible(true);
        btnEditarPerfil.setText("Editar");
        btnEditarPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEditarPerfilMouseReleased(evt);
            }
        });    
        
        btnExcluirPerfil.setLocation(0, 0);
        btnExcluirPerfil.setSize(panelExcluirPerfil.getSize());
        btnExcluirPerfil.setVisible(true);
        btnExcluirPerfil.setText("Excluir");
        btnExcluirPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExcluirPerfilMouseReleased(evt);
            }
        });  
        
        btnLogoutPerfil.setLocation(0, 0);
        btnLogoutPerfil.setSize(panelLogoutPerfil.getSize());
        btnLogoutPerfil.setVisible(true);
        btnLogoutPerfil.setText("Logout");
        btnLogoutPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLogoutPerfilMouseReleased(evt);
            }
        });  
        
        panelEditarPerfil.add(btnEditarPerfil);
        panelExcluirPerfil.add(btnExcluirPerfil);
        panelLogoutPerfil.add(btnLogoutPerfil);
        /* Componentes do Menu Perfil */
        
        
        listarEventos();
        
        importanciaCalendario.setVisible(true);
        importanciaCalendario.setLocation(0,0);
        importanciaCalendario.setSize(panelImportanciaCalendario.getSize());
        panelImportanciaCalendario.add(importanciaCalendario);
        
        btnEditarEventoCalendario = new ButtonOpcoesMenu();
        btnExcluirEventoCalendario = new ButtonOpcoesMenu();
        btnCadastrarEventoCalendario = new ButtonOpcoesMenu();
        
        btnEditarEventoCalendario.setVisible(true);
        btnEditarEventoCalendario.setSize(panelEditarEventoCalendario.getSize());
        btnEditarEventoCalendario.setLocation(0,0);
        btnEditarEventoCalendario.setText("Editar");
        btnEditarEventoCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEditarEventoCalendarioMouseReleased(evt);
            }
        });
        
        btnExcluirEventoCalendario.setVisible(true);
        btnExcluirEventoCalendario.setSize(panelExcluirEventoCalendario.getSize());
        btnExcluirEventoCalendario.setLocation(0,0);
        btnExcluirEventoCalendario.setText("Excluir");
        btnExcluirEventoCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnExcluirEventoCalendarioMouseReleased(evt);
            }
        });
        
        btnCadastrarEventoCalendario.setVisible(true);
        btnCadastrarEventoCalendario.setSize(panelCadastrarEventoCalendario.getSize());
        btnCadastrarEventoCalendario.setLocation(0,0);
        btnCadastrarEventoCalendario.setText("Editar");
        btnCadastrarEventoCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCadastrarEventoCalendarioMouseReleased(evt);
            }
        });
        
        panelEditarEventoCalendario.add(btnEditarEventoCalendario);
        panelExcluirEventoCalendario.add(btnExcluirEventoCalendario);
        panelCadastrarEventoCalendario.add(btnCadastrarEventoCalendario);
        
        btnPerfil.setPressed(true);
        
        atualizarPerfil();
        inicializarCalendario();
    }
    
    public void atualizarPerfil(){
        lblNomeUsuarioLogado.setText(usuarioLogado.getNome());
        lblLoginUsuarioLogado.setText(usuarioLogado.getLogin());
        lblNascimentoUsuarioLogado.setText(new SimpleDateFormat("dd/MM/yyyy").format(usuarioLogado.getNascimento()));
        lblUsuarioLogadoTitulo.setText("Usuário(a) - "+ usuarioLogado.getNome());
        btnPerfil.setText(usuarioLogado.getNome());
    }
    
    /** Lista todas as categorias e as exibe em panelCategoriasListadas */
    public void listarCategorias(){
        CategoriaCTRL controleCategoria = new CategoriaCTRL();
        ArrayList <Categoria> categorias= new ArrayList <Categoria>();
        categorias = controleCategoria.listar(categorias, usuarioLogado.getLogin());

        int posY = 0; // Responsável para não sobrepor os Labels exibidos
        String cor;

        panelCategoriasListadas.removeAll();
        for(int i=0;i<categorias.size();i++){
            categorias.get(i).setOcorrenciasEventos(controleCategoria.checarOcorrencias(categorias.get(i)));
            
            ListaCategoriaEvento categoria = new ListaCategoriaEvento();
            categoria.setSize(panelCategoriasListadas.getWidth(),30);
            categoria.setLocation(0, posY);
            categoria.setOpaque(true);
            posY += 30;
            categoria.getClassePai(this);
            categoria.setCategoria(categorias.get(i));
            
            categoria.setText(categorias.get(i).getNome());
            categoria.setHorizontalAlignment(SwingConstants.CENTER);
            cor = categorias.get(i).getCor();
            String[] colors = cor.substring(1,cor.length()-1).split(",");
                Color color = new Color(
                    Integer.parseInt(colors[0].trim()),
                    Integer.parseInt(colors[1].trim()),
                    Integer.parseInt(colors[2].trim()));
            categoria.setBackground(color);
            if(categorias.get(i).getContraste() == 1){
                categoria.setForeground(new Color(10,24,39));
            }else{
                categoria.setForeground(new Color(204,217,206));
            }
            panelCategoriasListadas.add(categoria);
        }
        panelCategoriasListadas.repaint();

    }
    
    /** Ao receber o evento de clique dos componentes listados, a categoria selecionada terá seus dados exibidos e será marcada como a selecionada no momento */
    public void atualizarDadosListagemCategorias(Categoria categoriaListada){
        
        if(categoriaListada == null){
            lblNomeCategoriaListada.setText("");
            lblContrasteCategoriaListada.setText("");
            lblCorCategoriaListada.setText("");
            lblCorCategoriaListada.setOpaque(false);
            lblContrasteCategoriaListada.setOpaque(false);
            lblOcorrenciasCategoria.setText("Utilizada em 0 Eventos.");
        }else{
            categoriaListadaSelecionada = categoriaListada;
            
            lblOcorrenciasCategoria.setText("Utilizada em "+categoriaListada.getOcorrenciasEventos()+" Eventos.");
            
            lblNomeCategoriaListada.setText(categoriaListada.getNome());
            lblContrasteCategoriaListada.setOpaque(true);

            lblNomeCategoriaListada.setHorizontalAlignment(SwingConstants.CENTER);
            lblCorCategoriaListada.setHorizontalAlignment(SwingConstants.CENTER);
            lblContrasteCategoriaListada.setHorizontalAlignment(SwingConstants.CENTER);

            Color contraste;
            if(categoriaListada.getContraste()==1){
                contraste = new Color(10,24,39);
                lblContrasteCategoriaListada.setText("Modelo 1");
                lblContrasteCategoriaListada.setBackground(contraste);
                lblContrasteCategoriaListada.setForeground(new Color(204,217,206));
            }else{
                contraste = new Color(204,217,206);
                lblContrasteCategoriaListada.setText("Modelo 2");
                lblContrasteCategoriaListada.setBackground(contraste);
                lblContrasteCategoriaListada.setForeground(new Color(10,24,39));
            }
            String cor = categoriaListada.getCor();
            String[] colors = cor.substring(1,cor.length()-1).split(",");
                    Color color = new Color(
                        Integer.parseInt(colors[0].trim()),
                        Integer.parseInt(colors[1].trim()),
                        Integer.parseInt(colors[2].trim()));
                lblCorCategoriaListada.setOpaque(true);
                lblCorCategoriaListada.setText(cor);
                lblCorCategoriaListada.setBackground(color);
                lblCorCategoriaListada.setForeground(contraste);
        }
    }
    
    /** Lista todas os eventos que puderem ser exibidos no painel*/
    public void listarEventos(){
        EventoCTRL controleEvento = new EventoCTRL();
        ArrayList <Evento> eventos= new ArrayList <Evento>();
        eventos = controleEvento.listar(eventos, usuarioLogado.getLogin());

        int posY = 0; // Responsável para não sobrepor os Labels exibidos
        String cor;

        panelListagemEventos.removeAll();
        for(int i=0;i<eventos.size();i++){
            ListaEventoEvento evento = new ListaEventoEvento();
            evento.setSize(panelCategoriasListadas.getWidth(),30);
            evento.setLocation(0, posY);
            evento.setOpaque(true);
            posY += 30;
            evento.getClassePai(this); // Define o menu para que o Evento possa ser retornado com um clique
            evento.setEvento(eventos.get(i));
            
            evento.setText(eventos.get(i).getDescricao());
            evento.setHorizontalAlignment(SwingConstants.CENTER);
            cor = eventos.get(i).getCor();
            String[] colors = cor.substring(1,cor.length()-1).split(",");
                Color color = new Color(
                    Integer.parseInt(colors[0].trim()),
                    Integer.parseInt(colors[1].trim()),
                    Integer.parseInt(colors[2].trim()));
            evento.setBackground(color);
            if(eventos.get(i).getContraste() == 1){
                evento.setForeground(new Color(10,24,39));
            }else{
                evento.setForeground(new Color(204,217,206));
            }
            panelListagemEventos.add(evento);
        }
        panelListagemEventos.repaint();

    }
    
    /** Ao receber o evento de clique dos componentes listados, o evento selecionado terá seus dados exibidos e será marcado como o selecionado no momento */
    public void atualizarDadosListagemEventos(Evento evento){
        if(evento == null){
            lblDiaInicial.setText("");
            lblDiaFinal.setText("");
            lblHorarios.setText("");
            lblDescricao.setText("");
            importanciaEvento.setImportancia(0);
            lblCategoria.setText("");
        }else{
            eventoListadoSelecionado = evento;
            lblDiaInicial.setText(new SimpleDateFormat("dd/MM/yyyy").format(evento.getDiaInicial()));
            lblDiaFinal.setText(new SimpleDateFormat("dd/MM/yyyy").format(evento.getDiaFinal()));
            String horaInicio;
            if(evento.getHoraInicial() < 10){
                horaInicio = "0"+ evento.getHoraInicial();
            }else{
                horaInicio = Integer.toString(evento.getHoraInicial());
            }
            String minutoInicio;
            if(evento.getMinutoInicial() < 10){
                minutoInicio = "0"+ evento.getMinutoInicial();
            }else{
                minutoInicio = Integer.toString(evento.getMinutoInicial());
            }
            String horaFinal;
            if(evento.getHoraFinal() < 10){
                horaFinal = "0"+ evento.getHoraFinal();
            }else{
                horaFinal = Integer.toString(evento.getHoraFinal());
            }
            String minutoFinal;
            if(evento.getMinutoFinal() < 10){
                minutoFinal = "0"+ evento.getMinutoFinal();
            }else{
                minutoFinal = Integer.toString(evento.getMinutoFinal());
            }
            lblHorarios.setText(horaInicio +":"+ minutoInicio +" ------ "+ horaFinal +":"+ minutoFinal);
            lblDescricao.setText(evento.getDescricao());
            importanciaEvento.setImportancia(evento.getImportancia());
            String cor = evento.getCor();
            String[] colors = cor.substring(1,cor.length()-1).split(",");
            Color color = new Color(
                Integer.parseInt(colors[0].trim()),
                Integer.parseInt(colors[1].trim()),
                Integer.parseInt(colors[2].trim()));
            lblCategoria.setBackground(color);
            lblCategoria.setOpaque(true);
            lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
            if(evento.getContraste()==1){
                lblCategoria.setForeground(new Color(10,24,39));
            }else{
                lblCategoria.setForeground(new Color(252,255,245));
            }
            lblCategoria.setText(evento.getCategoria());
            eventoListadoSelecionado = evento;
        }
    }
    
    public void inicializarCalendario(){
        java.util.Date now = new java.util.Date();
        String dataAtualStr = new SimpleDateFormat("yyyy-MM-dd").format(now);
        String[] dataAtualStr2 = dataAtualStr.split("-");
        this.ano = Integer.parseInt(dataAtualStr2[0]);
        this.mes = Integer.parseInt(dataAtualStr2[1]);

        // Envia qual a classe na qual os dias estão inseridos
        dia1.setClassePai(this, usuarioLogado, panelDia1);
        dia2.setClassePai(this, usuarioLogado, panelDia2);
        dia3.setClassePai(this, usuarioLogado, panelDia3);
        dia4.setClassePai(this, usuarioLogado, panelDia4);
        dia5.setClassePai(this, usuarioLogado, panelDia5);
        dia6.setClassePai(this, usuarioLogado, panelDia6);
        dia7.setClassePai(this, usuarioLogado, panelDia7);
        dia8.setClassePai(this, usuarioLogado, panelDia8);
        dia9.setClassePai(this, usuarioLogado, panelDia9);
        dia10.setClassePai(this, usuarioLogado, panelDia10);
        dia11.setClassePai(this, usuarioLogado, panelDia11);
        dia12.setClassePai(this, usuarioLogado, panelDia12);
        dia13.setClassePai(this, usuarioLogado, panelDia13);
        dia14.setClassePai(this, usuarioLogado, panelDia14);
        dia15.setClassePai(this, usuarioLogado, panelDia15);
        dia16.setClassePai(this, usuarioLogado, panelDia16);
        dia17.setClassePai(this, usuarioLogado, panelDia17);
        dia18.setClassePai(this, usuarioLogado, panelDia18);
        dia19.setClassePai(this, usuarioLogado, panelDia19);
        dia20.setClassePai(this, usuarioLogado, panelDia20);
        dia21.setClassePai(this, usuarioLogado, panelDia21);
        dia22.setClassePai(this, usuarioLogado, panelDia22);
        dia23.setClassePai(this, usuarioLogado, panelDia23);
        dia24.setClassePai(this, usuarioLogado, panelDia24);
        dia25.setClassePai(this, usuarioLogado, panelDia25);
        dia26.setClassePai(this, usuarioLogado, panelDia26);
        dia27.setClassePai(this, usuarioLogado, panelDia27);
        dia28.setClassePai(this, usuarioLogado, panelDia28);
        dia29.setClassePai(this, usuarioLogado, panelDia29);
        dia30.setClassePai(this, usuarioLogado, panelDia30);
        dia31.setClassePai(this, usuarioLogado, panelDia31);
        dia32.setClassePai(this, usuarioLogado, panelDia32);
        dia33.setClassePai(this, usuarioLogado, panelDia33);
        dia34.setClassePai(this, usuarioLogado, panelDia34);
        dia35.setClassePai(this, usuarioLogado, panelDia35);
        dia36.setClassePai(this, usuarioLogado, panelDia36);
        dia37.setClassePai(this, usuarioLogado, panelDia37);
        dia38.setClassePai(this, usuarioLogado, panelDia38);
        dia39.setClassePai(this, usuarioLogado, panelDia39);
        dia40.setClassePai(this, usuarioLogado, panelDia40);
        dia41.setClassePai(this, usuarioLogado, panelDia41);
        dia42.setClassePai(this, usuarioLogado, panelDia42);
        // Envia qual a classe na qual os dias estão inseridos
        
        spinAno.setModel(new SpinnerNumberModel(this.ano, this.ano-50, this.ano+50, 1));
        spinAno.setEditor(new JSpinner.NumberEditor(spinAno, "#"));

        atualizarCalendario(); // Atualiza os dados e os dias do mês atual, assim como os eventos do mesmo
    }
    
    /** Limpa os campos do calendário e recarrega todos os dados a serem exibidos*/
    public void atualizarCalendario(){
        int numeroDiasMes; // Número de dias que o mês terá
            
        comboMes.setSelectedIndex(this.mes-1);
        spinAno.setValue(this.ano);

        lblDiaDestaque.setText("");
        panelDiaDestaque.removeAll();
        panelDiaDestaque.repaint();
        lblDiaInicialCalendario.setText("");
        lblDiaFinalCalendario.setText("");
        lblHorariosCalendario.setText("");
        importanciaCalendario.setImportancia(0);
        lblCategoriaCalendario.setText("");
        lblCategoriaCalendario.setOpaque(false);
        lblDescricaoCalendario.setText("");
        eventoSelecionadoCalendario = null;

        if(comboMes.getSelectedIndex() == 1){ // 1 = FEVEREIRO
            if(this.ano%4 == 0){ // ANO BISSEXTO
                numeroDiasMes = 29;
            }else{
                numeroDiasMes = 28;
            }
        }else if(comboMes.getSelectedIndex() == 3 || comboMes.getSelectedIndex() == 5 ||
                 comboMes.getSelectedIndex() == 8 || comboMes.getSelectedIndex() == 10){
            numeroDiasMes = 30;
        }else{
            numeroDiasMes = 31;
        }

        try{
            enumerarDias(numeroDiasMes);
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null, "Não foi possível determinar a configuração do calendário nessa data.", "DATA SELECIONADA NÃO LOCALIZADA", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void enumerarDias(int numeroDiasMes) throws ParseException{
        int aux=1;
            
        for(int i=0;i<42;i++){
            // Necessário zerar o array, para próximas mudanças da data
            diasPreenchidos[i] = 0;
        }

        String dataSelecionada = this.ano +"-"+ this.mes +"-"+ 1; // Determina quando foi o 1º dia do mês
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date data = new java.sql.Date(format.parse(dataSelecionada).getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        aux = 1;
        switch(diaSemana){
            case 1: // Mês começa no DOMINGO
                for(int i=0;i<numeroDiasMes;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
            case 2: // Mês começa na SEGUNDA
                for(int i=1;i<numeroDiasMes+1;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
            case 3: // Mês começa na TERÇA
                for(int i=2;i<numeroDiasMes+2;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
            case 4: // Mês começa na QUARTA
                for(int i=3;i<numeroDiasMes+3;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
            case 5: // Mês começa na QUINTA
                for(int i=4;i<numeroDiasMes+4;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
            case 6: // Mês começa na SEXTA
                for(int i=5;i<numeroDiasMes+5;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
            case 7: // Mês começa no SÁBADO
                for(int i=6;i<numeroDiasMes+6;i++){
                    diasPreenchidos[i] = aux;
                    aux++;
                }
                break;
        }
        
        dia1.setData(diasPreenchidos[0], this.mes, this.ano);
        dia2.setData(diasPreenchidos[1], this.mes, this.ano);
        dia3.setData(diasPreenchidos[2], this.mes, this.ano);
        dia4.setData(diasPreenchidos[3], this.mes, this.ano);
        dia5.setData(diasPreenchidos[4], this.mes, this.ano);
        dia6.setData(diasPreenchidos[5], this.mes, this.ano);
        dia7.setData(diasPreenchidos[6], this.mes, this.ano);
        dia8.setData(diasPreenchidos[7], this.mes, this.ano);
        dia9.setData(diasPreenchidos[8], this.mes, this.ano);
        dia10.setData(diasPreenchidos[9], this.mes, this.ano);
        dia11.setData(diasPreenchidos[10], this.mes, this.ano);
        dia12.setData(diasPreenchidos[11], this.mes, this.ano);
        dia13.setData(diasPreenchidos[12], this.mes, this.ano);
        dia14.setData(diasPreenchidos[13], this.mes, this.ano);
        dia15.setData(diasPreenchidos[14], this.mes, this.ano);
        dia16.setData(diasPreenchidos[15], this.mes, this.ano);
        dia17.setData(diasPreenchidos[16], this.mes, this.ano);
        dia18.setData(diasPreenchidos[17], this.mes, this.ano);
        dia19.setData(diasPreenchidos[18], this.mes, this.ano);
        dia20.setData(diasPreenchidos[19], this.mes, this.ano);
        dia21.setData(diasPreenchidos[20], this.mes, this.ano);
        dia22.setData(diasPreenchidos[21], this.mes, this.ano);
        dia23.setData(diasPreenchidos[22], this.mes, this.ano);
        dia24.setData(diasPreenchidos[23], this.mes, this.ano);
        dia25.setData(diasPreenchidos[24], this.mes, this.ano);
        dia26.setData(diasPreenchidos[25], this.mes, this.ano);
        dia27.setData(diasPreenchidos[26], this.mes, this.ano);
        dia28.setData(diasPreenchidos[27], this.mes, this.ano);
        dia29.setData(diasPreenchidos[28], this.mes, this.ano);
        dia30.setData(diasPreenchidos[29], this.mes, this.ano);
        dia31.setData(diasPreenchidos[30], this.mes, this.ano);
        dia32.setData(diasPreenchidos[31], this.mes, this.ano);
        dia33.setData(diasPreenchidos[32], this.mes, this.ano);
        dia34.setData(diasPreenchidos[33], this.mes, this.ano);
        dia35.setData(diasPreenchidos[34], this.mes, this.ano);
        dia36.setData(diasPreenchidos[35], this.mes, this.ano);
        dia37.setData(diasPreenchidos[36], this.mes, this.ano);
        dia38.setData(diasPreenchidos[37], this.mes, this.ano);
        dia39.setData(diasPreenchidos[38], this.mes, this.ano);
        dia40.setData(diasPreenchidos[39], this.mes, this.ano);
        dia41.setData(diasPreenchidos[40], this.mes, this.ano);
        dia42.setData(diasPreenchidos[41], this.mes, this.ano);

    }
    
    /** É indicado qual o botão foi pressionado e deverá ser mantido dessa forma, levando a desativação dos demais */
    public void atualizarDiaDestaqueCalendario(int dia, ArrayList <Evento> eventos){
        lblDiaDestaque.setText(Integer.toString(dia));
        panelDiaDestaque.removeAll();
        panelDiaDestaque.repaint();
        
        lblDiaInicialCalendario.setText("");
        lblDiaFinalCalendario.setText("");
        lblHorariosCalendario.setText("");
        importanciaCalendario.setImportancia(0);
        lblCategoriaCalendario.setText("");
        lblCategoriaCalendario.setOpaque(false);
        lblDescricaoCalendario.setText("");
        eventoSelecionadoCalendario = null;
        
        int posY=0;
        for(int i=0;i<eventos.size();i++){
            ListaEventoCalendario evento = new ListaEventoCalendario();
            evento.setSize(230, 20);
            evento.setHorizontalAlignment(JLabel.CENTER);
            evento.setFont(new Font("Open Sans", 0, 16));
            evento.setText(eventos.get(i).getDescricao());
            evento.setLocation(0, posY);
            evento.setText(eventos.get(i).getDescricao());
            posY += 15;

            String[] cor = eventos.get(i).getCor().substring(1,eventos.get(i).getCor().length()-1).split(",");
            evento.setBackground(new Color(Integer.parseInt(cor[0]),Integer.parseInt(cor[1]),Integer.parseInt(cor[2])));
            evento.setOpaque(true);

            if(eventos.get(i).getContraste()==1){
                evento.setForeground(new Color(10,24,39));
            }else{
                evento.setForeground(new Color(204,217,206));
            }
            
            evento.setEvento(this, eventos.get(i));
            evento.setVisible(true);
            panelDiaDestaque.add(evento);
            panelDiaDestaque.repaint();
        }
    }
    
    /** Recebe o evento selecionado e exibe seus dados no painel do Calendário*/
    public void atualizarDadosEventoCalendario(Evento evento){
        eventoSelecionadoCalendario = evento;
        
        lblDiaInicialCalendario.setText(new SimpleDateFormat("dd/MM/yyyy").format(evento.getDiaInicial()));
        lblDiaFinalCalendario.setText(new SimpleDateFormat("dd/MM/yyyy").format(evento.getDiaFinal()));
        String horaInicio;
        if(evento.getHoraInicial() < 10){
            horaInicio = "0"+ evento.getHoraInicial();
        }else{
            horaInicio = Integer.toString(evento.getHoraInicial());
        }
        String minutoInicio;
        if(evento.getMinutoInicial() < 10){
            minutoInicio = "0"+ evento.getMinutoInicial();
        }else{
            minutoInicio = Integer.toString(evento.getMinutoInicial());
        }
        String horaFinal;
        if(evento.getHoraFinal() < 10){
            horaFinal = "0"+ evento.getHoraFinal();
        }else{
            horaFinal = Integer.toString(evento.getHoraFinal());
        }
        String minutoFinal;
        if(evento.getMinutoFinal() < 10){
            minutoFinal = "0"+ evento.getMinutoFinal();
        }else{
            minutoFinal = Integer.toString(evento.getMinutoFinal());
        }
        lblHorariosCalendario.setText(horaInicio +":"+ minutoInicio +" - "+ horaFinal +":"+ minutoFinal);
        importanciaCalendario.setImportancia(evento.getImportancia());
        lblDescricaoCalendario.setText(evento.getDescricao());
        lblCategoriaCalendario.setText(evento.getCategoria());
        
        String cor = evento.getCor();
        String[] colors = cor.substring(1,cor.length()-1).split(",");
        Color color = new Color(
            Integer.parseInt(colors[0].trim()),
            Integer.parseInt(colors[1].trim()),
            Integer.parseInt(colors[2].trim()));
        
        lblCategoriaCalendario.setBackground(color);
        lblCategoriaCalendario.setOpaque(true);
        if(evento.getContraste() == 1){
            lblCategoriaCalendario.setForeground(new Color(10,24,39));
        }else{
            lblCategoriaCalendario.setForeground(new Color(204,217,206));
        }
    }
    
    /** É indicado qual o botão foi pressionado e deverá ser mantido dessa forma, levando a desativação dos demais */
    public void setSelectedButtonToolBar(int botao){
        /* O botão atribuído ao inteiro é contado da esquerda para a direita:
        *  1 - Home
        *  2 - Categoria
        *  3 - Evento
        *  4 - Calendário
        */
        
        btnPerfil.setPressed(false);
        btnCategoria.setPressed(false);
        btnEvento.setPressed(false);
        btnCalendario.setPressed(false);
        
        switch(botao){
            case 1:
                btnPerfil.setPressed(true);
                break;
            case 2:
                btnCategoria.setPressed(true);
                break;
            case 3:
                btnEvento.setPressed(true);
                break;
            case 4:
                btnCalendario.setPressed(true);
                break;
        }
    }

    /** Atualiza o usuário logado */
    public void atualizarUsuarioLogado(Usuario usuario){
        usuarioLogado = usuario;
        atualizarPerfil();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        panelMenuPerfil = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lblUsuarioLogadoTitulo = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblNomeUsuarioLogado = new javax.swing.JLabel();
        lblLoginUsuarioLogado = new javax.swing.JLabel();
        lblNascimentoUsuarioLogado = new javax.swing.JLabel();
        panelEditarPerfil = new javax.swing.JPanel();
        panelExcluirPerfil = new javax.swing.JPanel();
        panelLogoutPerfil = new javax.swing.JPanel();
        panelMenuCategoria = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNomeCategoriaListada = new javax.swing.JLabel();
        lblCorCategoriaListada = new javax.swing.JLabel();
        lblContrasteCategoriaListada = new javax.swing.JLabel();
        lblOcorrenciasCategoria = new javax.swing.JLabel();
        panelEditarCategoria = new javax.swing.JPanel();
        panelExcluirCategoria = new javax.swing.JPanel();
        panelPesquisarCategoria = new javax.swing.JPanel();
        panelCadastrarCategoria = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        JPanelListagemCategoria = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        panelCategoriasListadas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        panelMenuEvento = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblDiaInicial = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblDiaFinal = new javax.swing.JLabel();
        lblHorarios = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        panelImportancia = new javax.swing.JPanel();
        panelEditarCategoria1 = new javax.swing.JPanel();
        panelExcluirCategoria1 = new javax.swing.JPanel();
        panelCadastrarCategoria1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelListagemEventos = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        panelMenuCalendario = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        panelDia1 = new javax.swing.JPanel();
        panelDia2 = new javax.swing.JPanel();
        panelDia3 = new javax.swing.JPanel();
        panelDia4 = new javax.swing.JPanel();
        panelDia5 = new javax.swing.JPanel();
        panelDia6 = new javax.swing.JPanel();
        panelDia7 = new javax.swing.JPanel();
        panelDia8 = new javax.swing.JPanel();
        panelDia9 = new javax.swing.JPanel();
        panelDia10 = new javax.swing.JPanel();
        panelDia11 = new javax.swing.JPanel();
        panelDia12 = new javax.swing.JPanel();
        panelDia13 = new javax.swing.JPanel();
        panelDia14 = new javax.swing.JPanel();
        panelDia15 = new javax.swing.JPanel();
        panelDia16 = new javax.swing.JPanel();
        panelDia17 = new javax.swing.JPanel();
        panelDia18 = new javax.swing.JPanel();
        panelDia19 = new javax.swing.JPanel();
        panelDia20 = new javax.swing.JPanel();
        panelDia21 = new javax.swing.JPanel();
        panelDia22 = new javax.swing.JPanel();
        panelDia23 = new javax.swing.JPanel();
        panelDia24 = new javax.swing.JPanel();
        panelDia25 = new javax.swing.JPanel();
        panelDia26 = new javax.swing.JPanel();
        panelDia27 = new javax.swing.JPanel();
        panelDia28 = new javax.swing.JPanel();
        panelDia29 = new javax.swing.JPanel();
        panelDia30 = new javax.swing.JPanel();
        panelDia31 = new javax.swing.JPanel();
        panelDia32 = new javax.swing.JPanel();
        panelDia33 = new javax.swing.JPanel();
        panelDia34 = new javax.swing.JPanel();
        panelDia35 = new javax.swing.JPanel();
        panelDia36 = new javax.swing.JPanel();
        panelDia37 = new javax.swing.JPanel();
        panelDia38 = new javax.swing.JPanel();
        panelDia39 = new javax.swing.JPanel();
        panelDia40 = new javax.swing.JPanel();
        panelDia41 = new javax.swing.JPanel();
        panelDia42 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblDiaDestaque = new javax.swing.JLabel();
        panelDiaDestaque = new javax.swing.JPanel();
        panelEditarEventoCalendario = new javax.swing.JPanel();
        panelExcluirEventoCalendario = new javax.swing.JPanel();
        panelCadastrarEventoCalendario = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblDiaInicialCalendario = new javax.swing.JLabel();
        lblDiaFinalCalendario = new javax.swing.JLabel();
        lblHorariosCalendario = new javax.swing.JLabel();
        lblDescricaoCalendario = new javax.swing.JLabel();
        lblDiaDestaque1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblCategoriaCalendario = new javax.swing.JLabel();
        panelImportanciaCalendario = new javax.swing.JPanel();
        comboMes = new javax.swing.JComboBox<>();
        btnMesProximo = new javax.swing.JButton();
        btnMesAnterior = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        spinAno = new javax.swing.JSpinner();
        panelBarraFerramentas = new javax.swing.JPanel();
        panelPerfil = new javax.swing.JPanel();
        panelCategoria = new javax.swing.JPanel();
        panelEvento = new javax.swing.JPanel();
        panelCalendario = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelMenu.setBackground(new java.awt.Color(252, 255, 245));
        panelMenu.setLayout(new java.awt.CardLayout());

        jPanel8.setBackground(new java.awt.Color(91, 148, 150));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(10, 24, 39));

        jPanel15.setBackground(new java.awt.Color(204, 217, 206));

        lblUsuarioLogadoTitulo.setBackground(new java.awt.Color(154, 192, 186));
        lblUsuarioLogadoTitulo.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        lblUsuarioLogadoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioLogadoTitulo.setText("Usuario - <NOME>");
        lblUsuarioLogadoTitulo.setOpaque(true);

        jLabel24.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Nome:");

        jLabel26.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Login:");

        jLabel28.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Nascimento:");

        lblNomeUsuarioLogado.setBackground(new java.awt.Color(252, 255, 245));
        lblNomeUsuarioLogado.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        lblLoginUsuarioLogado.setBackground(new java.awt.Color(252, 255, 245));
        lblLoginUsuarioLogado.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        lblNascimentoUsuarioLogado.setBackground(new java.awt.Color(252, 255, 245));
        lblNascimentoUsuarioLogado.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarioLogadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNomeUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNascimentoUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLoginUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioLogadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoginUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNascimentoUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelEditarPerfil.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelEditarPerfilLayout = new javax.swing.GroupLayout(panelEditarPerfil);
        panelEditarPerfil.setLayout(panelEditarPerfilLayout);
        panelEditarPerfilLayout.setHorizontalGroup(
            panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        panelEditarPerfilLayout.setVerticalGroup(
            panelEditarPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelExcluirPerfil.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelExcluirPerfilLayout = new javax.swing.GroupLayout(panelExcluirPerfil);
        panelExcluirPerfil.setLayout(panelExcluirPerfilLayout);
        panelExcluirPerfilLayout.setHorizontalGroup(
            panelExcluirPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        panelExcluirPerfilLayout.setVerticalGroup(
            panelExcluirPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelLogoutPerfil.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelLogoutPerfilLayout = new javax.swing.GroupLayout(panelLogoutPerfil);
        panelLogoutPerfil.setLayout(panelLogoutPerfilLayout);
        panelLogoutPerfilLayout.setHorizontalGroup(
            panelLogoutPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLogoutPerfilLayout.setVerticalGroup(
            panelLogoutPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(panelEditarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelExcluirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelLogoutPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelExcluirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(panelLogoutPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMenuPerfilLayout = new javax.swing.GroupLayout(panelMenuPerfil);
        panelMenuPerfil.setLayout(panelMenuPerfilLayout);
        panelMenuPerfilLayout.setHorizontalGroup(
            panelMenuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuPerfilLayout.createSequentialGroup()
                .addGroup(panelMenuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 533, Short.MAX_VALUE))
        );
        panelMenuPerfilLayout.setVerticalGroup(
            panelMenuPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuPerfilLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(113, 113, 113))
        );

        panelMenu.add(panelMenuPerfil, "card2");

        panelMenuCategoria.setBackground(new java.awt.Color(252, 255, 245));

        jPanel1.setBackground(new java.awt.Color(91, 148, 150));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(10, 24, 39));

        jPanel5.setBackground(new java.awt.Color(204, 217, 206));

        jLabel1.setBackground(new java.awt.Color(154, 192, 186));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Categorias - Destaque");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome da Categoria:");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cor:");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraste:");

        lblNomeCategoriaListada.setBackground(new java.awt.Color(252, 255, 245));
        lblNomeCategoriaListada.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        lblCorCategoriaListada.setBackground(new java.awt.Color(252, 255, 245));
        lblCorCategoriaListada.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        lblContrasteCategoriaListada.setBackground(new java.awt.Color(252, 255, 245));
        lblContrasteCategoriaListada.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        lblOcorrenciasCategoria.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        lblOcorrenciasCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOcorrenciasCategoria.setText("Utilizada em 0 Eventos.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNomeCategoriaListada, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContrasteCategoriaListada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCorCategoriaListada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(lblOcorrenciasCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeCategoriaListada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorCategoriaListada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContrasteCategoriaListada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addComponent(lblOcorrenciasCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelEditarCategoria.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelEditarCategoriaLayout = new javax.swing.GroupLayout(panelEditarCategoria);
        panelEditarCategoria.setLayout(panelEditarCategoriaLayout);
        panelEditarCategoriaLayout.setHorizontalGroup(
            panelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        panelEditarCategoriaLayout.setVerticalGroup(
            panelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelExcluirCategoria.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelExcluirCategoriaLayout = new javax.swing.GroupLayout(panelExcluirCategoria);
        panelExcluirCategoria.setLayout(panelExcluirCategoriaLayout);
        panelExcluirCategoriaLayout.setHorizontalGroup(
            panelExcluirCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        panelExcluirCategoriaLayout.setVerticalGroup(
            panelExcluirCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelPesquisarCategoria.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelPesquisarCategoriaLayout = new javax.swing.GroupLayout(panelPesquisarCategoria);
        panelPesquisarCategoria.setLayout(panelPesquisarCategoriaLayout);
        panelPesquisarCategoriaLayout.setHorizontalGroup(
            panelPesquisarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        panelPesquisarCategoriaLayout.setVerticalGroup(
            panelPesquisarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelCadastrarCategoria.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelCadastrarCategoriaLayout = new javax.swing.GroupLayout(panelCadastrarCategoria);
        panelCadastrarCategoria.setLayout(panelCadastrarCategoriaLayout);
        panelCadastrarCategoriaLayout.setHorizontalGroup(
            panelCadastrarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCadastrarCategoriaLayout.setVerticalGroup(
            panelCadastrarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelEditarCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCadastrarCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelExcluirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelPesquisarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelExcluirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPesquisarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCadastrarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(10, 24, 39));

        JPanelListagemCategoria.setBackground(new java.awt.Color(204, 217, 206));

        jLabel38.setBackground(new java.awt.Color(154, 192, 186));
        jLabel38.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Listagem");
        jLabel38.setOpaque(true);

        panelCategoriasListadas.setBackground(new java.awt.Color(252, 255, 245));

        javax.swing.GroupLayout panelCategoriasListadasLayout = new javax.swing.GroupLayout(panelCategoriasListadas);
        panelCategoriasListadas.setLayout(panelCategoriasListadasLayout);
        panelCategoriasListadasLayout.setHorizontalGroup(
            panelCategoriasListadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCategoriasListadasLayout.setVerticalGroup(
            panelCategoriasListadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JPanelListagemCategoriaLayout = new javax.swing.GroupLayout(JPanelListagemCategoria);
        JPanelListagemCategoria.setLayout(JPanelListagemCategoriaLayout);
        JPanelListagemCategoriaLayout.setHorizontalGroup(
            JPanelListagemCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelListagemCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelListagemCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCategoriasListadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanelListagemCategoriaLayout.setVerticalGroup(
            JPanelListagemCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelListagemCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCategoriasListadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(252, 255, 245));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Clique em uma Categoria!");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanelListagemCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JPanelListagemCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(91, 148, 150));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenuCategoriaLayout = new javax.swing.GroupLayout(panelMenuCategoria);
        panelMenuCategoria.setLayout(panelMenuCategoriaLayout);
        panelMenuCategoriaLayout.setHorizontalGroup(
            panelMenuCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuCategoriaLayout.createSequentialGroup()
                .addGroup(panelMenuCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuCategoriaLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuCategoriaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelMenuCategoriaLayout.setVerticalGroup(
            panelMenuCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuCategoriaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelMenuCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuCategoriaLayout.createSequentialGroup()
                        .addGroup(panelMenuCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(panelMenuCategoriaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelMenu.add(panelMenuCategoria, "card3");

        jPanel9.setBackground(new java.awt.Color(91, 148, 150));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(10, 24, 39));

        jPanel12.setBackground(new java.awt.Color(204, 217, 206));

        jLabel12.setBackground(new java.awt.Color(154, 192, 186));
        jLabel12.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Eventos - Destaque");
        jLabel12.setOpaque(true);

        jLabel13.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Dia de Início:");

        lblDiaInicial.setBackground(new java.awt.Color(252, 255, 245));
        lblDiaInicial.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Descrição:");

        lblDescricao.setBackground(new java.awt.Color(252, 255, 245));
        lblDescricao.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Importância:");

        jLabel27.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Categoria:");

        lblCategoria.setBackground(new java.awt.Color(252, 255, 245));
        lblCategoria.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Dia de Término:");

        lblDiaFinal.setBackground(new java.awt.Color(252, 255, 245));
        lblDiaFinal.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        lblHorarios.setBackground(new java.awt.Color(252, 255, 245));
        lblHorarios.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Horários:");

        panelImportancia.setBackground(new java.awt.Color(153, 153, 153));
        panelImportancia.setOpaque(false);

        javax.swing.GroupLayout panelImportanciaLayout = new javax.swing.GroupLayout(panelImportancia);
        panelImportancia.setLayout(panelImportanciaLayout);
        panelImportanciaLayout.setHorizontalGroup(
            panelImportanciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        panelImportanciaLayout.setVerticalGroup(
            panelImportanciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panelImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(127, 127, 127))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelImportancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelEditarCategoria1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelEditarCategoria1Layout = new javax.swing.GroupLayout(panelEditarCategoria1);
        panelEditarCategoria1.setLayout(panelEditarCategoria1Layout);
        panelEditarCategoria1Layout.setHorizontalGroup(
            panelEditarCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        panelEditarCategoria1Layout.setVerticalGroup(
            panelEditarCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelExcluirCategoria1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelExcluirCategoria1Layout = new javax.swing.GroupLayout(panelExcluirCategoria1);
        panelExcluirCategoria1.setLayout(panelExcluirCategoria1Layout);
        panelExcluirCategoria1Layout.setHorizontalGroup(
            panelExcluirCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        panelExcluirCategoria1Layout.setVerticalGroup(
            panelExcluirCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelCadastrarCategoria1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelCadastrarCategoria1Layout = new javax.swing.GroupLayout(panelCadastrarCategoria1);
        panelCadastrarCategoria1.setLayout(panelCadastrarCategoria1Layout);
        panelCadastrarCategoria1Layout.setHorizontalGroup(
            panelCadastrarCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCadastrarCategoria1Layout.setVerticalGroup(
            panelCadastrarCategoria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(panelEditarCategoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelExcluirCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCadastrarCategoria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEditarCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelExcluirCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(panelCadastrarCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel14.setBackground(new java.awt.Color(10, 24, 39));

        jLabel22.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(252, 255, 245));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Clique em um Evento!");

        jPanel3.setBackground(new java.awt.Color(204, 217, 206));

        panelListagemEventos.setBackground(new java.awt.Color(252, 255, 245));

        javax.swing.GroupLayout panelListagemEventosLayout = new javax.swing.GroupLayout(panelListagemEventos);
        panelListagemEventos.setLayout(panelListagemEventosLayout);
        panelListagemEventosLayout.setHorizontalGroup(
            panelListagemEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelListagemEventosLayout.setVerticalGroup(
            panelListagemEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        jLabel39.setBackground(new java.awt.Color(154, 192, 186));
        jLabel39.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Listagem");
        jLabel39.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelListagemEventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelListagemEventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(91, 148, 150));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenuEventoLayout = new javax.swing.GroupLayout(panelMenuEvento);
        panelMenuEvento.setLayout(panelMenuEventoLayout);
        panelMenuEventoLayout.setHorizontalGroup(
            panelMenuEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuEventoLayout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(panelMenuEventoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        panelMenuEventoLayout.setVerticalGroup(
            panelMenuEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuEventoLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelMenuEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuEventoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(393, Short.MAX_VALUE))
                    .addGroup(panelMenuEventoLayout.createSequentialGroup()
                        .addGroup(panelMenuEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 105, Short.MAX_VALUE))))
        );

        panelMenu.add(panelMenuEvento, "card4");

        panelMenuCalendario.setBackground(new java.awt.Color(252, 255, 245));

        jPanel16.setBackground(new java.awt.Color(91, 148, 150));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(10, 24, 39));

        jPanel20.setBackground(new java.awt.Color(204, 217, 206));

        jPanel21.setLayout(new java.awt.GridLayout(6, 6, 1, 1));

        panelDia1.setBackground(new java.awt.Color(153, 153, 153));
        panelDia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia1Layout = new javax.swing.GroupLayout(panelDia1);
        panelDia1.setLayout(panelDia1Layout);
        panelDia1Layout.setHorizontalGroup(
            panelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia1Layout.setVerticalGroup(
            panelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia1);

        panelDia2.setBackground(new java.awt.Color(153, 153, 153));
        panelDia2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia2Layout = new javax.swing.GroupLayout(panelDia2);
        panelDia2.setLayout(panelDia2Layout);
        panelDia2Layout.setHorizontalGroup(
            panelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia2Layout.setVerticalGroup(
            panelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia2);

        panelDia3.setBackground(new java.awt.Color(153, 153, 153));
        panelDia3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia3Layout = new javax.swing.GroupLayout(panelDia3);
        panelDia3.setLayout(panelDia3Layout);
        panelDia3Layout.setHorizontalGroup(
            panelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia3Layout.setVerticalGroup(
            panelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia3);

        panelDia4.setBackground(new java.awt.Color(153, 153, 153));
        panelDia4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia4Layout = new javax.swing.GroupLayout(panelDia4);
        panelDia4.setLayout(panelDia4Layout);
        panelDia4Layout.setHorizontalGroup(
            panelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia4Layout.setVerticalGroup(
            panelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia4);

        panelDia5.setBackground(new java.awt.Color(153, 153, 153));
        panelDia5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia5Layout = new javax.swing.GroupLayout(panelDia5);
        panelDia5.setLayout(panelDia5Layout);
        panelDia5Layout.setHorizontalGroup(
            panelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia5Layout.setVerticalGroup(
            panelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia5);

        panelDia6.setBackground(new java.awt.Color(153, 153, 153));
        panelDia6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia6Layout = new javax.swing.GroupLayout(panelDia6);
        panelDia6.setLayout(panelDia6Layout);
        panelDia6Layout.setHorizontalGroup(
            panelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia6Layout.setVerticalGroup(
            panelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia6);

        panelDia7.setBackground(new java.awt.Color(153, 153, 153));
        panelDia7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia7Layout = new javax.swing.GroupLayout(panelDia7);
        panelDia7.setLayout(panelDia7Layout);
        panelDia7Layout.setHorizontalGroup(
            panelDia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia7Layout.setVerticalGroup(
            panelDia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia7);

        panelDia8.setBackground(new java.awt.Color(153, 153, 153));
        panelDia8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia8Layout = new javax.swing.GroupLayout(panelDia8);
        panelDia8.setLayout(panelDia8Layout);
        panelDia8Layout.setHorizontalGroup(
            panelDia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia8Layout.setVerticalGroup(
            panelDia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia8);

        panelDia9.setBackground(new java.awt.Color(153, 153, 153));
        panelDia9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia9Layout = new javax.swing.GroupLayout(panelDia9);
        panelDia9.setLayout(panelDia9Layout);
        panelDia9Layout.setHorizontalGroup(
            panelDia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia9Layout.setVerticalGroup(
            panelDia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia9);

        panelDia10.setBackground(new java.awt.Color(153, 153, 153));
        panelDia10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia10Layout = new javax.swing.GroupLayout(panelDia10);
        panelDia10.setLayout(panelDia10Layout);
        panelDia10Layout.setHorizontalGroup(
            panelDia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia10Layout.setVerticalGroup(
            panelDia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia10);

        panelDia11.setBackground(new java.awt.Color(153, 153, 153));
        panelDia11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia11Layout = new javax.swing.GroupLayout(panelDia11);
        panelDia11.setLayout(panelDia11Layout);
        panelDia11Layout.setHorizontalGroup(
            panelDia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia11Layout.setVerticalGroup(
            panelDia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia11);

        panelDia12.setBackground(new java.awt.Color(153, 153, 153));
        panelDia12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia12Layout = new javax.swing.GroupLayout(panelDia12);
        panelDia12.setLayout(panelDia12Layout);
        panelDia12Layout.setHorizontalGroup(
            panelDia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia12Layout.setVerticalGroup(
            panelDia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia12);

        panelDia13.setBackground(new java.awt.Color(153, 153, 153));
        panelDia13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia13Layout = new javax.swing.GroupLayout(panelDia13);
        panelDia13.setLayout(panelDia13Layout);
        panelDia13Layout.setHorizontalGroup(
            panelDia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia13Layout.setVerticalGroup(
            panelDia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia13);

        panelDia14.setBackground(new java.awt.Color(153, 153, 153));
        panelDia14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia14Layout = new javax.swing.GroupLayout(panelDia14);
        panelDia14.setLayout(panelDia14Layout);
        panelDia14Layout.setHorizontalGroup(
            panelDia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia14Layout.setVerticalGroup(
            panelDia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia14);

        panelDia15.setBackground(new java.awt.Color(153, 153, 153));
        panelDia15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia15Layout = new javax.swing.GroupLayout(panelDia15);
        panelDia15.setLayout(panelDia15Layout);
        panelDia15Layout.setHorizontalGroup(
            panelDia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia15Layout.setVerticalGroup(
            panelDia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia15);

        panelDia16.setBackground(new java.awt.Color(153, 153, 153));
        panelDia16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia16Layout = new javax.swing.GroupLayout(panelDia16);
        panelDia16.setLayout(panelDia16Layout);
        panelDia16Layout.setHorizontalGroup(
            panelDia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia16Layout.setVerticalGroup(
            panelDia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia16);

        panelDia17.setBackground(new java.awt.Color(153, 153, 153));
        panelDia17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia17Layout = new javax.swing.GroupLayout(panelDia17);
        panelDia17.setLayout(panelDia17Layout);
        panelDia17Layout.setHorizontalGroup(
            panelDia17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia17Layout.setVerticalGroup(
            panelDia17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia17);

        panelDia18.setBackground(new java.awt.Color(153, 153, 153));
        panelDia18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia18Layout = new javax.swing.GroupLayout(panelDia18);
        panelDia18.setLayout(panelDia18Layout);
        panelDia18Layout.setHorizontalGroup(
            panelDia18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia18Layout.setVerticalGroup(
            panelDia18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia18);

        panelDia19.setBackground(new java.awt.Color(153, 153, 153));
        panelDia19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia19Layout = new javax.swing.GroupLayout(panelDia19);
        panelDia19.setLayout(panelDia19Layout);
        panelDia19Layout.setHorizontalGroup(
            panelDia19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia19Layout.setVerticalGroup(
            panelDia19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia19);

        panelDia20.setBackground(new java.awt.Color(153, 153, 153));
        panelDia20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia20Layout = new javax.swing.GroupLayout(panelDia20);
        panelDia20.setLayout(panelDia20Layout);
        panelDia20Layout.setHorizontalGroup(
            panelDia20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia20Layout.setVerticalGroup(
            panelDia20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia20);

        panelDia21.setBackground(new java.awt.Color(153, 153, 153));
        panelDia21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia21Layout = new javax.swing.GroupLayout(panelDia21);
        panelDia21.setLayout(panelDia21Layout);
        panelDia21Layout.setHorizontalGroup(
            panelDia21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia21Layout.setVerticalGroup(
            panelDia21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia21);

        panelDia22.setBackground(new java.awt.Color(153, 153, 153));
        panelDia22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia22Layout = new javax.swing.GroupLayout(panelDia22);
        panelDia22.setLayout(panelDia22Layout);
        panelDia22Layout.setHorizontalGroup(
            panelDia22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia22Layout.setVerticalGroup(
            panelDia22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia22);

        panelDia23.setBackground(new java.awt.Color(153, 153, 153));
        panelDia23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia23Layout = new javax.swing.GroupLayout(panelDia23);
        panelDia23.setLayout(panelDia23Layout);
        panelDia23Layout.setHorizontalGroup(
            panelDia23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia23Layout.setVerticalGroup(
            panelDia23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia23);

        panelDia24.setBackground(new java.awt.Color(153, 153, 153));
        panelDia24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia24Layout = new javax.swing.GroupLayout(panelDia24);
        panelDia24.setLayout(panelDia24Layout);
        panelDia24Layout.setHorizontalGroup(
            panelDia24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia24Layout.setVerticalGroup(
            panelDia24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia24);

        panelDia25.setBackground(new java.awt.Color(153, 153, 153));
        panelDia25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia25Layout = new javax.swing.GroupLayout(panelDia25);
        panelDia25.setLayout(panelDia25Layout);
        panelDia25Layout.setHorizontalGroup(
            panelDia25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia25Layout.setVerticalGroup(
            panelDia25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia25);

        panelDia26.setBackground(new java.awt.Color(153, 153, 153));
        panelDia26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia26Layout = new javax.swing.GroupLayout(panelDia26);
        panelDia26.setLayout(panelDia26Layout);
        panelDia26Layout.setHorizontalGroup(
            panelDia26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia26Layout.setVerticalGroup(
            panelDia26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia26);

        panelDia27.setBackground(new java.awt.Color(153, 153, 153));
        panelDia27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia27Layout = new javax.swing.GroupLayout(panelDia27);
        panelDia27.setLayout(panelDia27Layout);
        panelDia27Layout.setHorizontalGroup(
            panelDia27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia27Layout.setVerticalGroup(
            panelDia27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia27);

        panelDia28.setBackground(new java.awt.Color(153, 153, 153));
        panelDia28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia28Layout = new javax.swing.GroupLayout(panelDia28);
        panelDia28.setLayout(panelDia28Layout);
        panelDia28Layout.setHorizontalGroup(
            panelDia28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia28Layout.setVerticalGroup(
            panelDia28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia28);

        panelDia29.setBackground(new java.awt.Color(153, 153, 153));
        panelDia29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia29Layout = new javax.swing.GroupLayout(panelDia29);
        panelDia29.setLayout(panelDia29Layout);
        panelDia29Layout.setHorizontalGroup(
            panelDia29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia29Layout.setVerticalGroup(
            panelDia29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia29);

        panelDia30.setBackground(new java.awt.Color(153, 153, 153));
        panelDia30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia30Layout = new javax.swing.GroupLayout(panelDia30);
        panelDia30.setLayout(panelDia30Layout);
        panelDia30Layout.setHorizontalGroup(
            panelDia30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia30Layout.setVerticalGroup(
            panelDia30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia30);

        panelDia31.setBackground(new java.awt.Color(153, 153, 153));
        panelDia31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia31Layout = new javax.swing.GroupLayout(panelDia31);
        panelDia31.setLayout(panelDia31Layout);
        panelDia31Layout.setHorizontalGroup(
            panelDia31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia31Layout.setVerticalGroup(
            panelDia31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia31);

        panelDia32.setBackground(new java.awt.Color(153, 153, 153));
        panelDia32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia32Layout = new javax.swing.GroupLayout(panelDia32);
        panelDia32.setLayout(panelDia32Layout);
        panelDia32Layout.setHorizontalGroup(
            panelDia32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia32Layout.setVerticalGroup(
            panelDia32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia32);

        panelDia33.setBackground(new java.awt.Color(153, 153, 153));
        panelDia33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia33Layout = new javax.swing.GroupLayout(panelDia33);
        panelDia33.setLayout(panelDia33Layout);
        panelDia33Layout.setHorizontalGroup(
            panelDia33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia33Layout.setVerticalGroup(
            panelDia33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia33);

        panelDia34.setBackground(new java.awt.Color(153, 153, 153));
        panelDia34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia34Layout = new javax.swing.GroupLayout(panelDia34);
        panelDia34.setLayout(panelDia34Layout);
        panelDia34Layout.setHorizontalGroup(
            panelDia34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia34Layout.setVerticalGroup(
            panelDia34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia34);

        panelDia35.setBackground(new java.awt.Color(153, 153, 153));
        panelDia35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia35Layout = new javax.swing.GroupLayout(panelDia35);
        panelDia35.setLayout(panelDia35Layout);
        panelDia35Layout.setHorizontalGroup(
            panelDia35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia35Layout.setVerticalGroup(
            panelDia35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia35);

        panelDia36.setBackground(new java.awt.Color(153, 153, 153));
        panelDia36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia36Layout = new javax.swing.GroupLayout(panelDia36);
        panelDia36.setLayout(panelDia36Layout);
        panelDia36Layout.setHorizontalGroup(
            panelDia36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia36Layout.setVerticalGroup(
            panelDia36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia36);

        panelDia37.setBackground(new java.awt.Color(153, 153, 153));
        panelDia37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia37Layout = new javax.swing.GroupLayout(panelDia37);
        panelDia37.setLayout(panelDia37Layout);
        panelDia37Layout.setHorizontalGroup(
            panelDia37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia37Layout.setVerticalGroup(
            panelDia37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia37);

        panelDia38.setBackground(new java.awt.Color(153, 153, 153));
        panelDia38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia38Layout = new javax.swing.GroupLayout(panelDia38);
        panelDia38.setLayout(panelDia38Layout);
        panelDia38Layout.setHorizontalGroup(
            panelDia38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia38Layout.setVerticalGroup(
            panelDia38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia38);

        panelDia39.setBackground(new java.awt.Color(153, 153, 153));
        panelDia39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia39Layout = new javax.swing.GroupLayout(panelDia39);
        panelDia39.setLayout(panelDia39Layout);
        panelDia39Layout.setHorizontalGroup(
            panelDia39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia39Layout.setVerticalGroup(
            panelDia39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia39);

        panelDia40.setBackground(new java.awt.Color(153, 153, 153));
        panelDia40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia40Layout = new javax.swing.GroupLayout(panelDia40);
        panelDia40.setLayout(panelDia40Layout);
        panelDia40Layout.setHorizontalGroup(
            panelDia40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia40Layout.setVerticalGroup(
            panelDia40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia40);

        panelDia41.setBackground(new java.awt.Color(153, 153, 153));
        panelDia41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia41Layout = new javax.swing.GroupLayout(panelDia41);
        panelDia41.setLayout(panelDia41Layout);
        panelDia41Layout.setHorizontalGroup(
            panelDia41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia41Layout.setVerticalGroup(
            panelDia41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia41);

        panelDia42.setBackground(new java.awt.Color(153, 153, 153));
        panelDia42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout panelDia42Layout = new javax.swing.GroupLayout(panelDia42);
        panelDia42.setLayout(panelDia42Layout);
        panelDia42Layout.setHorizontalGroup(
            panelDia42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        panelDia42Layout.setVerticalGroup(
            panelDia42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel21.add(panelDia42);

        jPanel4.setLayout(new java.awt.GridLayout(1, 7, 1, 0));

        jLabel8.setBackground(new java.awt.Color(91, 148, 150));
        jLabel8.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(252, 255, 245));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Domingo");
        jLabel8.setOpaque(true);
        jPanel4.add(jLabel8);

        jLabel14.setBackground(new java.awt.Color(91, 148, 150));
        jLabel14.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(252, 255, 245));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Segunda");
        jLabel14.setOpaque(true);
        jPanel4.add(jLabel14);

        jLabel10.setBackground(new java.awt.Color(91, 148, 150));
        jLabel10.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(252, 255, 245));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Terça");
        jLabel10.setOpaque(true);
        jPanel4.add(jLabel10);

        jLabel9.setBackground(new java.awt.Color(91, 148, 150));
        jLabel9.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(252, 255, 245));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quarta");
        jLabel9.setOpaque(true);
        jPanel4.add(jLabel9);

        jLabel7.setBackground(new java.awt.Color(91, 148, 150));
        jLabel7.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(252, 255, 245));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quinta");
        jLabel7.setOpaque(true);
        jPanel4.add(jLabel7);

        jLabel6.setBackground(new java.awt.Color(91, 148, 150));
        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(252, 255, 245));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sexta");
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6);

        jLabel5.setBackground(new java.awt.Color(91, 148, 150));
        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(252, 255, 245));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sábado");
        jLabel5.setOpaque(true);
        jPanel4.add(jLabel5);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(10, 24, 39));

        jPanel18.setBackground(new java.awt.Color(204, 217, 206));

        lblDiaDestaque.setBackground(new java.awt.Color(91, 148, 150));
        lblDiaDestaque.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        lblDiaDestaque.setForeground(new java.awt.Color(10, 24, 39));
        lblDiaDestaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiaDestaque.setOpaque(true);

        javax.swing.GroupLayout panelDiaDestaqueLayout = new javax.swing.GroupLayout(panelDiaDestaque);
        panelDiaDestaque.setLayout(panelDiaDestaqueLayout);
        panelDiaDestaqueLayout.setHorizontalGroup(
            panelDiaDestaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDiaDestaqueLayout.setVerticalGroup(
            panelDiaDestaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDiaDestaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDiaDestaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(lblDiaDestaque, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelDiaDestaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEditarEventoCalendario.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelEditarEventoCalendarioLayout = new javax.swing.GroupLayout(panelEditarEventoCalendario);
        panelEditarEventoCalendario.setLayout(panelEditarEventoCalendarioLayout);
        panelEditarEventoCalendarioLayout.setHorizontalGroup(
            panelEditarEventoCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        panelEditarEventoCalendarioLayout.setVerticalGroup(
            panelEditarEventoCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelExcluirEventoCalendario.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelExcluirEventoCalendarioLayout = new javax.swing.GroupLayout(panelExcluirEventoCalendario);
        panelExcluirEventoCalendario.setLayout(panelExcluirEventoCalendarioLayout);
        panelExcluirEventoCalendarioLayout.setHorizontalGroup(
            panelExcluirEventoCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        panelExcluirEventoCalendarioLayout.setVerticalGroup(
            panelExcluirEventoCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panelCadastrarEventoCalendario.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelCadastrarEventoCalendarioLayout = new javax.swing.GroupLayout(panelCadastrarEventoCalendario);
        panelCadastrarEventoCalendario.setLayout(panelCadastrarEventoCalendarioLayout);
        panelCadastrarEventoCalendarioLayout.setHorizontalGroup(
            panelCadastrarEventoCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCadastrarEventoCalendarioLayout.setVerticalGroup(
            panelCadastrarEventoCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel22.setBackground(new java.awt.Color(204, 217, 206));

        jLabel15.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Dia Inicial:");

        jLabel17.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Dia Final:");

        jLabel18.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Horários:");

        jLabel19.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Importância:");

        jLabel20.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Descrição:");

        lblDiaInicialCalendario.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        lblDiaFinalCalendario.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        lblHorariosCalendario.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        lblDescricaoCalendario.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N

        lblDiaDestaque1.setBackground(new java.awt.Color(91, 148, 150));
        lblDiaDestaque1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        lblDiaDestaque1.setForeground(new java.awt.Color(10, 24, 39));
        lblDiaDestaque1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiaDestaque1.setText("Evento - Destaque");
        lblDiaDestaque1.setOpaque(true);

        jLabel21.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Categoria:");

        lblCategoriaCalendario.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        lblCategoriaCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        panelImportanciaCalendario.setBackground(new java.awt.Color(153, 153, 153));
        panelImportanciaCalendario.setOpaque(false);

        javax.swing.GroupLayout panelImportanciaCalendarioLayout = new javax.swing.GroupLayout(panelImportanciaCalendario);
        panelImportanciaCalendario.setLayout(panelImportanciaCalendarioLayout);
        panelImportanciaCalendarioLayout.setHorizontalGroup(
            panelImportanciaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        panelImportanciaCalendarioLayout.setVerticalGroup(
            panelImportanciaCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaInicialCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaFinalCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHorariosCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescricaoCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCategoriaCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(panelImportanciaCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(lblDiaDestaque1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(lblDiaDestaque1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaInicialCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaFinalCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHorariosCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(panelImportanciaCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblDescricaoCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblCategoriaCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCadastrarEventoCalendario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                        .addComponent(panelEditarEventoCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelExcluirEventoCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelExcluirEventoCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEditarEventoCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelCadastrarEventoCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboMes.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        comboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMesActionPerformed(evt);
            }
        });

        btnMesProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SetaBaixo.png"))); // NOI18N
        btnMesProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesProximoActionPerformed(evt);
            }
        });

        btnMesAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SetaCima.png"))); // NOI18N
        btnMesAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesAnteriorActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton1.setText("Mês Atual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spinAno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinAnoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelMenuCalendarioLayout = new javax.swing.GroupLayout(panelMenuCalendario);
        panelMenuCalendario.setLayout(panelMenuCalendarioLayout);
        panelMenuCalendarioLayout.setHorizontalGroup(
            panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelMenuCalendarioLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMenuCalendarioLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(btnMesAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMesProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(spinAno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMenuCalendarioLayout.setVerticalGroup(
            panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuCalendarioLayout.createSequentialGroup()
                .addGroup(panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuCalendarioLayout.createSequentialGroup()
                        .addGroup(panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuCalendarioLayout.createSequentialGroup()
                        .addGroup(panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMesProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMesAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelMenuCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenu.add(panelMenuCalendario, "card5");

        panelBarraFerramentas.setBackground(new java.awt.Color(154, 192, 186));

        panelPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelPerfil.setOpaque(false);

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        panelCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelCategoria.setOpaque(false);

        javax.swing.GroupLayout panelCategoriaLayout = new javax.swing.GroupLayout(panelCategoria);
        panelCategoria.setLayout(panelCategoriaLayout);
        panelCategoriaLayout.setHorizontalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        panelCategoriaLayout.setVerticalGroup(
            panelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelEvento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelEvento.setOpaque(false);

        javax.swing.GroupLayout panelEventoLayout = new javax.swing.GroupLayout(panelEvento);
        panelEvento.setLayout(panelEventoLayout);
        panelEventoLayout.setHorizontalGroup(
            panelEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        panelEventoLayout.setVerticalGroup(
            panelEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelCalendario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelCalendario.setOpaque(false);

        javax.swing.GroupLayout panelCalendarioLayout = new javax.swing.GroupLayout(panelCalendario);
        panelCalendario.setLayout(panelCalendarioLayout);
        panelCalendarioLayout.setHorizontalGroup(
            panelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        panelCalendarioLayout.setVerticalGroup(
            panelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBarraFerramentasLayout = new javax.swing.GroupLayout(panelBarraFerramentas);
        panelBarraFerramentas.setLayout(panelBarraFerramentasLayout);
        panelBarraFerramentasLayout.setHorizontalGroup(
            panelBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraFerramentasLayout.createSequentialGroup()
                .addComponent(panelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBarraFerramentasLayout.setVerticalGroup(
            panelBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCalendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelBarraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMesActionPerformed
        this.mes = comboMes.getSelectedIndex()+1;
        atualizarCalendario();
    }//GEN-LAST:event_comboMesActionPerformed

    private void spinAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinAnoStateChanged
        this.ano = (int) spinAno.getValue();
        atualizarCalendario();
    }//GEN-LAST:event_spinAnoStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.util.Date atual = new java.util.Date();
        String data[] = new SimpleDateFormat("dd/MM/yyyy").format(atual).split("/");
        this.ano = Integer.parseInt(data[2]);
        this.mes = Integer.parseInt(data[1]);
        atualizarCalendario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMesAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesAnteriorActionPerformed
        if(comboMes.getSelectedIndex()>0){
            comboMes.setSelectedIndex(comboMes.getSelectedIndex()-1);
            this.mes--;
            atualizarCalendario();
        }
    }//GEN-LAST:event_btnMesAnteriorActionPerformed

    private void btnMesProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesProximoActionPerformed
        if(comboMes.getSelectedIndex()<11){
            comboMes.setSelectedIndex(comboMes.getSelectedIndex()+1);
            this.mes++;
            atualizarCalendario();
        }
    }//GEN-LAST:event_btnMesProximoActionPerformed

    
    /* Barra de navegação */
    public void btnPerfilMouseReleased(java.awt.event.MouseEvent evt){
        if(btnPerfil.getPressedMouse()){
            setSelectedButtonToolBar(1);
            CardLayout card = (CardLayout)panelMenu.getLayout();
            card.show(panelMenu,"card2");           
        }
    }
    
    public void btnCategoriaMouseReleased(java.awt.event.MouseEvent evt){
        if(btnCategoria.getPressedMouse()){
            setSelectedButtonToolBar(2);
            CardLayout card = (CardLayout)panelMenu.getLayout();
            card.show(panelMenu,"card3");
        }
    }
    
    public void btnEventoMouseReleased(java.awt.event.MouseEvent evt){
        if(btnEvento.getPressedMouse()){
            setSelectedButtonToolBar(3);
            CardLayout card = (CardLayout)panelMenu.getLayout();
            card.show(panelMenu,"card4");
        }
    }
    
    public void btnCalendarioMouseReleased(java.awt.event.MouseEvent evt){
        if(btnCalendario.getPressedMouse()){
            setSelectedButtonToolBar(4);
            CardLayout card = (CardLayout)panelMenu.getLayout();
            card.show(panelMenu,"card5");
        }
    }
    /* Barra de navegação */
    
    /* Menu Categorias */
    public void btnCadastrarCategoriaMouseReleased(java.awt.event.MouseEvent evt){
        CadastroCategoria cadastro = new CadastroCategoria();
        cadastro.abrirCadastro(usuarioLogado, this);
    }
    
    public void btnExcluirCategoriaMouseReleased(java.awt.event.MouseEvent evt){
        CategoriaCTRL controleCategoria = new CategoriaCTRL();
        if(categoriaListadaSelecionada == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma Categoria da lista antes de prosseguir.");
        }else{
            int confirmacao = JOptionPane.showConfirmDialog(null,"A categoria não poderá ser recuperada e seus eventos serão deletados. Tem certeza que deseja excluir essa categoria?","Exclusão de Categoria", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirmacao == JOptionPane.YES_OPTION) {
                if(controleCategoria.excluir(categoriaListadaSelecionada.getNome())){ // EXECUÇÃO DA EXCLUSÃO
                    atualizarDadosListagemCategorias(null);
                    listarCategorias();
                    listarEventos();
                    categoriaListadaSelecionada = null;
                    atualizarCalendario();
                }
            }
        }
    }
    
    public void btnEditarCategoriaMouseReleased(java.awt.event.MouseEvent evt){
        EditarCategoria edicao = new EditarCategoria();
        if(categoriaListadaSelecionada == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma Categoria da lista antes de prosseguir.");
        }else{
            edicao.abrirEdicao(categoriaListadaSelecionada, this);
        }
    }
    
    public void btnPesquisarCategoriaMouseReleased(java.awt.event.MouseEvent evt){
        PesquisarCategoria pesquisa = new PesquisarCategoria();
        pesquisa.abrirPesquisa(this, usuarioLogado);
    }
    /* Menu Categorias */
    
    /* Menu Eventos */
    public void btnCadastrarEventoMouseReleased(java.awt.event.MouseEvent evt){
        CadastroEvento cadastro = new CadastroEvento();
        cadastro.abrirCadastro(usuarioLogado, this);
    }
    
    public void btnExcluirEventoMouseReleased(java.awt.event.MouseEvent evt){
        EventoCTRL controleEvento = new EventoCTRL();
        if(eventoListadoSelecionado == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma Categoria da lista antes de prosseguir.");
        }else{
            int confirmacao = JOptionPane.showConfirmDialog(null,"A categoria não poderá ser recuperada. Tem certeza que deseja excluir essa categoria?","Exclusão de Categoria", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirmacao == JOptionPane.YES_OPTION) {
                if(controleEvento.excluir(eventoListadoSelecionado.getIdEvento())){ // EXECUÇÃO DA EXCLUSÃO
                    atualizarDadosListagemEventos(null);
                    listarEventos();
                    eventoListadoSelecionado = null;
                    atualizarCalendario();
                }
            }
        }
    }
    
    public void btnEditarEventoMouseReleased(java.awt.event.MouseEvent evt){
        EditarEvento edicao = new EditarEvento();
        if(eventoListadoSelecionado == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Evento da lista antes de prosseguir.");
        }else{
            edicao.abrirEdicao(usuarioLogado, this, eventoListadoSelecionado);
        }
    }
    /* Menu Eventos */
    
    /* Calendário */
    public void btnEditarEventoCalendarioMouseReleased(java.awt.event.MouseEvent evt){
        EditarEvento edicao = new EditarEvento();
        if(eventoSelecionadoCalendario == null)
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Evento antes de prosseguir.");
        else
            edicao.abrirEdicao(usuarioLogado, this, eventoSelecionadoCalendario);
    }
    
    public void btnExcluirEventoCalendarioMouseReleased(java.awt.event.MouseEvent evt){
        EventoCTRL controleEvento = new EventoCTRL();
        if(eventoSelecionadoCalendario == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Evento antes de prosseguir.");
        }else{
            int confirmacao = JOptionPane.showConfirmDialog(null,"A categoria não poderá ser recuperada. Tem certeza que deseja excluir essa categoria?","Exclusão de Categoria", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirmacao == JOptionPane.YES_OPTION) {
                if(controleEvento.excluir(eventoSelecionadoCalendario.getIdEvento())){ // EXECUÇÃO DA EXCLUSÃO
                    listarEventos();
                    atualizarDadosListagemEventos(null);
                    eventoSelecionadoCalendario = null;
                    atualizarCalendario();
                }
            }
        }
    }
    
    public void btnCadastrarEventoCalendarioMouseReleased(java.awt.event.MouseEvent evt){
        CadastroEvento cadastro = new CadastroEvento();
        cadastro.abrirCadastro(usuarioLogado, this);
    }
    /* Calendário */
    
    /* Perfil */
    public void btnEditarPerfilMouseReleased(java.awt.event.MouseEvent evt){
        EditarPerfil edicao = new EditarPerfil();
        edicao.abrirEdicao(usuarioLogado, this);
    }
    
    public void btnExcluirPerfilMouseReleased(java.awt.event.MouseEvent evt){
        UsuarioCTRL controleUsuario = new UsuarioCTRL();
 
        int confirmacao = JOptionPane.showConfirmDialog(null,"O usuário não poderá ser recuperado e terá seus dados e categorias deletados. Tem certeza que deseja excluir esse usuário?","Exclusão de Usuário", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirmacao == JOptionPane.YES_OPTION) {
            if(controleUsuario.excluir(usuarioLogado.getLogin())){ // EXECUÇÃO DA EXCLUSÃO
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
                this.dispose();
            }
        }
    }
    
    public void btnLogoutPerfilMouseReleased(java.awt.event.MouseEvent evt){
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        this.dispose();
    }
    
    /* Perfil */
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelListagemCategoria;
    private javax.swing.JButton btnMesAnterior;
    private javax.swing.JButton btnMesProximo;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCategoriaCalendario;
    private javax.swing.JLabel lblContrasteCategoriaListada;
    private javax.swing.JLabel lblCorCategoriaListada;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricaoCalendario;
    private javax.swing.JLabel lblDiaDestaque;
    private javax.swing.JLabel lblDiaDestaque1;
    private javax.swing.JLabel lblDiaFinal;
    private javax.swing.JLabel lblDiaFinalCalendario;
    private javax.swing.JLabel lblDiaInicial;
    private javax.swing.JLabel lblDiaInicialCalendario;
    private javax.swing.JLabel lblHorarios;
    private javax.swing.JLabel lblHorariosCalendario;
    private javax.swing.JLabel lblLoginUsuarioLogado;
    private javax.swing.JLabel lblNascimentoUsuarioLogado;
    private javax.swing.JLabel lblNomeCategoriaListada;
    private javax.swing.JLabel lblNomeUsuarioLogado;
    private javax.swing.JLabel lblOcorrenciasCategoria;
    private javax.swing.JLabel lblUsuarioLogadoTitulo;
    private javax.swing.JPanel panelBarraFerramentas;
    private javax.swing.JPanel panelCadastrarCategoria;
    private javax.swing.JPanel panelCadastrarCategoria1;
    private javax.swing.JPanel panelCadastrarEventoCalendario;
    private javax.swing.JPanel panelCalendario;
    private javax.swing.JPanel panelCategoria;
    private javax.swing.JPanel panelCategoriasListadas;
    private javax.swing.JPanel panelDia1;
    private javax.swing.JPanel panelDia10;
    private javax.swing.JPanel panelDia11;
    private javax.swing.JPanel panelDia12;
    private javax.swing.JPanel panelDia13;
    private javax.swing.JPanel panelDia14;
    private javax.swing.JPanel panelDia15;
    private javax.swing.JPanel panelDia16;
    private javax.swing.JPanel panelDia17;
    private javax.swing.JPanel panelDia18;
    private javax.swing.JPanel panelDia19;
    private javax.swing.JPanel panelDia2;
    private javax.swing.JPanel panelDia20;
    private javax.swing.JPanel panelDia21;
    private javax.swing.JPanel panelDia22;
    private javax.swing.JPanel panelDia23;
    private javax.swing.JPanel panelDia24;
    private javax.swing.JPanel panelDia25;
    private javax.swing.JPanel panelDia26;
    private javax.swing.JPanel panelDia27;
    private javax.swing.JPanel panelDia28;
    private javax.swing.JPanel panelDia29;
    private javax.swing.JPanel panelDia3;
    private javax.swing.JPanel panelDia30;
    private javax.swing.JPanel panelDia31;
    private javax.swing.JPanel panelDia32;
    private javax.swing.JPanel panelDia33;
    private javax.swing.JPanel panelDia34;
    private javax.swing.JPanel panelDia35;
    private javax.swing.JPanel panelDia36;
    private javax.swing.JPanel panelDia37;
    private javax.swing.JPanel panelDia38;
    private javax.swing.JPanel panelDia39;
    private javax.swing.JPanel panelDia4;
    private javax.swing.JPanel panelDia40;
    private javax.swing.JPanel panelDia41;
    private javax.swing.JPanel panelDia42;
    private javax.swing.JPanel panelDia5;
    private javax.swing.JPanel panelDia6;
    private javax.swing.JPanel panelDia7;
    private javax.swing.JPanel panelDia8;
    private javax.swing.JPanel panelDia9;
    private javax.swing.JPanel panelDiaDestaque;
    private javax.swing.JPanel panelEditarCategoria;
    private javax.swing.JPanel panelEditarCategoria1;
    private javax.swing.JPanel panelEditarEventoCalendario;
    private javax.swing.JPanel panelEditarPerfil;
    private javax.swing.JPanel panelEvento;
    private javax.swing.JPanel panelExcluirCategoria;
    private javax.swing.JPanel panelExcluirCategoria1;
    private javax.swing.JPanel panelExcluirEventoCalendario;
    private javax.swing.JPanel panelExcluirPerfil;
    private javax.swing.JPanel panelImportancia;
    private javax.swing.JPanel panelImportanciaCalendario;
    private javax.swing.JPanel panelListagemEventos;
    private javax.swing.JPanel panelLogoutPerfil;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuCalendario;
    private javax.swing.JPanel panelMenuCategoria;
    private javax.swing.JPanel panelMenuEvento;
    private javax.swing.JPanel panelMenuPerfil;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JPanel panelPesquisarCategoria;
    private javax.swing.JSpinner spinAno;
    // End of variables declaration//GEN-END:variables
}
