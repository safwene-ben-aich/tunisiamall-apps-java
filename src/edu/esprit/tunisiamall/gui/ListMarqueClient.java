/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;

import edu.esprit.tunisiamall.dao.classes.CarteFideliteDao;
import edu.esprit.tunisiamall.entities.CarteFidelite;
import edu.esprit.tunisiamall.dao.classes.ClientDao;
import edu.esprit.tunisiamall.dao.classes.MarqueDao;

import edu.esprit.tunisiamall.entities.Client;
import edu.esprit.tunisiamall.entities.Marque;
import edu.esprit.tunisiamall.entities.TheModal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Mariem
 */
public class ListMarqueClient extends javax.swing.JFrame {

    /**
     * Creates new form ListCarteClient
     */
            PointMarque pm =  new PointMarque();

    public ListMarqueClient() {
        initComponents();
//          MarqueDao mqDAO= new MarqueDao();
//         List <Marque> liste = new ArrayList<Marque>();
//         Client clt = new Client();
//         ClientDao cltdao= new ClientDao();
//         //int id=clt.getId();
//        String a= loginclient.getText().toString();
//        System.out.println("login client----------------------------------------"+loginclient.getText());
//        int ID=cltdao.researchid(loginclient.getText());
//        System.out.println("login client----------------------------------------"+ID);
//        liste= mqDAO.afficherMarqueClient(ID);
//        //liste= mqDAO.afficherMarqueClient(30);
//
//          String[] columnName = {"Marque"};
//        Object[][] rows = new Object[liste.size()][1];
//        for(int i = 0; i < liste.size(); i++){
//            rows[i][0] = liste.get(i).getNom();
//        }
//        TheModal model = new TheModal(rows, columnName);
//        jTable1.setModel(model);
//        jTable1.setRowHeight(50);  
//      // 888
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        loginclient = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Marque"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 96, 460, 141));

        loginclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginclientMouseClicked(evt);
            }
        });
        getContentPane().add(loginclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/listmarq.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          MarqueDao mr=new MarqueDao();
       
         int index =jTable1.getSelectedRow();
        TheModal model=(TheModal) jTable1.getModel();
        String nom= model.getValueAt(index, 0).toString();
       // System.out.println(nom);
        
     //  this.setVisible(false);
      
        pm.pack();
        pm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pm.setVisible(true);
        pm.nomMarque.setText(nom);
       ImageIcon im=new ImageIcon( mr.afficherImageMarque(nom));
        //Image image2= im.getImage().getScaledInstance(pm.imageMarque.getWidth(),pm.imageMarque.getHeight(),Image.SCALE_SMOOTH);
       String val=null;
        pm.imageMarque.setIcon(im );
        CarteFideliteDao cf= new CarteFideliteDao();
        ClientDao cdao= new ClientDao();
       int ID=cdao.researchid(loginclient.getText());
        //= 
       CarteFidelite f= cf.afficherBonus(nom,ID);
      //CarteFidelite f= cf.afficherBonus(nom,30);

       int c= f.getNbPoint();
       float a= f.getSeuil();      
        pm.bonus.setText(""+c);
       // pm.bonus1.setName(""+c);
        
        pm.money.setText(""+c*200+"DT");
        
        
       // pm.money.setText(""+a);
        pm.show();
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
  
      // 888
    }//GEN-LAST:event_jTable1KeyPressed

    private void loginclientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginclientMouseClicked
        // TODO add your handling code here:
                 MarqueDao mqDAO= new MarqueDao();
         List <Marque> liste = new ArrayList<Marque>();
         Client clt = new Client();
         ClientDao cltdao= new ClientDao();
         //int id=clt.getId();
        String a= loginclient.getText().toString();
        System.out.println("login client----------------------------------------"+loginclient.getText());
        int ID=cltdao.researchid(loginclient.getText());
        System.out.println("login client----------------------------------------"+ID);
        liste= mqDAO.afficherMarqueClient(ID);
        //liste= mqDAO.afficherMarqueClient(30);

          String[] columnName = {"Marque"};
        Object[][] rows = new Object[liste.size()][1];
        for(int i = 0; i < liste.size(); i++){
            rows[i][0] = liste.get(i).getNom();
        }
        TheModal model = new TheModal(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(50);
    }//GEN-LAST:event_loginclientMouseClicked

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
            java.util.logging.Logger.getLogger(ListMarqueClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMarqueClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMarqueClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMarqueClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMarqueClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel loginclient;
    // End of variables declaration//GEN-END:variables
}
