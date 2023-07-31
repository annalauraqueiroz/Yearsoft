/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import componentes.ButtonMenu;
import controller.CategoriaCTRL;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Usuario;

/**
 *
 * @author natan
 */
public class CadastroCategoria extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCategoria
     */
    
    private MenuPrincipal classePai;
    private Usuario usuario;
    
    private ButtonMenu btnCadastrar;
    
    public CadastroCategoria() {
        initComponents();
        
        btnCadastrar = new ButtonMenu();
        
        btnCadastrar.setLocation(0,0);
        btnCadastrar.setSize(panelCadastrar.getSize());
        btnCadastrar.setVisible(true);
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        panelCadastrar.add(btnCadastrar);
        
        // Corresponde ao primeiro modelo e já vem selecionado
        rdModelo1.setSelected(true);
    }
    
    /** Abre a tela de cadastro com o envio do usuário proprietário da categoria */
    public void abrirCadastro(Usuario usuario, MenuPrincipal menu){
        classePai = menu;
        this.usuario = usuario;
        this.setVisible(true);
    }
    
    /** Verifica se a string do campo txtCor corresponde a uma cor válida */
    public boolean checarCamposCor(){
        String cor = txtCor.getText();
        try{
            if(cor.charAt(0)!='[' || cor.charAt(cor.length()-1)!=']'){
                JOptionPane.showMessageDialog(null, "A formatação do texto é inválida para a conversão (Ausência de '[' e ']').");
                return false;
            }else{
                return true;
            }
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "A formatação do texto é inválida para a conversão.");
            return false;
        }
    }

    
    /** Limpa todos os campos da tela de cadastro (Categorias) */
    public void limparCampos(){
        txtNome.setText("");
        txtCor.setText("");
        btnSelecionarCor.setBackground(new Color(252,255,245));
        rdModelo1.setSelected(true);
        lblModelo.setText("");
        lblModelo.setBackground(new Color(10,24,39));
        lblModelo.setForeground(new Color(252,255,245));
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
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        panelCadastrar = new javax.swing.JPanel();
        txtCor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdModelo1 = new javax.swing.JRadioButton();
        rdModelo2 = new javax.swing.JRadioButton();
        lblModelo = new javax.swing.JLabel();
        btnSelecionarCor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelFundo.setBackground(new java.awt.Color(252, 255, 245));

        jLabel1.setBackground(new java.awt.Color(10, 24, 39));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 255, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Categoria");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cor:");

        txtNome.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNomeCaretUpdate(evt);
            }
        });

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

        txtCor.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraste:");

        rdModelo1.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        rdModelo1.setText("Modelo 1");
        rdModelo1.setOpaque(false);
        rdModelo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdModelo1ActionPerformed(evt);
            }
        });

        rdModelo2.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        rdModelo2.setText("Modelo 2");
        rdModelo2.setOpaque(false);
        rdModelo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdModelo2ActionPerformed(evt);
            }
        });

        lblModelo.setBackground(new java.awt.Color(10, 24, 39));
        lblModelo.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(252, 255, 245));
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModelo.setOpaque(true);

        btnSelecionarCor.setBackground(new java.awt.Color(252, 255, 245));
        btnSelecionarCor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnSelecionarCor.setOpaque(true);
        btnSelecionarCor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelecionarCorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelecionarCorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelecionarCorMouseExited(evt);
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
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(43, 43, 43)
                                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelFundoLayout.createSequentialGroup()
                                        .addComponent(btnSelecionarCor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCor))
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelFundoLayout.createSequentialGroup()
                                        .addComponent(rdModelo1)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdModelo2)))
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                                .addComponent(panelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFundoLayout.createSequentialGroup()
                        .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSelecionarCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdModelo1)
                    .addComponent(rdModelo2))
                .addGap(18, 18, 18)
                .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdModelo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdModelo1ActionPerformed
        rdModelo1.setSelected(true);
        rdModelo2.setSelected(false);
        lblModelo.setBackground(new Color(10,24,39));
    }//GEN-LAST:event_rdModelo1ActionPerformed

    private void rdModelo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdModelo2ActionPerformed
        rdModelo2.setSelected(true);
        rdModelo1.setSelected(false);
        lblModelo.setBackground(new Color(204,217,206));
    }//GEN-LAST:event_rdModelo2ActionPerformed

    private void btnSelecionarCorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelecionarCorMouseClicked
        Color color = null;
        color = JColorChooser.showDialog(null, null, color);
        if(color==null){
            btnSelecionarCor.setBackground(new Color(252,255,245));
            txtCor.setText("");
            lblModelo.setForeground(new Color(252,255,245));
        }else{
            String cor = color.toString().substring(14);
            cor = cor.replace("r=", "");
            cor = cor.replace("g=", "");
            cor = cor.replace("b=", "");
            txtCor.setText(cor);
            btnSelecionarCor.setBackground(color);
            lblModelo.setForeground(color);
        }
    }//GEN-LAST:event_btnSelecionarCorMouseClicked

    private void btnSelecionarCorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelecionarCorMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSelecionarCorMouseEntered

    private void btnSelecionarCorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelecionarCorMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSelecionarCorMouseExited

    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
        if(checarCamposCor()){
            String cor = txtCor.getText();
            String[] colors = cor.substring(1,cor.length()-1).split(",");
                Color color = new Color(
                    Integer.parseInt(colors[0].trim()),
                    Integer.parseInt(colors[1].trim()),
                    Integer.parseInt(colors[2].trim()));
            btnSelecionarCor.setBackground(color);
            lblModelo.setForeground(color);
        }
    }//GEN-LAST:event_txtCorActionPerformed

    private void txtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeCaretUpdate
        lblModelo.setText(txtNome.getText());
    }//GEN-LAST:event_txtNomeCaretUpdate

    public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt){
        String nome = txtNome.getText();
        String cor = txtCor.getText();
        int contraste;
        if(rdModelo1.isSelected()){
            contraste = 1;
        }else{
            contraste = 2;
        }
        if(nome.equals("") || cor.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, preencha todas as informações antes de submetê-las.");
        }else{
            if(checarCamposCor()){
                Categoria categoria = new Categoria(nome, cor, contraste, usuario.getLogin());
                CategoriaCTRL controleCategoria = new CategoriaCTRL();
                if(controleCategoria.cadastrar(categoria)){
                    JOptionPane.showMessageDialog(null, "Categoria '"+categoria.getNome()+"' cadastrada com sucesso!");
                    classePai.listarCategorias();
                    limparCampos();
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
            java.util.logging.Logger.getLogger(CadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSelecionarCor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JPanel panelCadastrar;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JRadioButton rdModelo1;
    private javax.swing.JRadioButton rdModelo2;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
