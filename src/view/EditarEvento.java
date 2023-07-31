/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import componentes.ButtonMenu;
import componentes.PanelImportancia;
import controller.CategoriaCTRL;
import controller.EventoCTRL;
import java.awt.Font;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Evento;
import model.Usuario;

/**
 *
 * @author natan
 */
public class EditarEvento extends javax.swing.JFrame {

    /**
     * Creates new form EditarEvento
     */
   private MenuPrincipal classePai;
    
    private Evento evento;
    private Usuario usuario;
    
    private JDateChooser dateInicial;
    private JDateChooser dateFinal;
    private PanelImportancia importancia;
    private ButtonMenu btnEditar;
    
    public EditarEvento() {
        initComponents();
        
        dateInicial = new JDateChooser();
        dateFinal = new JDateChooser();
        btnEditar = new ButtonMenu();
        importancia = new PanelImportancia();
        
        dateInicial.setVisible(true);
        dateInicial.setLocation(0,0);
        dateInicial.setSize(panelDiaInicial.getSize());
        dateInicial.setFont(new Font("Open Sans", 0, 14));
        
        dateFinal.setVisible(true);
        dateFinal.setLocation(0,0);
        dateFinal.setSize(panelDiaFinal.getSize());
        dateFinal.setFont(new Font("Open Sans", 0, 14));
        
        panelDiaInicial.add(dateInicial);
        panelDiaFinal.add(dateFinal);
        
        try {
            txtHoraInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
            txtHoraFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (ParseException ex) {        }
        
        importancia.setVisible(true);
        importancia.setLocation(0,0);
        importancia.setSize(panelImportancia.getSize());
        panelImportancia.add(importancia);
        
        btnEditar.setVisible(true);
        btnEditar.setLocation(0,0);
        btnEditar.setSize(panelCadastrar.getSize());
        btnEditar.setFont(new Font("Open Sans", 0, 14));
        btnEditar.setText("Cadastrar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        
        panelCadastrar.add(btnEditar);
    }

    /** Abre a tela e executa as informações necessárias para o cadastro */
    public void abrirEdicao(Usuario usuario, MenuPrincipal menu, Evento evento){
        this.classePai = menu;
        this.usuario = usuario;
        this.evento = evento;
        this.setVisible(true);
        
        ArrayList <Categoria> categorias = new ArrayList <Categoria>();
        EventoCTRL controleEvento = new EventoCTRL();
        CategoriaCTRL controleCategoria = new CategoriaCTRL();
        
        Categoria selecione = new Categoria();
        selecione.setNome("Selecione");
        categorias.add(selecione);
        
        if(controleCategoria.pesquisar("Padrão",this.usuario.getLogin()) == null){
            Categoria categoriaPadrao = new Categoria("Padrão", "[252,255,245]", 1, this.usuario.getLogin());
            controleCategoria.cadastrar(categoriaPadrao);
        }
        
        Categoria padrao = new Categoria();
        padrao.setNome("Padrão");
        categorias.add(padrao);
        
        categorias = controleCategoria.listar(categorias, usuario.getLogin());
        for(int i=0;i<categorias.size();i++){
            comboCategorias.addItem(categorias.get(i).getNome());
        }
        
        txtDescricao.setText(evento.getDescricao());
        dateInicial.setDate(evento.getDiaInicial());
        dateFinal.setDate(evento.getDiaFinal());
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
        txtHoraInicial.setText(horaInicio +":"+ minutoInicio);
        txtHoraFinal.setText(horaFinal +":"+ minutoFinal);
        if(evento.getHoraInicial()==0 && evento.getMinutoInicial()==0 && evento.getHoraFinal()==23 && evento.getMinutoFinal()==59){
            checkDiaInteiro.setSelected(true);
        }
        importancia.setImportancia(evento.getImportancia());
        comboCategorias.setSelectedItem(evento.getCategoria());
    }
    
    /** Verifica se os valores dos horários estão corretos */
    public boolean verificarPreenchimentoHoras(int horas, int minutos){
        if(horas>=24 && minutos<60){
            JOptionPane.showMessageDialog(null, "As horas não foram preenchidas corretamente (0 a 23)");
            return true;
        }
        if(minutos>=60 && horas<24){
            JOptionPane.showMessageDialog(null, "Os minutos não foram preenchidos corretamente (0 a 59)");
            return true;
        }
        if(horas>=24 && minutos>=60){
            JOptionPane.showMessageDialog(null, "O horário não foi preenchido corretamente (horas: 0 a 23 ; minutos: 0 a 59) ");
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        panelCadastrar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelDiaFinal = new javax.swing.JPanel();
        panelDiaInicial = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelImportancia = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboCategorias = new javax.swing.JComboBox<>();
        txtHoraInicial = new javax.swing.JFormattedTextField();
        txtHoraFinal = new javax.swing.JFormattedTextField();
        checkDiaInteiro = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelFundo.setBackground(new java.awt.Color(252, 255, 245));

        jLabel1.setBackground(new java.awt.Color(10, 24, 39));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 255, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edição de Evento");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição:");

        txtDescricao.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        panelCadastrar.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelCadastrarLayout = new javax.swing.GroupLayout(panelCadastrar);
        panelCadastrar.setLayout(panelCadastrarLayout);
        panelCadastrarLayout.setHorizontalGroup(
            panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        panelCadastrarLayout.setVerticalGroup(
            panelCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data Inicial:");

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Data Final:");

        panelDiaFinal.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelDiaFinalLayout = new javax.swing.GroupLayout(panelDiaFinal);
        panelDiaFinal.setLayout(panelDiaFinalLayout);
        panelDiaFinalLayout.setHorizontalGroup(
            panelDiaFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDiaFinalLayout.setVerticalGroup(
            panelDiaFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        panelDiaInicial.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelDiaInicialLayout = new javax.swing.GroupLayout(panelDiaInicial);
        panelDiaInicial.setLayout(panelDiaInicialLayout);
        panelDiaInicialLayout.setHorizontalGroup(
            panelDiaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        panelDiaInicialLayout.setVerticalGroup(
            panelDiaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hora Inicial:");

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Hora Final:");

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
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Importância:");

        jLabel10.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Categoria:");

        comboCategorias.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        txtHoraInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraInicialFocusLost(evt);
            }
        });
        txtHoraInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraInicialActionPerformed(evt);
            }
        });

        txtHoraFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraFinalFocusLost(evt);
            }
        });
        txtHoraFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraFinalActionPerformed(evt);
            }
        });

        checkDiaInteiro.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        checkDiaInteiro.setText("Dia Inteiro");
        checkDiaInteiro.setOpaque(false);
        checkDiaInteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDiaInteiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                        .addGap(0, 63, Short.MAX_VALUE)
                        .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFundoLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFundoLayout.createSequentialGroup()
                                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelFundoLayout.createSequentialGroup()
                                        .addComponent(txtHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkDiaInteiro))
                                    .addComponent(panelDiaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelDiaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelFundoLayout.createSequentialGroup()
                                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(70, 70, 70))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(panelDiaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(panelDiaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkDiaInteiro))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(panelImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(panelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoraInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraInicialFocusGained
        if(checkDiaInteiro.isSelected()){
            checkDiaInteiro.requestFocus();
            JOptionPane.showMessageDialog(null, "A opção 'dia inteiro' está selecionada. Desmarque-a para alterar as horas do evento", "ALTERAÇÃO NEGADA", JOptionPane.ERROR_MESSAGE);
        }else{
            txtHoraInicial.setCaretPosition(0);
        }
    }//GEN-LAST:event_txtHoraInicialFocusGained

    private void txtHoraInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraInicialFocusLost
        String[] horaInicial = txtHoraInicial.getText().split(":");
        try{
            int horas = Integer.parseInt(horaInicial[0]);
            int minutos = Integer.parseInt(horaInicial[1]);
            if(verificarPreenchimentoHoras(horas, minutos)){
                txtHoraInicial.setText("");
                txtHoraInicial.requestFocus();
            }
        }catch(NumberFormatException e){
            txtHoraInicial.setText("");
        }
    }//GEN-LAST:event_txtHoraInicialFocusLost

    private void txtHoraInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraInicialActionPerformed
        String[] horaInicial = txtHoraInicial.getText().split(":");
        try{
            int horas = Integer.parseInt(horaInicial[0]);
            int minutos = Integer.parseInt(horaInicial[1]);
            if(verificarPreenchimentoHoras(horas, minutos)){
                txtHoraInicial.setText("");
                txtHoraInicial.requestFocus();
            }
        }catch(NumberFormatException e){
            txtHoraInicial.setText("");
        }
    }//GEN-LAST:event_txtHoraInicialActionPerformed

    private void txtHoraFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFinalFocusGained
        if(checkDiaInteiro.isSelected()){
            checkDiaInteiro.requestFocus();
            JOptionPane.showMessageDialog(null, "A opção 'dia inteiro' está selecionada. Desmarque-a para alterar as horas do evento", "ALTERAÇÃO NEGADA", JOptionPane.ERROR_MESSAGE);
        }else{
            txtHoraFinal.setCaretPosition(0);
        }
    }//GEN-LAST:event_txtHoraFinalFocusGained

    private void txtHoraFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFinalFocusLost
        String[] horaInicial = txtHoraFinal.getText().split(":");
        try{
            int horas = Integer.parseInt(horaInicial[0]);
            int minutos = Integer.parseInt(horaInicial[1]);
            if(verificarPreenchimentoHoras(horas, minutos)){
                txtHoraFinal.setText("");
                txtHoraFinal.requestFocus();
            }
        }catch(NumberFormatException e){
            txtHoraFinal.setText("");
        }
    }//GEN-LAST:event_txtHoraFinalFocusLost

    private void txtHoraFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraFinalActionPerformed
        String[] horaInicial = txtHoraFinal.getText().split(":");
        try{
            int horas = Integer.parseInt(horaInicial[0]);
            int minutos = Integer.parseInt(horaInicial[1]);
            if(verificarPreenchimentoHoras(horas, minutos)){
                txtHoraFinal.setText("");
                txtHoraFinal.requestFocus();
            }
        }catch(NumberFormatException e){
            txtHoraFinal.setText("");
        }
    }//GEN-LAST:event_txtHoraFinalActionPerformed

    private void checkDiaInteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDiaInteiroActionPerformed
        if(checkDiaInteiro.isSelected()){
            txtHoraInicial.setText("00:00");
            txtHoraFinal.setText("23:59");
        }else{
            txtHoraInicial.setText("");
            txtHoraFinal.setText("");
        }
    }//GEN-LAST:event_checkDiaInteiroActionPerformed

    public void btnEditarActionPerformed(java.awt.event.ActionEvent evt){
        Date dataInicial = java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dateInicial.getDate()));
        Date dataFinal = java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dateFinal.getDate()));
        String[] Hinicio = txtHoraInicial.getText().split(":"); // String auxiliar
        int[] horaInicio = new int[2];
        horaInicio[0] = Integer.parseInt(Hinicio[0]);
        horaInicio[1] = Integer.parseInt(Hinicio[1]);
        String[] Hfinal = txtHoraFinal.getText().split(":"); // String auxiliar
        int[] horaFinal = new int[2];
        horaFinal[0] = Integer.parseInt(Hfinal[0]);
        horaFinal[1] = Integer.parseInt(Hfinal[1]);
        String descricao = txtDescricao.getText();
        int importancia = this.importancia.getImportancia();
        String categoria = comboCategorias.getSelectedItem().toString();
        
        if(importancia==0 || descricao.equals("") || categoria.equals("Selecione")){
                JOptionPane.showMessageDialog(null, "Preencha todos os dados corretamente antes de submetê-los", "PREENCHIMENTO INCORRETO", JOptionPane.ERROR_MESSAGE);
            }else{
                String[] dataInicioStr2 = new SimpleDateFormat("yyyy-MM-dd").format(dateInicial.getDate()).split("-");
                String[] dataFinalStr2 = new SimpleDateFormat("yyyy-MM-dd").format(dateFinal.getDate()).split("-");
                int[] dataInicialInt = new int[3];
                int[] dataFinalInt = new int[3];
                dataInicialInt[0] = Integer.parseInt(dataInicioStr2[0]); // Ano
                dataInicialInt[1] = Integer.parseInt(dataInicioStr2[1]); // Mês
                dataInicialInt[2] = Integer.parseInt(dataInicioStr2[2]); // Dia
                dataFinalInt[0] = Integer.parseInt(dataFinalStr2[0]); // Ano
                dataFinalInt[1] = Integer.parseInt(dataFinalStr2[1]); // Mês
                dataFinalInt[2] = Integer.parseInt(dataFinalStr2[2]); // Dia               

                Evento evento = new Evento(dataInicial, dataFinal, horaInicio[0], horaInicio[1], horaFinal[0], horaFinal[1], descricao, importancia, null, categoria, usuario.getLogin());
                evento.setIdEvento(this.evento.getIdEvento());
                evento.setCor(this.evento.getCor());
                evento.setContraste(this.evento.getContraste());
                EventoCTRL controleEvento = new EventoCTRL();
                
                if(dataFinalInt[0] < dataInicialInt[0]){ // Ano final antes do ano inicial
                    JOptionPane.showMessageDialog(null, "A data de Término do evento é anterior à data de início. Datas incorretas.", "PREENCHIMENTO INCORRETO", JOptionPane.ERROR_MESSAGE);
                }else if(dataFinalInt[0] == dataInicialInt[0]){ // Mesmo ano
                    if(dataFinalInt[1] < dataInicialInt[1]){ // Mês final antes do mês inicial
                        JOptionPane.showMessageDialog(null, "A data de Término do evento é anterior à data de início. Datas incorretas.", "PREENCHIMENTO INCORRETO", JOptionPane.ERROR_MESSAGE);
                    }else if(dataFinalInt[1] == dataInicialInt[1]){ // Mesmo mês
                        if(dataFinalInt[2] < dataInicialInt[2]){ // Dia final antes do dia inicial
                            JOptionPane.showMessageDialog(null, "A data de Término do evento é anterior à data de início. Datas incorretas.", "PREENCHIMENTO INCORRETO", JOptionPane.ERROR_MESSAGE);
                        }else if(dataFinalInt[2] == dataInicialInt[2]){ // Mesmo dia -- PERMITE EDIÇÃO (checar horário, já que é no mesmo dia)
                            if(horaFinal[0] < horaInicio[0]){
                                JOptionPane.showMessageDialog(null, "O horário final é anterior ao horário inicial. Horários incorretos.", "PREENCHIMENTO INCORRETO", JOptionPane.ERROR_MESSAGE);
                            }else if(horaFinal[0] == horaInicio[0]){ // horas iguais -- CHECAR MINUTOS
                                if(horaFinal[1] < horaInicio[1]){ // horas iguais E minuto final < minuto inicial
                                    JOptionPane.showMessageDialog(null, "O horário final é anterior ao horário inicial. Horários incorretos.", "PREENCHIMENTO INCORRETO", JOptionPane.ERROR_MESSAGE);
                                }else{ // horas iguais e minutoFinal >= minutoInicial -- EDIÇÃO
                                    if(controleEvento.editar(evento)){ // EXECUÇÃO DA EDIÇÃO
                                        JOptionPane.showMessageDialog(null,"Evento alterado com sucesso!");
                                        classePai.listarEventos();
                                        classePai.atualizarDadosListagemEventos(evento);
                                        classePai.atualizarCalendario();
                                        this.dispose();
                                    }
                                }
                            }else{ // horas diferentes, com a final maior que a incial -- EDIÇÃO
                                if(controleEvento.editar(evento)){ // EXECUÇÃO DA EDIÇÃO
                                    JOptionPane.showMessageDialog(null,"Evento alterado com sucesso!");
                                    classePai.listarEventos();
                                    classePai.atualizarDadosListagemEventos(evento);
                                    classePai.atualizarCalendario();
                                    this.dispose();
                                }
                            }
                            
                        }else{ // Evento que termina em dia diferente -- PERMITE EDIÇÃO COM CONFIRMAÇÃO
                            int confirmacao = JOptionPane.showConfirmDialog(null,"O evento ocorrerá em um período superior a um DIA. Deseja prosseguir com o cadastro?","Confirmação de Cadastro", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if (confirmacao == JOptionPane.YES_OPTION) {
                                if(controleEvento.editar(evento)){ // EXECUÇÃO DA EDIÇÃO
                                    JOptionPane.showMessageDialog(null,"Evento alterado com sucesso!");
                                    classePai.listarEventos();
                                    classePai.atualizarDadosListagemEventos(evento);
                                    classePai.atualizarCalendario();
                                    this.dispose();
                                }
                            }
                        }
                    }else{ // Evento que termina em mês diferente -- PERMITE EDIÇÃO COM CONFIRMAÇÃO
                        int confirmacao = JOptionPane.showConfirmDialog(null,"O evento ocorrerá em um período superior a um MÊS. Deseja prosseguir com o cadastro?","Confirmação de Cadastro", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if (confirmacao == JOptionPane.YES_OPTION) {
                            if(controleEvento.editar(evento)){ // EXECUÇÃO DA EDIÇÃO
                                JOptionPane.showMessageDialog(null,"Evento alterado com sucesso!");
                                classePai.listarEventos();
                                classePai.atualizarDadosListagemEventos(evento);
                                classePai.atualizarCalendario();
                                this.dispose();
                            }
                        }
                    }
                }else{ // Evento que termina em ano diferente -- PERMITE EDIÇÃO COM CONFIRMAÇÃO
                    int confirmacao = JOptionPane.showConfirmDialog(null,"O evento ocorrerá em um período superior a um ANO. Deseja prosseguir com o cadastro?","Confirmação de Cadastro", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        if(controleEvento.editar(evento)){ // EXECUÇÃO DA EDIÇÃO
                            JOptionPane.showMessageDialog(null,"Evento alterado com sucesso!");
                            classePai.listarEventos();
                            classePai.atualizarDadosListagemEventos(evento);
                            classePai.atualizarCalendario();
                            this.dispose();
                        }
                    }
                }
            }  
    }
    
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
            java.util.logging.Logger.getLogger(EditarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkDiaInteiro;
    private javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelCadastrar;
    private javax.swing.JPanel panelDiaFinal;
    private javax.swing.JPanel panelDiaInicial;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JPanel panelImportancia;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtHoraFinal;
    private javax.swing.JFormattedTextField txtHoraInicial;
    // End of variables declaration//GEN-END:variables
}
