/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;

import edu.esprit.tunisiamall.JTableModels.ModelLocaux;
import edu.esprit.tunisiamall.dao.classes.LocalDao;
import edu.esprit.tunisiamall.entities.Local;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author antar
 */
public class GestionLocaux extends javax.swing.JFrame {

    /**
     * Creates new form GestionLocaux
     */
    public GestionLocaux() {
        initComponents();
        populateJTable();
        
    }
    
    public void populateJTable(){
        
        LocalDao ldao = new LocalDao();
        Local l = new Local();
        
 
        List<Local> list=ldao.afficherLocal();
        String[] columnName = {"Adresse","Etat"};
        Object[][] rows = new Object[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            
            rows[i][0] = list.get(i).getAdresse();
            
            if(list.get(i).getEtat()==1){
            rows[i][1] = "Réservé";
            }
            else{
            rows[i][1] = "Disponible";
            }
           
            
        }
        
        ModelLocaux model = new ModelLocaux(rows, columnName);
        TableLocaux.setModel(model);
        TableLocaux.setRowHeight(80);
        //TableLocal.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelAdresse = new javax.swing.JLabel();
        LabelEtat = new javax.swing.JLabel();
        TextFieldAdresse = new javax.swing.JTextField();
        TextFieldEtat = new javax.swing.JTextField();
        BtnAjout = new javax.swing.JButton();
        BtnSuppression = new javax.swing.JButton();
        BtnReservation = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableLocaux = new javax.swing.JTable();
        BtnRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(963, 568));
        setMinimumSize(new java.awt.Dimension(963, 568));

        LabelAdresse.setText("Adresse: ");

        LabelEtat.setText("Etat:");

        TextFieldAdresse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldAdresseFocusGained(evt);
            }
        });

        BtnAjout.setText("Ajouter");
        BtnAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjoutActionPerformed(evt);
            }
        });

        BtnSuppression.setText("Supprimer");

        BtnReservation.setText("Réserver");

        TableLocaux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableLocaux.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLocauxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableLocaux);

        BtnRetour.setText("Retour");
        BtnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAjout)
                        .addGap(94, 94, 94)
                        .addComponent(BtnSuppression)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnReservation))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelAdresse)
                            .addComponent(LabelEtat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldAdresse, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(TextFieldEtat))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(BtnRetour)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRetour))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelAdresse)
                            .addComponent(TextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelEtat)
                            .addComponent(TextFieldEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAjout)
                            .addComponent(BtnSuppression)
                            .addComponent(BtnReservation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableLocauxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLocauxMouseClicked
        // TODO add your handling code here:
        int i = TableLocaux.getSelectedRow();
        TableModel model = TableLocaux.getModel();
        TextFieldAdresse.setText(model.getValueAt(i,0).toString());
        TextFieldAdresse.setEditable(false);
        TextFieldEtat.setText(model.getValueAt(i,1).toString());
        TextFieldEtat.setEditable(false);
        if((model.getValueAt(i,1).toString())=="Réservé"){
            BtnReservation.setText("Libérer");
        }
        else{
            BtnReservation.setText("Réserver"); 
        }
    }//GEN-LAST:event_TableLocauxMouseClicked

    private void BtnAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjoutActionPerformed
        // TODO add your handling code here:
        Component frame = null;
        LocalDao ldao = new LocalDao();
        Local l = new Local();
        l.setAdresse(TextFieldAdresse.getText());
        l.setEtat(0);
        l.setEmplacement("Emplacement"+TextFieldAdresse.getText());
        if(ldao.ajouterLocal(l)){
        JOptionPane.showMessageDialog(frame, "Local Ajouté avec succés !");
        }
        else{
        JOptionPane.showMessageDialog(frame, "Local n'a pas été Ajouté avec succés !");
        }
        
        
        populateJTable();
        
    }//GEN-LAST:event_BtnAjoutActionPerformed

    private void TextFieldAdresseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldAdresseFocusGained
        // TODO add your handling code here:
        TextFieldEtat.setText("Disponible");
        TextFieldEtat.setEditable(false);
    }//GEN-LAST:event_TextFieldAdresseFocusGained

    private void BtnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetourActionPerformed
        // TODO add your handling code here:
        HomeAdmin HM = new HomeAdmin();
        HM.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnRetourActionPerformed

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
            java.util.logging.Logger.getLogger(GestionLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionLocaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionLocaux().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjout;
    private javax.swing.JButton BtnReservation;
    private javax.swing.JButton BtnRetour;
    private javax.swing.JButton BtnSuppression;
    private javax.swing.JLabel LabelAdresse;
    private javax.swing.JLabel LabelEtat;
    private javax.swing.JTable TableLocaux;
    private javax.swing.JTextField TextFieldAdresse;
    private javax.swing.JTextField TextFieldEtat;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
