/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;



import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 *
 * @author Mariem
 */
public class PointMarque extends javax.swing.JFrame {

    /**
     * Creates new form PointMarque
     */
    public PointMarque() {
        
//        
//         try{
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		}
//		catch(Exception e){}
//		
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//f.setSize(300, 60);
//		Banniere banniere = new Banniere("Ce texte defile de droite � gauche", 30);
//		hh.add(banniere);
//		//f.setLocationRelativeTo(null);
//		//f.setVisible(true);
//		//banniere.start();
        
        
        
  
        initComponents();
         getContentPane().setBackground(Color.decode("#FFFFFF"));
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

        nomMarque = new javax.swing.JLabel();
        imageMarque = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bonus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusableWindowState(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nomMarque, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 11, 68, 46));
        getContentPane().add(imageMarque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 439, 320));

        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel1.setText("Votre bonus ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 139, -1, -1));

        bonus.setText("tryttj");
        getContentPane().add(bonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 271, -1, -1));

        jLabel2.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel2.setText("Votre point :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 266, 108, 22));

        money.setText("jLabel3");
        getContentPane().add(money, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 347, -1, -1));

        jLabel3.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        jLabel3.setText("Vous bénéficiez de :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 341, -1, 24));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/ptmarque.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 840, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PointMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PointMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PointMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PointMarque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PointMarque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel bonus;
    public javax.swing.JLabel imageMarque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel money;
    public javax.swing.JLabel nomMarque;
    // End of variables declaration//GEN-END:variables
}
