/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.gui;
import com.bytescout.barcodereader.BarcodeType;
import com.bytescout.barcodereader.FoundBarcode;
import com.bytescout.barcodereader.Reader;
import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import edu.esprit.tunisiamall.JTableModels.ModelAideDecision;
import edu.esprit.tunisiamall.dao.classes.BoutiqueDao;
import edu.esprit.tunisiamall.dao.classes.ProduitDAO;
import edu.esprit.tunisiamall.dao.classes.ResponsableEnseigneDAO;
import edu.esprit.tunisiamall.entities.Produit;
import edu.esprit.tunisiamall.entities.ResponsableEnseigne;
import edu.esprit.tunisiamall.technique.DataSource;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import edu.esprit.tunisiamall.entities.Log;
import edu.esprit.tunisiamall.dao.classes.LogDAO;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.opencv.highgui.Highgui;
import edu.esprit.tunisiamall.dao.classes.TwitterDAO;
import edu.esprit.tunisiamall.entities.Twitter;
import java.util.List;
import twitter4j.Status;
import edu.esprit.tunisiamall.dao.classes.NotesResponsableDAO;
import edu.esprit.tunisiamall.entities.NotesResponsable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.VideoCapture;
import edu.esprit.tunisiamall.dao.classes.DBUtils;
import edu.esprit.tunisiamall.dao.classes.LocalDao;
import edu.esprit.tunisiamall.dao.classes.MarqueDao;
import edu.esprit.tunisiamall.entities.Boutique;
import edu.esprit.tunisiamall.entities.Local;
import edu.esprit.tunisiamall.entities.Marque;
import java.io.FileInputStream;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

import edu.esprit.tunisiamall.JTableModels.ModelGestionBoutique;
import java.awt.BorderLayout;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author Safwene
 */





public class ResponsableEnseigneGUI extends javax.swing.JFrame {
    

    /**
     * Creates new form ResponsableEnseigneGUI
     */
    
    /***INIIALISATION PARTIE ANTAR ***/
    String s; 
    
    
    /**** FIN INSIALISATION PARTIE ANTAR ***/
    
    
    
    
    private int idResponsableEnseigne;
    private int idMarque;
    private DaemonThread myThread = null;
    private DaemonThreadTwitter myTwitterThread = null;
    private ResponsableEnseigne responsableEnseigne;
    private String imageResponsableEnseingePath;
    private String imageProduitPath="src\\edu\\esprit\\tunisiamall\\images\\zara.jpg";
    private RunnableDemo R1 = new RunnableDemo( "Thread-1");
    
    private ResponsableEnseigneDAO responsableEnseigneDAO;
    
    
    private Log log = new Log();
    LogDAO logDAO = new LogDAO();
    
    private NotesResponsable notesResponsable = new NotesResponsable();
    NotesResponsableDAO notesResponsableDAO = new NotesResponsableDAO();
    
    
    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    
    
   
    
    
    /***PARTIE PRODUIT ****/
    
    
    
    
    
     
       
    
    
      
        
       
         
         
         
    
    
    
    
    
    
    
    
    
    
    
    
   
    
  
    
  
    
    
    
    /***ANIMATION METHODS ****/
    public boolean playingWithBackground(String classeName){
      new Thread() {
    @Override public void run () {
        for (int i=0;i<3;i++){
            
      if (classeName == "PRODUIT"){      
      verifChampsProduit();
      }
      else if (classeName == "RESPONSABLE_ENSEIGNE"){
          verifChampsResponsableEnseigne();
      }
      
        try {
            this.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
          if (classeName == "PRODUIT"){      
      setDefaultInputProduit();
      }
      else if (classeName == "RESPONSABLE_ENSEIGNE"){
          setDefaultInputResponsableEnseigne();
      }
 
            try {
                this.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        SwingUtilities.invokeLater(new Runnable(){
        @Override public void run() {
          repaint();
          revalidate();
        }
      });
    }
    }
  }.start();
    if (classeName == "PRODUIT"){      
      return (verifChampsProduit());
      }
      else if (classeName == "RESPONSABLE_ENSEIGNE"){
      return (verifChampsResponsableEnseigne());
      }
        return false;
    }
    public void chargement(javax.swing.JLabel labelToAnimate){
            labelToAnimate.setText("Chargement");
            for (int i=0;i<3;i++){
                try {
                    labelToAnimate.setText("Chargement.  ");
                    Thread.sleep(200);
                    labelToAnimate.setText("Chargement.. ");
                    Thread.sleep(200);
                    labelToAnimate.setText("Chargement...");
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            labelToAnimate.setText(""); 
    }
    /***FIN ANIMATION METHODS ***/
    
    /** LOG FILE ***/
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
               
                    
		    	try
                        {
                            
                
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
            		    }
                            else{
                                chargement(ChargementLogjLabel);
                                getLog();
                               
                                
                                Thread.sleep(10000);
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
    public void writeOnLogFile(String message){
     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        logDAO.writeLogFile(message+" "+dateFormat.format(date),log);
    }
    public void getLog(){
        this.logjTextArea.setText((this.logDAO.readLogFile(this.log)));
    }
    /** FIN LOG FILE **/
    
   /**CLASS SINGLETON ***/
    private ResponsableEnseigneGUI() {
        
        
        initComponents();
        
        this.setLocationRelativeTo(this);
       
        log.setFileName("src\\edu\\esprit\\tunisiamall\\tests\\testlog.txt");
        this.notesResponsable.setFileName("src\\edu\\esprit\\tunisiamall\\tests\\testnotes.txt");
        this.MesNotesjTextArea.setText(this.notesResponsableDAO.readMesNotesFile(notesResponsable));
        
        this.TwitterjTextArea.setEditable(false);
        this.logjTextArea.setEditable(false);
        
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
    /*
        myTwitterThread = new DaemonThreadTwitter();
        Thread tTwitter = new Thread(myTwitterThread);
        tTwitter.setDaemon(true);
        myTwitterThread.runnable = true;
        tTwitter.start();
      */ 
        
        /*** APPEL METHODES BOUTIQUE  ***/
        
        RemplirComboMarque();
        RemplirComboLocal();
        populateJTable();
    
        /*** FIN APPEL METHODES BOUTIQUE ***/
        
        
        
    
            
    }
    private static class ResponsableEnseigneGUIHolder{
        
        private final static ResponsableEnseigneGUI instance = new ResponsableEnseigneGUI();
    
    }
    public static ResponsableEnseigneGUI getInstance(){
        return ResponsableEnseigneGUIHolder.instance;
    }
    /**FIN CLASSE SINGLETON **/
    
    /**MANIPULATION INTERFACE RESPONABLE ***/
    public void setInformationsResponsableEnseigne(){
                     
                     
                     ResponsableEnseigneDAO responsableEnseigneDAO = new ResponsableEnseigneDAO();
                     ResponsableEnseigne responsableEnseigneToDisplay = new ResponsableEnseigne();
                     responsableEnseigneToDisplay = responsableEnseigneDAO.findResponsableEnseigneById(this.idResponsableEnseigne);
                     this.cinResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getCin());
                     this.nomResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getNom());
                     this.prenomResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getPrenom());
                     this.loginResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getLogin());
                     this.passwordResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getPassword());
                     this.mailResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getMail());
                     this.TelephoneResponsableEnseigneTextField.setText(responsableEnseigneToDisplay.getTelephone());
                     this.AdressejTextArea.setText(responsableEnseigneToDisplay.getAdresse());
                     this.ImagejLabel.setIcon(new ImageIcon(responsableEnseigneToDisplay.getImage()));
                     this.changeStateInterfaceResponsable(false);
                   
                     String indicationSexe="";
                     if (responsableEnseigneToDisplay.getSexe().toUpperCase().equals("HOMME")){
                         indicationSexe = "Mr.";
                     }
                     else {
                         indicationSexe = "Mme.";
                     }
                     
                     
                     
                     this.setTitle("RESPONSABLE D'ENSEIGNE - "+indicationSexe+responsableEnseigneToDisplay.getNom()+" "+responsableEnseigneToDisplay.getPrenom());
                     this.idMarque = responsableEnseigneDAO.findIDMarqueByIDResponsable(this.idResponsableEnseigne);
                     this.jTableProduit.setRowSelectionAllowed(false);
            updateTableProduit();
                     
                        
                        this.jTableProduit.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            
            
            if (jTableProduit.getRowSelectionAllowed()){
            Produit produit = new Produit();
            produit.setReference(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 0).toString());
            produit.setNom(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 1).toString());
          
            produit.setType(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 2).toString());
          
            produit.setPrix(Float.parseFloat(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 3).toString()));
            
            produit.setTauxReduction(Float.parseFloat(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 4).toString()));
            produit.setNombrePoint(Integer.parseInt(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 5).toString()));
             produit.setPhoto((jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 6).toString()));
            produit.setDescription((jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 7).toString()));
              produit.setQuantite(Integer.parseInt(jTableProduit.getValueAt(jTableProduit.getSelectedRow(), 8).toString()));
           
            System.out.println(produit.toString());
            
            setInformationProduit(produit, false);
        }
        }
    });
    
                      /*** APPEL METHODES RAPPORT ***/
         populateJTableRapport();
         RemplirAlert();
         prepareSTAT();
        /*** FIN APPEL METHODES RAPPORT ***/
        
                     }
    public void changeStateInterfaceResponsable(boolean  state){
                     this.ModifierPhotoREsponsablejButton.setEnabled(state);
                     this.modifierResponsableEnseigneButton.setEnabled(state);
                     this.nomResponsableEnseigneTextField.setEnabled(state);
                     this.prenomResponsableEnseigneTextField.setEnabled(state);
                     this.cinResponsableEnseigneTextField.setEnabled(state);
                     this.mailResponsableEnseigneTextField.setEnabled(state);
                     this.mailResponsableEnseigneTextField.setEnabled(state);
                     this.TelephoneResponsableEnseigneTextField.setEnabled(state);
                     this.AdressejTextArea.setEnabled(state);
                     this.loginResponsableEnseigneTextField.setEnabled(state);
                     this.passwordResponsableEnseigneTextField.setEnabled(state);
    }
    public void setDefaultInputResponsableEnseigne(){
         
        this.nomResponsableEnseigneTextField.setBackground(Color.white);
        this.prenomResponsableEnseigneTextField.setBackground(Color.white);
        this.cinResponsableEnseigneTextField.setBackground(Color.white);
        this.mailResponsableEnseigneTextField.setBackground(Color.white);
        this.TelephoneResponsableEnseigneTextField.setBackground(Color.white);
        this.AdressejTextArea.setBackground(Color.white);
        this.loginResponsableEnseigneTextField.setBackground(Color.white);
        this.passwordResponsableEnseigneTextField.setBackground(Color.white);
     
    }
    public boolean verifChampsResponsableEnseigne(){
   
        boolean state = true;
      
        if (!Pattern.matches("[a-zA-Z_ ]+",this.nomResponsableEnseigneTextField.getText())){
            
            this.nomResponsableEnseigneTextField.setBackground(Color.red);
            state =false;
        }
        
         if (!Pattern.matches("[a-zA-Z_ ]+",this.prenomResponsableEnseigneTextField.getText())){
            this.prenomResponsableEnseigneTextField.setBackground(Color.red);
            state=false;
         }
         
        if (!Pattern.matches("[0-9]+",this.cinResponsableEnseigneTextField.getText()) || (this.cinResponsableEnseigneTextField.getText().length()!=8) ){
            this.cinResponsableEnseigneTextField.setBackground(Color.red);
            state=false;
        }
          if (!Pattern.matches("[a-zA-Z@.]+",this.mailResponsableEnseigneTextField.getText()) ||  (this.mailResponsableEnseigneTextField.getText().indexOf('@')==-1) || (this.mailResponsableEnseigneTextField.getText().indexOf('.')==-1) || ( this.mailResponsableEnseigneTextField.getText().lastIndexOf('.') <  this.mailResponsableEnseigneTextField.getText().indexOf('@'))){
            this.mailResponsableEnseigneTextField.setBackground(Color.red);
            state=false;
          }
        
        if (!Pattern.matches("[0-9]+",this.TelephoneResponsableEnseigneTextField.getText()) || ((this.TelephoneResponsableEnseigneTextField.getText().length()!=8) && (this.TelephoneResponsableEnseigneTextField.getText().length()!=13 ))){
            this.TelephoneResponsableEnseigneTextField.setBackground(Color.red);
            state=false;
        }
        if (this.AdressejTextArea.getText().isEmpty()){
            this.AdressejTextArea.setBackground(Color.red);
            state=false;
        }
        if (this.loginResponsableEnseigneTextField.getText().isEmpty()){
            this.loginResponsableEnseigneTextField.setBackground(Color.red);
            state=false;
        }
        if (this.passwordResponsableEnseigneTextField.getText().isEmpty()){
            this.passwordResponsableEnseigneTextField.setBackground(Color.red);
            state=false;
        }
        return state;
    }
    public void setIdResponsableEnseigne (int idResponsableEnseigne){
        this.idResponsableEnseigne = idResponsableEnseigne;
    }
    public int getIdResponsableEnseigne(){
        return this.idResponsableEnseigne;
    }
    /**FIN MANIPULATION INTERFACE RESPONSABLE ***/
    
    
    /*** DEBUT MANIPULATION INTERFACE PRODUIT ***/
    public boolean verifChampsProduit(){
   
        boolean state = true;
      
        if (!Pattern.matches("[a-zA-Z0-9-:]+",this.ReferencesProduitjTextField.getText())){
            this.ReferencesProduitjTextField.setBackground(Color.red);
            state =false;
        }
        if (!Pattern.matches("[a-zA-Z -]+",this.NomProduitjTextField.getText())){
            this.NomProduitjTextField.setBackground(Color.red);
            state =false;
        }
        if (!Pattern.matches("[a-zA-Z]+",this.TypeProduitjTextField.getText())){
            this.TypeProduitjTextField.setBackground(Color.red);
            state =false;
        }
        if (!Pattern.matches("[0-9.]+",this.PrixProduitjTextField.getText()) || (Float.parseFloat(this.PrixProduitjTextField.getText()) <= 0)){
            this.PrixProduitjTextField.setBackground(Color.red);
            state =false;
        }
          if (!Pattern.matches("[0-9.]+",this.TauxReductionProduitjTextField.getText())){
            this.TauxReductionProduitjTextField.setBackground(Color.red);
            state =false;
        }
         if (!Pattern.matches("[0-9]+",this.NombrePointProduitjTextField.getText()) || (Integer.parseInt(this.NombrePointProduitjTextField.getText())<=0)){
            this.NombrePointProduitjTextField.setBackground(Color.red);
            state =false;
        }
        if (!Pattern.matches("[0-9]+",this.QuantiteProduitjTextField.getText()) ||(Integer.parseInt(this.QuantiteProduitjTextField.getText()) <=0 )){
            this.QuantiteProduitjTextField.setBackground(Color.red);
            state =false;
        }
         if (this.DescriptionProduitjTextArea.getText().isEmpty()){
            this.DescriptionProduitjTextArea.setBackground(Color.red);
            state =false;
        }
        
        
        return state;
    }
    public void setDefaultInputProduit(){
            this.ReferencesProduitjTextField.setBackground(Color.white);
            this.NomProduitjTextField.setBackground(Color.white);
            this.TypeProduitjTextField.setBackground(Color.white);
            this.PrixProduitjTextField.setBackground(Color.white);
            this.TauxReductionProduitjTextField.setBackground(Color.white);
            this.NombrePointProduitjTextField.setBackground(Color.white);
            this.QuantiteProduitjTextField.setBackground(Color.white);
            this.DescriptionProduitjTextArea.setBackground(Color.white);
     }
    public void clearInputProduit(){
            this.ReferencesProduitjTextField.setText("");
            this.NomProduitjTextField.setText("");
            this.TypeProduitjTextField.setText("");
            this.PrixProduitjTextField.setText("");
            this.TauxReductionProduitjTextField.setText("");
            this.NombrePointProduitjTextField.setText("");
            this.QuantiteProduitjTextField.setText("");
            this.DescriptionProduitjTextArea.setText("");
            this.imageProduitPath="src\\edu\\esprit\\tunisiamall\\images\\zara.jpg";
            this.ImageProduitjLabel.setIcon(new ImageIcon(this.imageProduitPath));
    }
    class RunnableDemo implements Runnable {
          Produit produitToDisplay = new Produit();
          ProduitDAO produitDAO = new ProduitDAO();
   public Thread t;
   private String threadName;
   boolean suspended = false;
   

   RunnableDemo( String name){
       threadName = name;
      
       System.out.println("Creating " +  threadName );
   }
   public void run() {
    while (true){
       if(webSource.grab())
                {
                   
                    
                    
		    	try
                        {
                            webSource.retrieve(frame);
			    Highgui.imencode(".bmp", frame, mem);
			    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

			    BufferedImage buff = (BufferedImage) im;
			    Graphics g=ScannerCameraProduitjPanel.getGraphics();
                            

			    if (g.drawImage(buff, 0, 0, getWidth(), getHeight() -150 , 0, 0, 3000,2000, null)){
                               
                                  Highgui.imwrite("src\\edu\\esprit\\tunisiamall\\images\\test.jpg", frame);
                                  if (getProcessOutput().length()!=0){
                                            
                                            
                                            if (produitDAO.findProduitByReference(getProcessOutput()).getId()!=-1){
                                            setInformationProduit(produitDAO.findProduitByReference(getProcessOutput()),false);
                                             jButtonScannerProduit.doClick();
                                                System.out.println("TROUVE DANS LA BASE DE DONNEES ");
                                            
                                            
                                            }
                                            else if (produitDAO.findProduitCorrespondanceByReference(getProcessOutput()).getId()!=-1) {
                                             setInformationProduit(produitDAO.findProduitCorrespondanceByReference(getProcessOutput()),true);
                                             jButtonScannerProduit.doClick();
                                                System.out.println("TROUVE DANS LA BASE DE DONNEES CORRESPONDANCE ");
                                            }
                                            else {
                                                Component frame2 = null;
                                                 jButtonScannerProduit.doClick();
                                                JOptionPane.showMessageDialog(frame2, "Le produit que vous-voulez scanner n'existe pas dans la base de données");
                                            }
                                            
                                           
                                  }
                            }
                            else 
                            {
                                System.out.println("ERROR DRAW IMAGE");
                            }
                                 
			 
			 }
			 catch(Exception ex)
                         {
			    System.out.println("Error");
                         }
                }
    }
   }

   public void start ()
   {
      webSource =new VideoCapture(0);
      System.out.println("Starting " +  threadName );
      
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
   void suspend() {
       webSource.release();
      suspended = true;
   }
   synchronized void resume() {
      suspended = false;
       notify();
   }
}
    public static String getProcessOutput() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("src\\edu\\esprit\\tunisiamall\\utils\\ZBar\\bin\\zbarimg.exe",
                "-q","src\\edu\\esprit\\tunisiamall\\images\\test.jpg");
    

        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        StringBuilder processOutput = new StringBuilder();

        try (BufferedReader processOutputReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));)
        {
            String readLine;

            while ((readLine = processOutputReader.readLine()) != null)
            {
                processOutput.append(readLine + System.lineSeparator());
            }

            process.waitFor();
        }

        return processOutput.toString().trim();
    }
    public void setInformationProduit(Produit produitToDisplay, boolean  correspondance){
             this.ImageProduitjLabel.setIcon(new ImageIcon(produitToDisplay.getPhoto()));
             imageProduitPath = produitToDisplay.getPhoto();
             this.ReferencesProduitjTextField.setText(produitToDisplay.getReference());
             this.NomProduitjTextField.setText(produitToDisplay.getNom());
             this.TypeProduitjTextField.setText(produitToDisplay.getType());
             this.PrixProduitjTextField.setText(String.valueOf(produitToDisplay.getPrix()));
             this.TauxReductionProduitjTextField.setText(String.valueOf(produitToDisplay.getTauxReduction()));
             this.NombrePointProduitjTextField.setText(String.valueOf(produitToDisplay.getNombrePoint()));
             this.QuantiteProduitjTextField.setText(String.valueOf(produitToDisplay.getQuantite()));
             this.DescriptionProduitjTextArea.setText(produitToDisplay.getDescription());
             
             if (!correspondance){
                 this.jTableProduit.setRowSelectionAllowed(true);
                
                    for (int i=0;i<this.jTableProduit.getRowCount();i++){
                        //System.out.println(this.jTableProduit.getModel().getValueAt(i, 1));
                        if (this.jTableProduit.getModel().getValueAt(i, 1).equals(produitToDisplay.getReference())){
                            //System.out.println(this.jTableProduit.getModel().getValueAt(i, 1));
                            this.jTableProduit.setRowSelectionInterval(i, i);
                            break;
                        }
                    
                    }
             }
             else
                    this.jTableProduit.setRowSelectionAllowed(false);
             
         }
    public void updateTableProduit(){
          ProduitDAO produitDAO = new ProduitDAO();
          this.jTableProduit.setModel(DBUtils.resultSetToTableModel(produitDAO.afficherProduit(this.idMarque)));
          this.jTableProduit.removeColumn(this.jTableProduit.getColumnModel().getColumn(0));
          this.jTableProduit.removeColumn(this.jTableProduit.getColumnModel().getColumn(1));
          this.jTableProduit.getColumnModel().getColumn(6).setMinWidth(0);
          this.jTableProduit.getColumnModel().getColumn(6).setMaxWidth(0);
        //  this.jTableProduit.Column(this.jTableProduit.getColumnModel().getColumn(6));
          this.jTableProduit.setRowSelectionAllowed(true);
    }
    /*** FIN MANIPULATION INTERFAVE PRODUIT  ***/ 
    
    
    /**TWITTER METHODS & THREAD ****/
     class DaemonThreadTwitter implements Runnable
    {
         
    protected volatile boolean runnable = false;

    @Override
    
    public  void run()
    {
        synchronized(this)
        {
            while(runnable)
            {
               
                    
		    	try
                        {
                            
                
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
            		    }
                            else{
                                chargement(ChargementTwiitterjLabel);
                                getTwitterInformation();
                                Thread.sleep(60000);
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
    public void getTwitterInformation(){
        
        String timeLineTwitter="";
       
        TwitterDAO twitterDAO = new TwitterDAO();
        List<Status> status = twitterDAO.getTwitterTimeLine(this.idResponsableEnseigne);
        for (Status st : status){
            timeLineTwitter += st.getUser().getName()+"......."+st.getText()+"\n";
        }
        this.TwitterjTextArea.setText(timeLineTwitter);
    }
    /*** FIN TWITTER MTHODS & THREAD ***/
    
    
    /*** DEBUT MANIPULATION INTERFACE BOUTIQUE ***/
    public void RemplirComboMarque(){
        MarqueDao mdao = new MarqueDao();
        Marque m = new Marque ();
        List<Marque> list=mdao.afficherMarque();
        for(Marque mar:list){
        ComboMarque.addItem(mar.getNom());
        }
    }
    public void RemplirComboLocal(){
        LocalDao ldao = new LocalDao();
        Local l = new Local ();
        List<Local> list=ldao.afficherLocalDisponible();
        for(Local loc:list){
        ComboLocal.addItem(loc.getAdresse());
        ComboLocalModif.addItem(loc.getAdresse());
        }
   
        
    }
    
    public void RemplirComboLocalModif(){
        LocalDao ldao = new LocalDao();
        Local l = new Local ();
        List<Local> list=ldao.afficherLocalDisponible();
        for(Local loc:list){
        ComboLocalModif.addItem(loc.getAdresse());
        }
   
        
    }
    public ImageIcon ResizeImage(String imgPath){ 
     ImageIcon MyImage = new ImageIcon(imgPath); 
     Image img = MyImage.getImage(); 
     Image newImage = img.getScaledInstance(Lpath.getWidth(), Lpath.getHeight(),Image.SCALE_SMOOTH);
     ImageIcon image = new ImageIcon(newImage); 
     return image; 
      
    }
    public void populateJTable(){
        System.out.println("BONJOUR GGGGHHKJJKJK");
        BoutiqueDao bdao = new BoutiqueDao();
        Boutique b = new Boutique ();
        LocalDao ldao = new LocalDao();
        Local l = new Local();
        MarqueDao mdao= new MarqueDao();
        Marque m = new Marque();
        
        
        
        List<Boutique> list=bdao.afficherBoutique();
        
        String[] columnName = {"Marque","Local","Logo"};
        Object[][] rows = new Object[list.size()][3];
        for(int i = 0; i < list.size(); i++){
            //System.out.println("**************"+list.get(i).getId_local());
            l.setAdresse(ldao.afficherAdresseLocal(list.get(i).getId_local()));
            m.setNom(mdao.afficherNomMarque(list.get(i).getId_marque()));
            //System.out.println("**************"+m.getNom());
            
            rows[i][0] = m.getNom();
            rows[i][1] = l.getAdresse();
            rows[i][2] = list.get(i).getLogo();
           
            
            if(list.get(i).getLogo()!= null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getLogo()).getImage()
             .getScaledInstance(100, 80, Image.SCALE_SMOOTH) );   
                
            rows[i][2] = image;
            }
            else{
                rows[i][2] = null;
            }
            
        }
        
        ModelGestionBoutique model = new ModelGestionBoutique(rows, columnName);
        TableBoutique.setModel(model);
        TableBoutique.setRowHeight(80);
        TableBoutique.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    /*** FIN MANIPULATION INTERFACE BOUTIQUE ***/
    
   
    /*** DEBUT MANIPULATION INTERFACE RAPPORT ***/
    
     public void RemplirAlert(){
    String alerte=""; //POSSIBLITE DE OPTIMISER !!!
    ProduitDAO pdao = new ProduitDAO();
    Produit p = new Produit();
    List<Produit> list=pdao.afficherAlertProduitByQuantite();
       for(int i = 0; i < list.size(); i++){
       alerte=alerte+"le produit "+list.get(i).getNom()+" est presque en rupture de stock Il ne reste que "+list.get(i).getQuantite()+" articles \n";
       AlertTextArea.setText(alerte);
       System.out.println(alerte);
       }
       
     }
     public void populateJTableRapport(){
        
         MarqueDao mdao = new MarqueDao();
         ProduitDAO pdao = new ProduitDAO();
         Produit p = new Produit();
         int id = mdao.getIDMarqueByResponsable(this.idResponsableEnseigne);
        
 
        List<Produit> list=pdao.afficherProduitByQuantiteVendu(id);
        String[] columnName = {"Référence","NOM","TYPE","QUANTITE","QUANTITE VENDU"};
        Object[][] rows = new Object[list.size()][5];
        for(int i = 0; i < list.size(); i++){
            
            rows[i][0] = list.get(i).getReference();
            rows[i][1] = list.get(i).getNom();
            rows[i][2] = list.get(i).getType();
            rows[i][3] = list.get(i).getQuantite();
            rows[i][4] = list.get(i).getQuantiteVendu();
    
        }
        
        ModelAideDecision model = new ModelAideDecision(rows, columnName);
        ProduitTable.setModel(model);
        ProduitTable.setRowHeight(80);
        //TableLocal.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
     public void prepareSTAT(){
         
          ProduitDAO pdao = new ProduitDAO();
          Produit p = new Produit();
          MarqueDao mdao = new MarqueDao();
          int id = mdao.getIDMarqueByResponsable(this.idResponsableEnseigne);
          
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         List<Produit> list=pdao.afficherProduitByQuantiteVendu(id);
         for(int i = 0; i < list.size(); i++){
            dataset.setValue(list.get(i).getQuantiteVendu(),"Quantité Vendu" ,list.get(i).getNom());
       }
        JFreeChart chart = ChartFactory.createBarChart("Vente","Produit","Quantité Vendu",dataset,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot cat = chart.getCategoryPlot();
        cat.setRangeGridlinePaint(Color.black);
        //ChartFrame frame = new ChartFrame("Vente Par Produit",chart);
        ChartPanel panel = new ChartPanel(chart);
        CP.setLayout(new java.awt.BorderLayout());
        CP.add(panel,BorderLayout.CENTER);
        CP.validate();
     }
     
     
     /*** FIN MANIPULATION INTERFACE RAPPORT ***/
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelResponsableEnseigne = new javax.swing.JPanel();
        cinResponsableEnseigneTextField = new javax.swing.JTextField();
        CinLabel = new javax.swing.JLabel();
        nomResponsableEnseigneTextField = new javax.swing.JTextField();
        modifierResponsableEnseigneButton = new javax.swing.JButton();
        nomLabel = new javax.swing.JLabel();
        prenomResponsableEnseigneTextField = new javax.swing.JTextField();
        prenomLabel = new javax.swing.JLabel();
        loginResponsableEnseigneTextField = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        passwordResponsableEnseigneTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        mailResponsableEnseigneTextField = new javax.swing.JTextField();
        mailLabel = new javax.swing.JLabel();
        adresseLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AdressejTextArea = new javax.swing.JTextArea();
        telephoneLabel = new javax.swing.JLabel();
        TelephoneResponsableEnseigneTextField = new javax.swing.JTextField();
        ImagejLabel = new javax.swing.JLabel();
        BloquedjButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        logjTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        DeleteLogjButton = new javax.swing.JButton();
        ChargementLogjLabel = new javax.swing.JLabel();
        ModifierPhotoREsponsablejButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TwitterjTextArea = new javax.swing.JTextArea();
        TwitterjLabel = new javax.swing.JLabel();
        ChargementTwiitterjLabel = new javax.swing.JLabel();
        MesNotesjLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        MesNotesjTextArea = new javax.swing.JTextArea();
        jPanelProduit = new javax.swing.JPanel();
        jLabelReferences = new javax.swing.JLabel();
        ReferencesProduitjTextField = new javax.swing.JTextField();
        jLabelNom = new javax.swing.JLabel();
        NomProduitjTextField = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        TypeProduitjTextField = new javax.swing.JTextField();
        PrixProduitjTextField = new javax.swing.JTextField();
        jLabelPrix = new javax.swing.JLabel();
        TauxReductionProduitjTextField = new javax.swing.JTextField();
        jLabelTauxReduction = new javax.swing.JLabel();
        NombrePointProduitjTextField = new javax.swing.JTextField();
        jLabelNombrePoint = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DescriptionProduitjTextArea = new javax.swing.JTextArea();
        AddProduitjButton = new javax.swing.JButton();
        ImageProduitjLabel = new javax.swing.JLabel();
        QuantitejLabel = new javax.swing.JLabel();
        QuantiteProduitjTextField = new javax.swing.JTextField();
        jButtonScannerProduit = new javax.swing.JButton();
        ScannerCameraProduitjPanel = new javax.swing.JPanel();
        ModifierPhotoProduit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduit = new javax.swing.JTable();
        jButtonModifierProduit = new javax.swing.JButton();
        jButtonSupprimerProduit = new javax.swing.JButton();
        jPanelBoutique = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboMarque = new javax.swing.JComboBox();
        ComboLocal = new javax.swing.JComboBox();
        AjouterBoutiquejButton = new javax.swing.JButton();
        LabelID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LogoBtn = new javax.swing.JButton();
        Lpath = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MarqueTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LogoLabel = new javax.swing.JLabel();
        BSupprimer = new javax.swing.JButton();
        BModifier = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableBoutique = new javax.swing.JTable();
        ComboLocalModif = new javax.swing.JComboBox();
        jPanelRapport = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ProduitTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        AlertTextArea = new javax.swing.JTextArea();
        LabelStock = new javax.swing.JLabel();
        CP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cinResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        CinLabel.setText("CIN :");

        nomResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        modifierResponsableEnseigneButton.setText("Modifier");
        modifierResponsableEnseigneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierResponsableEnseigneButtonActionPerformed(evt);
            }
        });

        nomLabel.setText("Nom :");

        prenomResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        prenomLabel.setText("Prenom :");

        loginResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        loginLabel.setText("Login :");

        passwordResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        passwordLabel.setText("Password :");

        mailResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        mailLabel.setText("Mail :");

        adresseLabel.setText("Adresse :");

        AdressejTextArea.setColumns(20);
        AdressejTextArea.setRows(5);
        jScrollPane1.setViewportView(AdressejTextArea);

        telephoneLabel.setText("Telephone :");

        TelephoneResponsableEnseigneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelephoneResponsableEnseigneTextFieldActionPerformed(evt);
            }
        });

        BloquedjButton.setText("Debloquer");
        BloquedjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloquedjButtonActionPerformed(evt);
            }
        });

        logjTextArea.setColumns(20);
        logjTextArea.setRows(5);
        jScrollPane4.setViewportView(logjTextArea);

        jLabel1.setText("Historique :");

        DeleteLogjButton.setText("Vider");
        DeleteLogjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLogjButtonActionPerformed(evt);
            }
        });

        ModifierPhotoREsponsablejButton.setText("Modifier");
        ModifierPhotoREsponsablejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierPhotoREsponsablejButtonActionPerformed(evt);
            }
        });

        TwitterjTextArea.setColumns(20);
        TwitterjTextArea.setRows(5);
        jScrollPane5.setViewportView(TwitterjTextArea);

        TwitterjLabel.setText("Twitter :");

        MesNotesjLabel.setText("Mes Notes :");

        MesNotesjTextArea.setColumns(20);
        MesNotesjTextArea.setRows(5);
        jScrollPane6.setViewportView(MesNotesjTextArea);

        javax.swing.GroupLayout jPanelResponsableEnseigneLayout = new javax.swing.GroupLayout(jPanelResponsableEnseigne);
        jPanelResponsableEnseigne.setLayout(jPanelResponsableEnseigneLayout);
        jPanelResponsableEnseigneLayout.setHorizontalGroup(
            jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImagejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModifierPhotoREsponsablejButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(CinLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cinResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(prenomLabel)
                                .addGap(18, 18, 18)
                                .addComponent(prenomResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(nomLabel)
                                .addGap(18, 18, 18)
                                .addComponent(nomResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(mailLabel)
                                .addGap(18, 18, 18)
                                .addComponent(mailResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(telephoneLabel)
                                .addGap(18, 18, 18)
                                .addComponent(TelephoneResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(adresseLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(161, 161, 161))
                                    .addComponent(loginResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TwitterjLabel)
                                        .addComponent(passwordResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BloquedjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modifierResponsableEnseigneButton)
                                .addGap(62, 62, 62))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                    .addComponent(MesNotesjLabel)
                                    .addComponent(jScrollPane6))
                                .addContainerGap(51, Short.MAX_VALUE))))
                    .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addComponent(DeleteLogjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ChargementLogjLabel))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChargementTwiitterjLabel)
                        .addGap(28, 28, 28))))
        );
        jPanelResponsableEnseigneLayout.setVerticalGroup(
            jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                        .addComponent(ImagejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModifierPhotoREsponsablejButton))
                    .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nomResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prenomResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenomLabel)))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(loginResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordLabel)))
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(modifierResponsableEnseigneButton)
                                    .addComponent(BloquedjButton))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cinResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CinLabel))
                            .addComponent(MesNotesjLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelResponsableEnseigneLayout.createSequentialGroup()
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mailResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mailLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TelephoneResponsableEnseigneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telephoneLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adresseLabel)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TwitterjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelResponsableEnseigneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteLogjButton)
                    .addComponent(ChargementLogjLabel)
                    .addComponent(ChargementTwiitterjLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cinResponsableEnseigneTextField.getAccessibleContext().setAccessibleName("cinTextField");

        jTabbedPane1.addTab("Mes Infos", jPanelResponsableEnseigne);

        jLabelReferences.setText("References :");

        ReferencesProduitjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferencesProduitjTextFieldActionPerformed(evt);
            }
        });

        jLabelNom.setText("Nom :");

        jLabelType.setText("Type :");

        jLabelPrix.setText("Prix :");

        jLabelTauxReduction.setText("Taux Reduction :");

        jLabelNombrePoint.setText("Nombre point :");

        jLabelDescription.setText("Description :");

        DescriptionProduitjTextArea.setColumns(20);
        DescriptionProduitjTextArea.setRows(5);
        jScrollPane3.setViewportView(DescriptionProduitjTextArea);

        AddProduitjButton.setText("Ajouter");
        AddProduitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProduitjButtonActionPerformed(evt);
            }
        });

        ImageProduitjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/tunisiamall/images/zara.jpg"))); // NOI18N

        QuantitejLabel.setText("Quantité :");

        jButtonScannerProduit.setText("Scanner");
        jButtonScannerProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScannerProduitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ScannerCameraProduitjPanelLayout = new javax.swing.GroupLayout(ScannerCameraProduitjPanel);
        ScannerCameraProduitjPanel.setLayout(ScannerCameraProduitjPanelLayout);
        ScannerCameraProduitjPanelLayout.setHorizontalGroup(
            ScannerCameraProduitjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        ScannerCameraProduitjPanelLayout.setVerticalGroup(
            ScannerCameraProduitjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ModifierPhotoProduit.setText("Modifier");
        ModifierPhotoProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierPhotoProduitActionPerformed(evt);
            }
        });

        jTableProduit.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableProduit);

        jButtonModifierProduit.setText("Modifier");
        jButtonModifierProduit.setToolTipText("");
        jButtonModifierProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierProduitActionPerformed(evt);
            }
        });

        jButtonSupprimerProduit.setText("Supprimer");
        jButtonSupprimerProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerProduitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProduitLayout = new javax.swing.GroupLayout(jPanelProduit);
        jPanelProduit.setLayout(jPanelProduitLayout);
        jPanelProduitLayout.setHorizontalGroup(
            jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProduitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                .addComponent(ImageProduitjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabelNom))
                                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelReferences)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ReferencesProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NomProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProduitLayout.createSequentialGroup()
                                                .addComponent(jLabelPrix)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PrixProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProduitLayout.createSequentialGroup()
                                                .addComponent(jLabelType)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TypeProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(42, 42, 42)
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                                        .addComponent(jLabelTauxReduction)
                                        .addGap(18, 18, 18)
                                        .addComponent(TauxReductionProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(QuantitejLabel)
                                            .addComponent(jLabelNombrePoint))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NombrePointProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(QuantiteProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProduitLayout.createSequentialGroup()
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                                        .addComponent(jLabelDescription)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                                        .addComponent(ModifierPhotoProduit)
                                        .addGap(460, 460, 460)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                .addComponent(AddProduitjButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonScannerProduit))
                            .addComponent(ScannerCameraProduitjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProduitLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonModifierProduit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSupprimerProduit)))
                .addContainerGap())
        );
        jPanelProduitLayout.setVerticalGroup(
            jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProduitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                        .addComponent(ImageProduitjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ModifierPhotoProduit))
                    .addGroup(jPanelProduitLayout.createSequentialGroup()
                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelReferences)
                                    .addComponent(ReferencesProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NomProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNom)))
                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TauxReductionProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddProduitjButton)
                                    .addComponent(jButtonScannerProduit)
                                    .addComponent(jLabelTauxReduction))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NombrePointProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombrePoint))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelProduitLayout.createSequentialGroup()
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TypeProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelType)
                                    .addComponent(QuantitejLabel)
                                    .addComponent(QuantiteProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDescription)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPrix)
                                        .addComponent(PrixProduitjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(ScannerCameraProduitjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModifierProduit)
                    .addComponent(jButtonSupprimerProduit))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Produit", jPanelProduit);

        jLabel3.setText("MARQUE :");

        jLabel4.setText("LOCAL    :");

        ComboMarque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionnez la marque:" }));
        ComboMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMarqueActionPerformed(evt);
            }
        });

        ComboLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionnez le Local:" }));
        ComboLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboLocalActionPerformed(evt);
            }
        });

        AjouterBoutiquejButton.setText("Ajouter");
        AjouterBoutiquejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterBoutiquejButtonActionPerformed(evt);
            }
        });

        LabelID.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setText("LOGO     :");

        LogoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoBtnActionPerformed(evt);
            }
        });

        Lpath.setPreferredSize(new java.awt.Dimension(100, 80));

        jLabel6.setText("LOCAL :");

        jLabel7.setText("MARQUE :");

        jLabel8.setText("LOGO :");

        LogoLabel.setPreferredSize(new java.awt.Dimension(100, 80));

        BSupprimer.setText("Supprimer");
        BSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSupprimerActionPerformed(evt);
            }
        });

        BModifier.setText("Modifier");
        BModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModifierActionPerformed(evt);
            }
        });

        TableBoutique.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "          Marque", "          Local", "          Logo"
            }
        ));
        TableBoutique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBoutiqueMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableBoutique);

        ComboLocalModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboLocalModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBoutiqueLayout = new javax.swing.GroupLayout(jPanelBoutique);
        jPanelBoutique.setLayout(jPanelBoutiqueLayout);
        jPanelBoutiqueLayout.setHorizontalGroup(
            jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoutiqueLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Lpath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboMarque, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboLocal, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoutiqueLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoutiqueLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(LabelID, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                        .addGap(178, 178, 178)
                                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MarqueTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(ComboLocalModif, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoutiqueLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                        .addComponent(AjouterBoutiquejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BModifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BSupprimer)))
                .addContainerGap())
        );
        jPanelBoutiqueLayout.setVerticalGroup(
            jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboLocalModif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MarqueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ComboMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ComboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBoutiqueLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(LabelID)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(13, 13, 13)
                        .addComponent(Lpath, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoutiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BModifier)
                    .addComponent(BSupprimer)
                    .addComponent(AjouterBoutiquejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Boutique", jPanelBoutique);

        ProduitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(ProduitTable);

        jLabel2.setText("Vente par article:");

        AlertTextArea.setColumns(20);
        AlertTextArea.setRows(5);
        jScrollPane9.setViewportView(AlertTextArea);

        LabelStock.setText("Alert Stock:");

        javax.swing.GroupLayout CPLayout = new javax.swing.GroupLayout(CP);
        CP.setLayout(CPLayout);
        CPLayout.setHorizontalGroup(
            CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CPLayout.setVerticalGroup(
            CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRapportLayout = new javax.swing.GroupLayout(jPanelRapport);
        jPanelRapport.setLayout(jPanelRapportLayout);
        jPanelRapportLayout.setHorizontalGroup(
            jPanelRapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRapportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                    .addGroup(jPanelRapportLayout.createSequentialGroup()
                        .addGroup(jPanelRapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelStock))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelRapportLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(CP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRapportLayout.setVerticalGroup(
            jPanelRapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRapportLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LabelStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRapportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rapport", jPanelRapport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("ResponsableEnseigneDashBoard");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cinResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cinResponsableEnseigneTextFieldActionPerformed

    private void modifierResponsableEnseigneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierResponsableEnseigneButtonActionPerformed
    
        Component frame = null; 
        if (this.BloquedjButton.getText()=="Bloquer"){
        
            if (this.playingWithBackground("RESPONSABLE_ENSEIGNE")){
        
        ResponsableEnseigneDAO responsableEnseigneDAO = new ResponsableEnseigneDAO();
        
        this.responsableEnseigne = responsableEnseigneDAO.findResponsableEnseigneById(this.idResponsableEnseigne);

        if (this.imageResponsableEnseingePath == null){
            this.imageResponsableEnseingePath = this.responsableEnseigne.getImage();
        }        
        else{
        this.responsableEnseigne.setImage(imageResponsableEnseingePath);
        }
        this.responsableEnseigne.setCin(this.cinResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setNom(this.nomResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setPrenom(this.prenomResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setLogin(this.loginResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setPassword(this.passwordResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setMail(this.mailResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setTelephone(this.TelephoneResponsableEnseigneTextField.getText());
        this.responsableEnseigne.setAdresse(this.AdressejTextArea.getText());
        
        
      if (responsableEnseigneDAO.demandeModificationResponsableEnseigne(this.responsableEnseigne) != -1 ){
            
        JOptionPane.showMessageDialog(frame, "DEMANDE DE MODIFICATION ENVOYÉE AVEC SUCÉES");
        writeOnLogFile("Vous avez envoyé une demande modification");
      }
      else 
      {
        JOptionPane.showMessageDialog(frame, "VOUS AVEZ DEJA UNE DEMANDE DE MODIFICATION EN ATTENTE DE TRAITEMENT !");
      }
            }
      }
        else {
            JOptionPane.showMessageDialog(frame, "Veuillez tout d'abord debloquer l'interface !");
        }
         
        
    }//GEN-LAST:event_modifierResponsableEnseigneButtonActionPerformed

    private void nomResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomResponsableEnseigneTextFieldActionPerformed

    private void prenomResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomResponsableEnseigneTextFieldActionPerformed

    private void loginResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginResponsableEnseigneTextFieldActionPerformed

    private void passwordResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordResponsableEnseigneTextFieldActionPerformed

    private void mailResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailResponsableEnseigneTextFieldActionPerformed

    private void TelephoneResponsableEnseigneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelephoneResponsableEnseigneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelephoneResponsableEnseigneTextFieldActionPerformed

    private void BloquedjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloquedjButtonActionPerformed
        // TODO add your handling code here:
        if (this.BloquedjButton.getText()=="Debloquer"){
            this.changeStateInterfaceResponsable(true);
            this.BloquedjButton.setText("Bloquer");
        }
        else {
            this.changeStateInterfaceResponsable(false);
            this.BloquedjButton.setText("Debloquer");
        }
        
    }//GEN-LAST:event_BloquedjButtonActionPerformed

    private void DeleteLogjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLogjButtonActionPerformed
        int dialogButton = 0;
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment vider le fichier d'historique ?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
        this.logDAO.cleanLogFile(this.log);
        }
            
    }//GEN-LAST:event_DeleteLogjButtonActionPerformed

    private void ModifierPhotoREsponsablejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierPhotoREsponsablejButtonActionPerformed
        // TODO add your handling code here:
        ResponsableEnseigne responsableEnseigne = new ResponsableEnseigne();
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    System.out.println(selectedFile.getAbsolutePath());
    this.ImagejLabel.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
    this.imageResponsableEnseingePath = selectedFile.getAbsolutePath();
    
}

    }//GEN-LAST:event_ModifierPhotoREsponsablejButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.notesResponsableDAO.writeMesNotesFile(this.MesNotesjTextArea.getText(), notesResponsable);
if (this.webSource!=null){
        this.webSource.release();
}
        System.out.println("MES NOTES DONE");
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButtonScannerProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScannerProduitActionPerformed
        // TODO add your handling code here:
        
        if (this.jButtonScannerProduit.getText()=="Fermer"){
            R1.suspend();
            
      
            this.jButtonScannerProduit.setText("Scanner");
        }
        else{
    
      R1.start();
      
        this.jButtonScannerProduit.setText("Fermer");
        }
    }//GEN-LAST:event_jButtonScannerProduitActionPerformed
    
    private void AddProduitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProduitjButtonActionPerformed

          this.jTableProduit.setRowSelectionAllowed(false);
        
        if (playingWithBackground("PRODUIT")){
        ProduitDAO produitDao = new ProduitDAO();
        Produit produitToAdd = new Produit();
        Component frame = null;

        produitToAdd.setReference(this.ReferencesProduitjTextField.getText());
        produitToAdd.setIdMarque(this.idMarque); //A executer avec une requette qui retourne l'ID de la marque
        produitToAdd.setNom(this.NomProduitjTextField.getText());
        produitToAdd.setType(this.TypeProduitjTextField.getText());
        produitToAdd.setPrix(Float.parseFloat(this.PrixProduitjTextField.getText()));
        produitToAdd.setTauxReduction(Float.parseFloat(this.TauxReductionProduitjTextField.getText()));
        produitToAdd.setNombrePoint(Integer.parseInt(this.NombrePointProduitjTextField.getText()));
        produitToAdd.setQuantite(Integer.parseInt(this.QuantiteProduitjTextField.getText()));
        produitToAdd.setPhoto(this.imageProduitPath);
        produitToAdd.setDescription(this.DescriptionProduitjTextArea.getText());

        if(produitDao.addProduit(produitToAdd)){

            JOptionPane.showMessageDialog(frame, "Produit ajouté avec succées !");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            logDAO.writeLogFile("Vous avez ajouté un produit de référence "+produitToAdd.getReference()+" le "+dateFormat.format(date),log);
            
            
            
            updateTableProduit();

          

        }
        else{
            JOptionPane.showMessageDialog(frame, "Produit n'as pas été ajouté !");

        }
        
    }


    }//GEN-LAST:event_AddProduitjButtonActionPerformed

    private void ReferencesProduitjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReferencesProduitjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReferencesProduitjTextFieldActionPerformed

    private void ModifierPhotoProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierPhotoProduitActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
   
       JFileChooser fileChooser = new JFileChooser();
fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
int result = fileChooser.showOpenDialog(this);
if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    System.out.println(selectedFile.getAbsolutePath());
    this.ImageProduitjLabel.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
    this.imageProduitPath = selectedFile.getAbsolutePath();
    }//GEN-LAST:event_ModifierPhotoProduitActionPerformed
    }
    
    private void jButtonSupprimerProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerProduitActionPerformed
        
        this.jTableProduit.setRowSelectionAllowed(false);
        
        Component frame = null;
        if (this.ReferencesProduitjTextField.getText().isEmpty()){
             JOptionPane.showMessageDialog(frame, "Veuillez selectionner un produit ou entrer une référence ");
        }
        else {
            int dialogButton = 0;
            
            
            int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer ce produit ? ","Warning",dialogButton);
if(dialogResult == JOptionPane.YES_OPTION){
            ProduitDAO produitDAO = new ProduitDAO();
            
            if (produitDAO.removeProduit(this.ReferencesProduitjTextField.getText())){
            JOptionPane.showMessageDialog(frame, "Produit supprimé avec succées !");
            writeOnLogFile("vous avez supprimé un produit");
            clearInputProduit();
            updateTableProduit();
  
            }
            else {
                    
                   JOptionPane.showMessageDialog(frame, "Produit n'a pas été supprimé !");
            }
        
        
        
        }
        }
    }//GEN-LAST:event_jButtonSupprimerProduitActionPerformed

    private void jButtonModifierProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierProduitActionPerformed
        // TODO add your handling code here:
          this.jTableProduit.setRowSelectionAllowed(false);
          if (playingWithBackground("PRODUIT")){
     
        Component frame = null;
        Produit produit = new Produit();
        ProduitDAO produitDAO = new ProduitDAO();
        
        produit.setReference(this.ReferencesProduitjTextField.getText());
        produit.setNom(this.NomProduitjTextField.getText());
        produit.setType(this.TypeProduitjTextField.getText());
        produit.setPrix(Float.parseFloat(this.PrixProduitjTextField.getText()));
        produit.setTauxReduction(Float.parseFloat(this.TauxReductionProduitjTextField.getText()));
        produit.setNombrePoint(Integer.parseInt(this.NombrePointProduitjTextField.getText()));
        produit.setQuantite(Integer.parseInt(this.QuantiteProduitjTextField.getText()));
        produit.setDescription(this.DescriptionProduitjTextArea.getText());
        produit.setPhoto(imageProduitPath);

        if(produitDAO.updateProduit(produit)){

            JOptionPane.showMessageDialog(frame, "Produit modifié avec succées !");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            logDAO.writeLogFile("Vous avez modifié un produit de référence "+produit.getReference()+" le "+dateFormat.format(date),log);
            
            
           updateTableProduit();

          

        }
        else{
            JOptionPane.showMessageDialog(frame, "Produit n'a pas été modifié !");

        }
        
    }
   
    }//GEN-LAST:event_jButtonModifierProduitActionPerformed

    private void ComboMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMarqueActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ComboMarqueActionPerformed

    private void AjouterBoutiquejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterBoutiquejButtonActionPerformed

        /*** TRAITEMENT ***/
        Component frame = null;
        FileInputStream fileInputStream=null;

        File file = new File(s);

        byte[] bFile = new byte[(int) file.length()];

        try {
            //convert file into array of bytes

            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        BoutiqueDao boutiqueDao = new BoutiqueDao();
        Boutique boutiqueToAdd = new Boutique();
        MarqueDao mdao =new MarqueDao();
        Marque m = new Marque();
        LocalDao ldao = new LocalDao();
        Local l = new Local();
        int idmarque=mdao.getIDMarqueByNom((String) ComboMarque.getSelectedItem());
        int idlocal=ldao.getIDLocalByAdresse((String) ComboLocal.getSelectedItem());
        System.out.println("*****************"+idmarque);
        System.out.println("*****************"+idlocal);
        boutiqueToAdd.setId_local(idlocal);
        boutiqueToAdd.setId_marque(idmarque);
        boutiqueToAdd.setLogo(bFile);
        if(boutiqueDao.ajouterBoutique(boutiqueToAdd)){
         JOptionPane.showMessageDialog(frame, "Boutique Ajoutée avec succées !");
         ldao.ReserverLocal(idlocal);
        }
        else{
          JOptionPane.showMessageDialog(frame, "Boutique n'a pas été Ajoutée !");
        }
        populateJTable();

    }//GEN-LAST:event_AjouterBoutiquejButtonActionPerformed

    private void LogoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        String path = selectedFile.getAbsolutePath();
        Lpath.setIcon(ResizeImage(path));
        s = path;

    }//GEN-LAST:event_LogoBtnActionPerformed

    private void BSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSupprimerActionPerformed
        // TODO add your handling code here:
         Component frame = null;
        BoutiqueDao bdao = new BoutiqueDao();
        Boutique b = new Boutique ();
        LocalDao ldao = new LocalDao();
        Local l = new Local();
        MarqueDao mdao= new MarqueDao();
        Marque m = new Marque();
        int idmarque=mdao.getIDMarqueByNom(MarqueTxt.getText());
        int idlocal=ldao.getIDLocalByAdresse(ComboLocalModif.getSelectedItem().toString());
        b.setId_marque(idmarque);
        b.setId_local(idlocal);
        if(bdao.supprimerBoutique2(b)){
             JOptionPane.showMessageDialog(frame, "Boutique Supprimée avec succées !");
             ldao.LibererLocal(idlocal);
             
        }
        else{
             JOptionPane.showMessageDialog(frame, "Boutique n'a pas été Supprimée !");
        }
        populateJTable();
        MarqueTxt.setText(null);
        ComboLocalModif.removeAllItems();
        LogoLabel.setIcon(null);
    }//GEN-LAST:event_BSupprimerActionPerformed

    private void BModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModifierActionPerformed
        // TODO add your handling code here:
         Component frame = null;
        BoutiqueDao bdao = new BoutiqueDao();
        Boutique b = new Boutique ();
        LocalDao ldao = new LocalDao();
        Local l = new Local();
        int idlocal=ldao.getIDLocalByAdresse(ComboLocalModif.getSelectedItem().toString());
        b.setId_local(idlocal);
        b.setId_marque(idMarque);
        if(bdao.modifierBoutique(b)){
           JOptionPane.showMessageDialog(frame, "Boutique Modifiée avec succées !");
        }
        else{
           JOptionPane.showMessageDialog(frame, "Boutique n'a pas été Modifiée !");    
        
        }
        
    }//GEN-LAST:event_BModifierActionPerformed

    private void TableBoutiqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBoutiqueMouseClicked
        // TODO add your handling code here:
        int i = TableBoutique.getSelectedRow();
        TableModel model = TableBoutique.getModel();
        MarqueTxt.setText(model.getValueAt(i,0).toString());
        ComboLocalModif.removeAllItems();
        RemplirComboLocalModif();
        LogoLabel.setIcon((Icon) model.getValueAt(i,2));
    }//GEN-LAST:event_TableBoutiqueMouseClicked

    private void ComboLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboLocalActionPerformed

    private void ComboLocalModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboLocalModifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboLocalModifActionPerformed
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResponsableEnseigneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
               
                new ResponsableEnseigneGUI().setVisible(true);
            }
        });
    }  
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProduitjButton;
    private javax.swing.JTextArea AdressejTextArea;
    private javax.swing.JButton AjouterBoutiquejButton;
    private javax.swing.JTextArea AlertTextArea;
    private javax.swing.JButton BModifier;
    private javax.swing.JButton BSupprimer;
    private javax.swing.JButton BloquedjButton;
    private javax.swing.JPanel CP;
    private javax.swing.JLabel ChargementLogjLabel;
    private javax.swing.JLabel ChargementTwiitterjLabel;
    private javax.swing.JLabel CinLabel;
    private javax.swing.JComboBox ComboLocal;
    private javax.swing.JComboBox ComboLocalModif;
    private javax.swing.JComboBox ComboMarque;
    private javax.swing.JButton DeleteLogjButton;
    private javax.swing.JTextArea DescriptionProduitjTextArea;
    private javax.swing.JLabel ImageProduitjLabel;
    private javax.swing.JLabel ImagejLabel;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelStock;
    private javax.swing.JButton LogoBtn;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel Lpath;
    private javax.swing.JTextField MarqueTxt;
    private javax.swing.JLabel MesNotesjLabel;
    private javax.swing.JTextArea MesNotesjTextArea;
    private javax.swing.JButton ModifierPhotoProduit;
    private javax.swing.JButton ModifierPhotoREsponsablejButton;
    private javax.swing.JTextField NomProduitjTextField;
    private javax.swing.JTextField NombrePointProduitjTextField;
    private javax.swing.JTextField PrixProduitjTextField;
    private javax.swing.JTable ProduitTable;
    private javax.swing.JTextField QuantiteProduitjTextField;
    private javax.swing.JLabel QuantitejLabel;
    private javax.swing.JTextField ReferencesProduitjTextField;
    private javax.swing.JPanel ScannerCameraProduitjPanel;
    private javax.swing.JTable TableBoutique;
    private javax.swing.JTextField TauxReductionProduitjTextField;
    private javax.swing.JTextField TelephoneResponsableEnseigneTextField;
    private javax.swing.JLabel TwitterjLabel;
    private javax.swing.JTextArea TwitterjTextArea;
    private javax.swing.JTextField TypeProduitjTextField;
    private javax.swing.JLabel adresseLabel;
    private javax.swing.JTextField cinResponsableEnseigneTextField;
    private javax.swing.JButton jButtonModifierProduit;
    private javax.swing.JButton jButtonScannerProduit;
    private javax.swing.JButton jButtonSupprimerProduit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNombrePoint;
    private javax.swing.JLabel jLabelPrix;
    private javax.swing.JLabel jLabelReferences;
    private javax.swing.JLabel jLabelTauxReduction;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanelBoutique;
    private javax.swing.JPanel jPanelProduit;
    private javax.swing.JPanel jPanelRapport;
    private javax.swing.JPanel jPanelResponsableEnseigne;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableProduit;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginResponsableEnseigneTextField;
    private javax.swing.JTextArea logjTextArea;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailResponsableEnseigneTextField;
    private javax.swing.JButton modifierResponsableEnseigneButton;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JTextField nomResponsableEnseigneTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordResponsableEnseigneTextField;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JTextField prenomResponsableEnseigneTextField;
    private javax.swing.JLabel telephoneLabel;
    // End of variables declaration//GEN-END:variables
}
