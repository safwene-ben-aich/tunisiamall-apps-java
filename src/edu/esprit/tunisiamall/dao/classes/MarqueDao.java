/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.dao.interfaces.IMarqueDao;
import edu.esprit.tunisiamall.entities.Marque;
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
public class MarqueDao implements IMarqueDao {
     Statement ste;
   Connection connexion;
   
   public MarqueDao(){
    try {
        //    connexion = DBConnection.getIstanceConnexion();
         connexion =  DataSource.getInstance().getConnection();  
        ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    

   }
      @Override 
    public List<Marque> afficherMarqueClient(int id)  {
         List<Marque> marques = new ArrayList<>();
        Marque e ;

        String req4= "SELECT m.`Nom` FROM carte_fidilite cf inner join marque m on cf.`ID_MARQUE`=m.`ID` inner join user u on u.`ID`=cf.`ID_CLIENT` WHERE cf.`ID_CLIENT`="+id+"";
//String req4= "SELECT m.`Nom` FROM carte_fidilite cf inner join marque m on cf.`ID_MARQUE`=m.`ID` inner join user u on u.`ID`=cf.`ID_CLIENT` WHERE cf.`ID_CLIENT`=15";

        try {
            ResultSet res = ste.executeQuery(req4);
            while (res.next()) {
               e= new Marque(
                      
                       res.getString("Nom")
                      
                       );
               marques.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
      return marques;
        
        
        
     }
   
   @Override 
  public void ajouterMarque(Marque m){
        
       try {
           String req1 = "INSERT INTO MARQUE (ID,Nom,seuilAchat) VALUES (?,?,?)";
           PreparedStatement ps = this.connexion.prepareStatement(req1);
          
           ps.setInt(1, m.getId());
           ps.setString(2, m.getNom());
           ps.setFloat(3, m.getSeuilAchat());
           
           ps.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
            
    }
  
  @Override
  public void modifierMarque(Marque m) {
      
       try {
           String req2= "update MARQUE set "
                   + "seuilAchat='"+m.getSeuilAchat()+"' where ID="+m.getId();
           ste.executeUpdate(req2);
       } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
  
  @Override
  public void supprimerMarque(Marque m) {

     try {
            String req3= "delete from MARQUE"
                    + " where ID="+m.getId();
            ste.executeUpdate(req3);
        } catch (SQLException ex) {
           Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
  
  
  @Override
   public List<Marque> afficherMarque() {

        List<Marque> marques = new ArrayList<>();
        Marque m ;
        String req4= "SELECT * FROM MARQUE ";
        try {
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               m= new Marque(res.getInt("ID"),
                       res.getString("Nom"),
                        res.getFloat("seuilAchat"));
               marques.add(m);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BoutiqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marques;
    }
    
    @Override
   public String afficherNomMarque(int ID) {

        
        String Nom="" ;
        String req4= "select Nom from MARQUE where ID="+ID;
        try {
            ResultSet res =  ste.executeQuery(req4);
            res.first();
               Nom= res.getString("Nom");
         
            
        } catch (SQLException ex) {
            Logger.getLogger(LocalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Nom;
    }
   
    @Override
    public int getIDMarqueByNom(String nom){
         try {
             String requette = "SELECT * FROM MARQUE WHERE NOM=?";
             PreparedStatement ps = this.connexion.prepareStatement(requette);
             ps.setString(1, nom);
             ResultSet result = ps.executeQuery();
             result.first();
             return result.getInt("ID");
         } catch (SQLException ex) {
             Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
         }
            return -1;
    }
    
     @Override
    public long addMarque(Marque marque){
       // zzertyui
         try {
            
//           
              String req1 = "insert into marque(`Nom`,`image`,`seuilAchat`,`ID_RESPONSABLE`) "
                    + "values( '"+marque.getNom()+"','"+marque.getImage()+"','"+marque.getSeuilAchat()+"','"+marque.getIdRes()+"')";
             System.out.println(req1);
            PreparedStatement ps = this.connexion.prepareStatement(req1);

            long result =ps.executeUpdate(req1);
             System.out.println("result:"+result);
            return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
    }
    
     public String  afficherImageMarque(String nom) {
          String  e=null;
           String req4= "select image from marque where Nom ='"+nom+"'";
           
             try {
            ResultSet res = ste.executeQuery(req4);
            while (res.next()) {
                 e=   res.getString("image");
                     
               //marques.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
      }
   
   
   
   
   
   
   
 
   
    
    
}
