/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

/**
 *
 * @author natan
 */
public class PanelImportanciaFixo extends javax.swing.JPanel {

    /**
     * Creates new form PanelImportanciaFixo
     */
    
    public PanelImportanciaFixo() {
        initComponents();
    }
    
    public void setImportancia(int importancia){
        switch(importancia){
            case 0:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPreto.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPreto.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPreto.png")));
                break;
            case 1:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPreto.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPreto.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPreto.png")));
                break;
            case 2:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPreto.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPreto.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPreto.png")));
                break;
            case 3:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPreto.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPreto.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPreto.png")));
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        estrela1 = new javax.swing.JLabel();
        estrela2 = new javax.swing.JLabel();
        estrela3 = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setOpaque(false);

        estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EstrelaVaziaPreto.png"))); // NOI18N

        estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EstrelaVaziaPreto.png"))); // NOI18N

        estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EstrelaVaziaPreto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(estrela1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(estrela2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(estrela3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(estrela1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            .addComponent(estrela3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(estrela2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estrela1;
    private javax.swing.JLabel estrela2;
    private javax.swing.JLabel estrela3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
