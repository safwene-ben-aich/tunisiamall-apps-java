/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;
import edu.esprit.tunisiamall.interfaces.IBoutiqueDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.tunisiamall.entities.Boutique;
import edu.esprit.tunisiamall.technique.DataSource;
//import edu.esprit.tunisiamall.technique.DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;

/**
 *
 * @author antar
 */
public class BoutiqueDao implements IBoutiqueDao{
    
   Statement ste;
   Connection connexion;
   
   public BoutiqueDao(){
    try {
         //   connexion = DBConnection.getIstanceConnexion();
            connexion =  DataSource.getInstance().getConnection();
        ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    

   }
   
   
  @Override 
  public void ajouterBoutique(Boutique b){
      
       try {
           String requette = "INSERT INTO BOUTIQUE (ID_MARQUE,ID_LOCAL,LOGO) VALUES (?,?,?)";
           PreparedStatement ps = this.connexion.prepareStatement(requette);
           ps.setInt(1, b.getId_marque());
           ps.setInt(2, b.getId_local());
           ps.setBytes(3, b.getLogo());
           ps.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
  
  
  
  
 
  
  @Override
  public void modifierBoutique(Boutique b) {
      
       try {
           String req2= "update BOUTIQUE set "
                   + "ID_LOCAL='"+b.getId_local()+"' where ID_MARQUE="+b.getId_marque();
           ste.executeUpdate(req2);
       } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
  
  @Override
  public void supprimerBoutique(Boutique b) {

     try {
            String req3= "delete from BOUTIQUE"
                    + " where ID="+b.getId();
            ste.executeUpdate(req3);
        } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
   
  
  @Override
  public void supprimerBoutique2(Boutique b) {

     try {
            String req3= "delete from BOUTIQUE"
                    + " where ID_MARQUE="+b.getId_marque()+" AND ID_LOCAL="+b.getId_local();
            ste.executeUpdate(req3);
        } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
 
  @Override
   public List<Boutique> afficherBoutique() {

        List<Boutique> boutiques = new ArrayList<>();
        Boutique b ;
        String req4= "SELECT * FROM BOUTIQUE ";
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               b= new Boutique(res.getInt("ID"),
                       res.getInt("ID_MARQUE"),
                        res.getInt("ID_LOCAL"),
                        res.getBytes("LOGO"));
               boutiques.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return boutiques;
    }
   
   
   
   
   
   
   @Override
   public Boutique chercherBoutique(Boutique b) {

      Boutique btq =null ;
        String req4= "select * from BOUTIQUE where"
                + "ID="+b.getId();
        try {
            ResultSet res =  ste.executeQuery(req4);
           res.next();
               btq= new Boutique(res.getInt("ID"),
                       res.getInt("ID_MARQUE"),
                        res.getInt("ID_LOCAL"),
                        res.getBytes("LOGO"));    
            
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return btq;
    }
   
   @Override
   public List<Boutique> afficherBoutiqueByMarque(int Id_marque) {

        List<Boutique> boutiques = new ArrayList<>();
        Boutique b=null;
        String req4= "select * from BOUTIQUE where ID_MARQUE="+Id_marque;
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               b= new Boutique(res.getInt("ID"),
                       res.getInt("ID_MARQUE"),
                        res.getInt("ID_LOCAL"),
                        res.getBytes("LOGO"));
               boutiques.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return boutiques;
    }
   
    @Override
   public List<Boutique> afficherBoutiqueById(int Id) {

        List<Boutique> boutiques = new ArrayList<>();
        Boutique b=null;
        String req4= "select * from BOUTIQUE where ID="+Id;
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               b= new Boutique(res.getInt("ID"),
                       res.getInt("ID_MARQUE"),
                       res.getInt("ID_LOCAL"),
                       res.getBytes("LOGO") );
               boutiques.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return boutiques;
    }
   @Override
   public List<Boutique> afficherBoutiqueByLocal(int Id) {

        List<Boutique> boutiques = new ArrayList<>();
        Boutique b=null;
        String req4= "select * from BOUTIQUE where ID_LOCAL="+Id;
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               b= new Boutique(res.getInt("ID"),
                       res.getInt("ID_MARQUE"),
                        res.getInt("ID_LOCAL"),
                        res.getBytes("LOGO"));
               boutiques.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return boutiques; 
    }
   
  
 
}
