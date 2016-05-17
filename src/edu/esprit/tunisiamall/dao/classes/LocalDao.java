/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.dao.classes.BoutiqueDao;
import edu.esprit.tunisiamall.dao.interfaces.ILocalDao;
import edu.esprit.tunisiamall.entities.Local;
import edu.esprit.tunisiamall.dao.interfaces.ILocalDao;
import edu.esprit.tunisiamall.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antar
 */
public class LocalDao implements ILocalDao {
     Statement ste;
   Connection connexion;
   
   public LocalDao(){
    try {
            //connexion = DBConnection.getIstanceConnexion();
             connexion =  DataSource.getInstance().getConnection();            
        ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    

   }
   
   @Override 
  public boolean ajouterLocal(Local l){
        
       try {
           String req1 = "INSERT INTO LOCAL (ADRESSE,ETAT,EMPLACEMENT) VALUES (?,?,?)";
           PreparedStatement ps = this.connexion.prepareStatement(req1);
          
           ps.setString(1,l.getAdresse());
           ps.setInt(2, l.getEtat());
           ps.setString(3, l.getEmplacement());
           ps.executeUpdate();
           return true;
       } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
            
    }
    
    @Override
   public List<Local> afficherLocal() {

        List<Local> locals = new ArrayList<>();
        Local l ;
        String req4= "select ADRESSE,ETAT,EMPLACEMENT from local ";
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               l= new Local(res.getString("ADRESSE"),res.getInt("ETAT"),res.getString("EMPLACEMENT"));
               locals.add(l);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locals;
    }
   
   
    @Override
   public List<Local> afficherLocalDisponible() {

        List<Local> locals = new ArrayList<>();
        Local l ;
        String req4= "select ADRESSE,ETAT,EMPLACEMENT from local WHERE ETAT=0";
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               l= new Local(res.getString("ADRESSE"),res.getInt("ETAT"),res.getString("EMPLACEMENT"));
               locals.add(l);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locals;
    }
   
   
   @Override
  public void supprimerLocal(Local l) {

     try {
            String req3= "delete from LOCAL where ADRESSE=?";
            PreparedStatement ps = this.connexion.prepareStatement(req3);
 
           ps.setString(1, l.getAdresse());
           ps.executeUpdate();
        } catch (SQLException ex) {
           Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
    
  
   @Override
  public void modifierLocal(Local l) {
      
       try {
           String req2= "update LOCAL set ETAT=? WHERE ADRESSE=?";
           PreparedStatement ps = this.connexion.prepareStatement(req2);
         
           ps.setInt(1,l.getEtat());
           ps.setString(2, l.getAdresse());
           ps.executeUpdate();
        
       } catch (SQLException ex) {
           Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
  
    @Override
   public String afficherAdresseLocal(int ID) {

        
        String Adresse="" ;
        String req4= "select ADRESSE from Local where ID="+ID;
        try {
            ResultSet res =  ste.executeQuery(req4);
            res.first();
               Adresse= res.getString("ADRESSE");
         
            
        } catch (SQLException ex) {
            Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Adresse;
    }
   
   
   @Override
   public int getIDLocalByAdresse(String adresse){
         try {
             String requette = "SELECT * FROM LOCAL WHERE ADRESSE=?";
             PreparedStatement ps = this.connexion.prepareStatement(requette);
             ps.setString(1, adresse);
             ResultSet result = ps.executeQuery();
             result.first();
             return result.getInt("ID");
         } catch (SQLException ex) {
             Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
         }
            return -1;
   }
   
   public byte[] getEmplacementByAdresse(String adresse){
   
      try {
             String requette = "SELECT * FROM LOCAL WHERE ADRESSE=?";
             PreparedStatement ps = this.connexion.prepareStatement(requette);
             ps.setString(1, adresse);
             ResultSet result = ps.executeQuery();
             result.first();
             return result.getBytes("EMPLACEMENT");
         } catch (SQLException ex) {
             Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
         }
            return null;
   
   }
   
    @Override
  public void ReserverLocal(int IdLocal) {
      
       try {
           String req2= "update LOCAL set ETAT=1 WHERE ID=?";
           PreparedStatement ps = this.connexion.prepareStatement(req2);
         
           ps.setInt(1,IdLocal);
           ps.executeUpdate();
        
       } catch (SQLException ex) {
           Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
  
   @Override
  public void LibererLocal(int IdLocal) {
      
       try {
           String req2= "update LOCAL set ETAT=0 WHERE ID=?";
           PreparedStatement ps = this.connexion.prepareStatement(req2);
         
           ps.setInt(1,IdLocal);
           ps.executeUpdate();
        
       } catch (SQLException ex) {
           Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
  
  
  
}   
