/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.dao.interfaces.IResponsableEnseigneDAO;
import edu.esprit.tunisiamall.entities.ResponsableEnseigne;
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
import edu.esprit.tunisiamall.utils.SHA;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Safwene
 */
public class ResponsableEnseigneDAO implements IResponsableEnseigneDAO{
    
    private Connection connection;

    public ResponsableEnseigneDAO() {
        this.connection= DataSource.getInstance().getConnection();
    }
    
    
    
    
   @Override
       public ResponsableEnseigne findResponsableEnseigneById(int id){
           System.out.println("L'ID EST : "+id);
         ResponsableEnseigne responsableEnseigneToDisplay = new ResponsableEnseigne();
          String req ="SELECT * FROM USER WHERE ID=?"; 
           try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            resultat.first();
            responsableEnseigneToDisplay.setId(resultat.getInt("ID"));
            responsableEnseigneToDisplay.setCin(resultat.getString("CIN"));
            responsableEnseigneToDisplay.setNom(resultat.getString("NOM"));
            responsableEnseigneToDisplay.setPrenom(resultat.getString("PRENOM"));
            responsableEnseigneToDisplay.setSexe(resultat.getString("SEXE"));
            responsableEnseigneToDisplay.setLogin(resultat.getString("USERNAME"));
            responsableEnseigneToDisplay.setPassword("Crypté");
            responsableEnseigneToDisplay.setQRCode(resultat.getString("QRCODE"));
            responsableEnseigneToDisplay.setMail(resultat.getString("EMAIL"));
            responsableEnseigneToDisplay.setAdresse(resultat.getString("ADRESSE"));
            responsableEnseigneToDisplay.setTelephone(resultat.getString("TELEPHONE"));
            responsableEnseigneToDisplay.setRole(resultat.getString("ROLE"));
            responsableEnseigneToDisplay.setEtat(resultat.getInt("ETAT"));
            responsableEnseigneToDisplay.setImage(resultat.getString("IMAGE"));
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return responsableEnseigneToDisplay;
       }
       
       public int demandeModificationResponsableEnseigne(ResponsableEnseigne responsableEnseigne){
         
        try {
            String req = "INSERT INTO USER_MODIFICATION VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.connection.prepareStatement(req);
            ps.setInt(1, responsableEnseigne.getId());
            ps.setString(2, responsableEnseigne.getCin());
            ps.setString(3, responsableEnseigne.getNom());
            ps.setString(4, responsableEnseigne.getPrenom());
            ps.setString(5, responsableEnseigne.getSexe());
            ps.setString(6, responsableEnseigne.getLogin());
            ps.setString(7, responsableEnseigne.getPassword());
            ps.setString(8, responsableEnseigne.getQRCode());
            ps.setString(9, responsableEnseigne.getMail());
            ps.setString(10, responsableEnseigne.getAdresse());
            ps.setString(11, responsableEnseigne.getTelephone());
            ps.setString(12, responsableEnseigne.getImage());
            ps.setString(13, responsableEnseigne.getRole());
            ps.setInt(14, responsableEnseigne.getEtat());
          
            System.out.println(ps.toString());
           return  ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         return -1;  
           
       }
       
       @Override
       public int findIDMarqueByIDResponsable (int id){
        try {
            String requette="SELECT * FROM MARQUE WHERE ID_RESPONSABLE=?";
            PreparedStatement ps = this.connection.prepareStatement(requette);
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();
            result.first();
            return (result.getInt("ID"));
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
       }
       @Override
       public String getUserSalt(String username){
           System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEY");
        try {
            String requette  = "SELECT * FROM USER WHERE USERNAME=?";
            PreparedStatement ps = this.connection.prepareStatement(requette);
            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            result.first();
            return (result.getString("SALT"));
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
       }
       
       
       
       
       
       
    /**** METHODES MANIPULATION RESPONSABLE ENSEIGNE PARTIE ADMIN DALI ***/
    @Override
    public void Block(String CIN ) {
        System.out.println("IM HERE ");
        try {
            Statement ste = this.connection.createStatement();
            
            try {
              String requette="UPDATE USER SET ETAT=? WHERE CIN=?";
              PreparedStatement ps = this.connection.prepareStatement(requette);
                
              ps.setInt(1, 1);
              ps.setString(2, CIN);
              System.out.println(ps.toString());
              ps.executeUpdate();
                
                
                System.out.println(ste.toString());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    @Override
    public void add(ResponsableEnseigne r) {
          
        
        SHA sha = new SHA();
        String salt = sha.getStringSalt();
            try {
//            String req1 = "insert into user (CIN,NOM,PRENOM,LOGIN,PASSWORD,MAIL,ADRESSE,TELEPHONE,ROLE,ETAT) "
//                    + "values('"+c.getCin()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getLogin()+"','"+c.getPassword()+"',"+c.getMail()+"','"+c.getAdresse()+"','"+c.getTelephone()+"','"+c.getRole()+"',"+c.getEtat()+")";
            String req1="INSERT INTO USER (CIN,NOM,PRENOM,SEXE,USERNAME,USERNAME_CANONICAL,PASSWORD,QRCODE,EMAIL,EMAIL_canonical,ENABLED,SALT,LOCKED,EXPIRED,ROLES,CREDENTIALS_EXPIRED,ADRESSE,TELEPHONE,IMAGE,ROLE,ETAT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepp = this.connection.prepareStatement(req1);
            
            prepp.setString(1,  r.getCin());
            prepp.setString(2,  r.getNom());
            prepp.setString(3,  r.getPrenom());
            prepp.setString(4,  r.getSexe());
            prepp.setString(5,  r.getLogin());
            prepp.setString(6,  r.getLogin()+"canonical");
            prepp.setString(7,  sha.get_SHA_512_SecurePassword(r.getPassword(), salt));
            prepp.setString(8,  r.getQRCode());
            prepp.setString(9,  r.getMail());
            prepp.setString(10, r.getMail()+"canonincal");
            prepp.setInt(11, 1);
            prepp.setString(12,salt);
            prepp.setInt(13, 0);
            prepp.setInt(14, 0);
            prepp.setInt(15, 0);
            prepp.setInt(16, 0);
            prepp.setString(17, r.getAdresse());
            prepp.setString(18, r.getTelephone());
            prepp.setString(19, r.getImage());
            prepp.setString(20, "RESPONSABLE");
            prepp.setInt   (21, r.getEtat());
            
            prepp.execute();
            System.out.println("Insert Done");
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void delete(int id) {
        
        try {
            
            Statement ste = this.connection.createStatement();
            
            
            
            try {
                String req3= "delete from user"
                        + " where CIN="+id;
                ste.executeUpdate(req3);
            } catch (SQLException ex) {
                Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<ResponsableEnseigne> Display() {
     
            List<ResponsableEnseigne> liste=new ArrayList<ResponsableEnseigne>();
        try {
            
            Statement ste = this.connection.createStatement();
            
            ResponsableEnseigne resp ;
            String req4= "SELECT * FROM USER WHERE ROLE='RESPONSABLE'";
            try {
                ResultSet res =  ste.executeQuery(req4);
                while (res.next()) {
                    resp= new ResponsableEnseigne(
                            res.getInt("ID"),
                            res.getString("CIN"),
                            res.getString("NOM"),
                            res.getString("PRENOM"),
                            res.getString("SEXE"),
                            res.getString("USERNAME"),
                            res.getString("PASSWORD"),
                            res.getString("QRCODE"),
                            res.getString("EMAIL"),
                            res.getString("ADRESSE"),
                            res.getString("TELEPHONE"),
                            res.getString("IMAGE"),
                            res.getString("ROLE"),
                            res.getInt("ETAT")
                    );
                    liste.add(resp);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return liste;
            
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
     
    }
   /**** FIN METHODES MANIPULATION RESPONSABLE ENSEIGNE PARTIE ADMIN DALI ***/
       
       
    
}
