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
public class importanciaCalendarioFixo extends javax.swing.JPanel {

    /**
     * Creates new form importanciaCalendarioFixo
     */
    public importanciaCalendarioFixo() {
        initComponents();
    }

    public void setImportancia(int importancia){
        switch(importancia){
            case 0:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPretoCalendario.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPretoCalendario.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPretoCalendario.png")));
                break;
            case 1:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPretoCalendario.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPretoCalendario.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPretoCalendario.png")));
                break;
            case 2:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPretoCalendario.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPretoCalendario.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaVaziaPretoCalendario.png")));
                break;
            case 3:
                estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPretoCalendario.png")));
                estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPretoCalendario.png")));
                estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/EstrelaPretoCalendario.png")));
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

        estrela1 = new javax.swing.JLabel();
        estrela2 = new javax.swing.JLabel();
        estrela3 = new javax.swing.JLabel();

        setOpaque(false);

        estrela1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EstrelaVaziaPretoCalendario.png"))); // NOI18N

        estrela2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EstrelaVaziaPretoCalendario.png"))); // NOI18N

        estrela3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EstrelaVaziaPretoCalendario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(estrela1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(estrela2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(estrela3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(estrela1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(estrela2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(estrela3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estrela1;
    private javax.swing.JLabel estrela2;
    private javax.swing.JLabel estrela3;
    // End of variables declaration//GEN-END:variables
}
