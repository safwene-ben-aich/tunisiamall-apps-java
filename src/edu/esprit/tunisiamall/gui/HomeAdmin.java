/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;

/**
 *
 * @author dali
 */
public class HomeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form XSSD
     */
    public HomeAdmin() {
        this.setTitle("Administration");
        //this.setLocationRelativeTo(null);
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loca = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        add1 = new javax.swing.JLabel();
        client = new javax.swing.JLabel();
        marque = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(964, 570));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        loca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/homeadmin.png"))); // NOI18N
        loca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                locaKeyPressed(evt);
            }
        });
        getContentPane().add(loca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 570));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 30, 40));

        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add1MouseClicked(evt);
            }
        });
        getContentPane().add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 190));

        client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientMouseClicked(evt);
            }
        });
        getContentPane().add(client, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 180, 190));

        marque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marqueMouseClicked(evt);
            }
        });
        getContentPane().add(marque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 190, 190));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 200, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseClicked
        // TODO add your handling code here:
        Formulairresp formulairresp = new Formulairresp();
        formulairresp.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_add1MouseClicked

    private void clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientMouseClicked
       FormulaireClient formulaireClient = new FormulaireClient();
       formulaireClient.setVisible(true);
       this.setVisible(false);
       // TODO add your handling code here:
    }//GEN-LAST:event_clientMouseClicked

    private void marqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marqueMouseClicked
       
        AddMarque addm= new AddMarque();
        addm.setVisible(true);
        this.setVisible(false);
       // TODO add your handling code here:

    }//GEN-LAST:event_marqueMouseClicked

    private void locaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locaKeyPressed
         // TODO add your handling code here:
        GestionLocaux GL = new GestionLocaux();
        GL.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_locaKeyPressed

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
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add1;
    private javax.swing.JLabel client;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel loca;
    private javax.swing.JLabel marque;
    // End of variables declaration//GEN-END:variables
}
