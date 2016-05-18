/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;
import edu.esprit.tunisiamall.technique.DataSource;
import edu.esprit.tunisiamall.entities.Login;
import edu.esprit.tunisiamall.dao.classes.LoginDAO;
import edu.esprit.tunisiamall.entities.Produit;
import edu.esprit.tunisiamall.gui.ResponsableEnseigneGUI;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import com.bytescout.barcodereader.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author Safwene
 */
public class LoginQRcodeGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    
   
    private DaemonThread myThread = null;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    private boolean passingToInterface = false;
    
    
    class DaemonThread implements Runnable
    {
         
    protected volatile boolean runnable = false;

    @Override
    
    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
                
                if(webSource.grab())
                {
                   
                    
                    
		    	try
                        {
                            webSource.retrieve(frame);
			    Highgui.imencode(".bmp", frame, mem);
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buff = (BufferedImage) im;
			    Graphics g=ScannerCameraProduitjPanel.getGraphics();
                            

			    if (g.drawImage(buff, 0, 0, getWidth(), getHeight() -150 , 0, 0, buff.getWidth(), buff.getHeight(), null))
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
                                
                             
			    }
                            else{
                               
                                 Highgui.imwrite("D:\\test.jpg", frame);
                                 anaylseQrCode();
                                 
                                 
                                
                                
                            }
			 }
			 catch(Exception ex)
                         {
			    System.out.println("Error");
                         }
                }
            }
        }
     }
   }
     public void anaylseQrCode(){
         
        Reader reader = new Reader();
        reader.setRegistrationName("test");
        reader.setRegistrationKey("test");
        
        reader.setBarcodeTypesToFind(EnumSet.of(BarcodeType.QRCode, BarcodeType.UPCA));
        FoundBarcode[] foundBarcode = reader.readFromFile("D:\\test.jpg");
        
        for (FoundBarcode barcode : foundBarcode){
              
          
        Login login = new Login();
        login.setQRCode(barcode.getValue().substring(0, barcode.getValue().indexOf('(')));
        LoginDAO loginDAO = new LoginDAO();
        if (loginDAO.checkQRCode(login)[0].equals("RESPONSABLE")){
          
            try {
                this.setQRCodeMessage("QRCode Valide",true);                
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(500);
                this.dispose();
                this.passingToInterface = true;
            ResponsableEnseigneGUI responsableEnseigneGUI = ResponsableEnseigneGUI.getInstance();
            responsableEnseigneGUI.setIdResponsableEnseigne(Integer.parseInt(loginDAO.checkQRCode(login)[1]));
            responsableEnseigneGUI.setInformationsResponsableEnseigne();
                responsableEnseigneGUI.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginQRcodeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        
        else {
            this.setQRCodeMessage("QRCode Invalide",false);
        }
        
        
        
        
        }
    }
     public void setQRCodeMessage(String message, boolean status){
         
         this.QRCodeStatusjLabel.setText(message);
         if (status)
             this.QRCodeStatusjLabel.setForeground(Color.green);
         else 
             this.QRCodeStatusjLabel.setForeground(Color.red);
     }
    
    public LoginQRcodeGUI() {
        
        initComponents();
         webSource =new VideoCapture(0);

        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        this.setTitle("LOGIN");
        this.setResizable(false);
        this.setLocationRelativeTo(this);
   
        getConnectionDB();
        setQRCodeMessage("Cannot detect QRCode",false);

    }
    
    
    
    void getConnectionDB(){
                if (DataSource.getInstance() != null){
                    System.out.println("Connection Etablie !");
                }
                else {
                    System.out.println("Connection Non-etablie !");
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

        ScannerCameraProduitjPanel = new javax.swing.JPanel();
        QRCodeStatusjLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout ScannerCameraProduitjPanelLayout = new javax.swing.GroupLayout(ScannerCameraProduitjPanel);
        ScannerCameraProduitjPanel.setLayout(ScannerCameraProduitjPanelLayout);
        ScannerCameraProduitjPanelLayout.setHorizontalGroup(
            ScannerCameraProduitjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ScannerCameraProduitjPanelLayout.setVerticalGroup(
            ScannerCameraProduitjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(ScannerCameraProduitjPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 286, 214, -1));
        getContentPane().add(QRCodeStatusjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 397, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/11.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        webSource.release();
        if (!this.passingToInterface)
            System.exit(0);
        System.out.println("CLOSED ");
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(LoginQRcodeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginQRcodeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginQRcodeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginQRcodeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new LoginQRcodeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel QRCodeStatusjLabel;
    private javax.swing.JPanel ScannerCameraProduitjPanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
