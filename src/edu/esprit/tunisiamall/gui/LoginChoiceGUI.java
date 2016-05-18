/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;
import edu.esprit.tunisiamall.gui.LoginGUI;
import edu.esprit.tunisiamall.gui.LoginQRcodeGUI;
import edu.esprit.tunisiamall.technique.DataSource;
import edu.esprit.tunisiamall.entities.Login;
import edu.esprit.tunisiamall.dao.classes.LoginDAO;
import edu.esprit.tunisiamall.entities.Produit;
import edu.esprit.tunisiamall.gui.ResponsableEnseigneGUI;
import org.opencv.core.Core;
import edu.esprit.tunisiamall.technique.DataSource;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Safwene
 */
public class LoginChoiceGUI extends javax.swing.JFrame {

    
    
    
    /**
     * Creates new form LoginGUI
     */
    public LoginChoiceGUI() {
        initComponents();
        this.setTitle("LOGIN");
        this.HelpjLabel.setText("");
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.setVisible(true);
        this.getConnectionDB();
        this.DessinerBesoinDaide("Pas Encore Inscrit ?",40);
        this.LoginUsernamejButton.setEnabled(true);
                this.QRCodejButton.setEnabled(true);
        
        
   

    }
    
    
      void getConnectionDB(){
          
          
          
        try {
            this.DBconnectionjLabel.setIcon(new ImageIcon("src/edu/esprit/tunisiamall/images/Database-echec-icon.png"));
            this.LoginUsernamejButton.setEnabled(false);
            this.QRCodejButton.setEnabled(false);
            Thread.sleep(1000);
            
            
            if (DataSource.getInstance() != null){
                this.DBconnectionjLabel.setIcon(new ImageIcon("src/edu/esprit/tunisiamall/images/Database-Accept-icon.png"));
                
                
            }
            else {
                this.DBconnectionjLabel.setIcon(new ImageIcon("src/edu/esprit/tunisiamall/images/Database-echec-icon.png"));
                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginChoiceGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
      
      
      public void DessinerBesoinDaide(String mot, int sleep){
          
          for (int i=0;i<mot.length();i++){
              try {
                  String word ="";
                  for (int j=0;j<=i;j++){
                      word += mot.charAt(j);
                  }
                  this.HelpjLabel.setText(word);
                  
                  Thread.sleep(sleep);
              } catch (InterruptedException ex) {
                  Logger.getLogger(LoginChoiceGUI.class.getName()).log(Level.SEVERE, null, ex);
              }
              
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

        jLabelLogo = new javax.swing.JLabel();
        QRCodejButton = new javax.swing.JButton();
        LoginUsernamejButton = new javax.swing.JButton();
        QRCodeUsernameLogojLabel = new javax.swing.JLabel();
        DBconnectionjLabel = new javax.swing.JLabel();
        HelpjLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/logo-Tunisia-Mall.jpg"))); // NOI18N

        QRCodejButton.setText("QRcode");
        QRCodejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QRCodejButtonActionPerformed(evt);
            }
        });

        LoginUsernamejButton.setText("Login & password");
        LoginUsernamejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginUsernamejButtonActionPerformed(evt);
            }
        });

        QRCodeUsernameLogojLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/login_icon.png"))); // NOI18N

        DBconnectionjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/Database-Accept-icon.png"))); // NOI18N

        HelpjLabel.setText("Besoin d'aide ?");
        HelpjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpjLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DBconnectionjLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoginUsernamejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(QRCodejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HelpjLabel)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabelLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(QRCodeUsernameLogojLabel)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelLogo)
                .addGap(18, 18, 18)
                .addComponent(QRCodeUsernameLogojLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginUsernamejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QRCodejButton)
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HelpjLabel)
                            .addComponent(DBconnectionjLabel))
                        .addGap(8, 8, 8))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginUsernamejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginUsernamejButtonActionPerformed
       this.setVisible(false);
       LoginGUI loginGUI = new LoginGUI();
       loginGUI.setVisible(true);
       
        
    }//GEN-LAST:event_LoginUsernamejButtonActionPerformed

    private void QRCodejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QRCodejButtonActionPerformed
       
        this.setVisible(false);
        LoginQRcodeGUI loginQRcodeGUI = new LoginQRcodeGUI();
        loginQRcodeGUI.setVisible(true);
    
    }//GEN-LAST:event_QRCodejButtonActionPerformed

    private void HelpjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpjLabelMouseClicked
  
       this.setVisible(false);
       iNSCRIPTION insc= new iNSCRIPTION();
       insc.setVisible(true);
        
        
    }//GEN-LAST:event_HelpjLabelMouseClicked

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
            java.util.logging.Logger.getLogger(LoginChoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginChoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginChoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginChoiceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     //   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //</editor-fold>
        //</editor-fold>
     //   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginChoiceGUI();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DBconnectionjLabel;
    private javax.swing.JLabel HelpjLabel;
    private javax.swing.JButton LoginUsernamejButton;
    private javax.swing.JLabel QRCodeUsernameLogojLabel;
    private javax.swing.JButton QRCodejButton;
    private javax.swing.JLabel jLabelLogo;
    // End of variables declaration//GEN-END:variables
}