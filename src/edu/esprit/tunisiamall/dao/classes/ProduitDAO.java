/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.dao.interfaces.IProduitDAO;
import edu.esprit.tunisiamall.entities.Marque;
import edu.esprit.tunisiamall.entities.Produit;
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
 * @author Safwene
 */
public class ProduitDAO implements IProduitDAO{

    private Connection connection;

    public ProduitDAO() {
        this.connection = DataSource.getInstance().getConnection();
    }
    
    
    
    
    
    @Override
    public boolean addProduit(Produit p){
        try {
            String req=" INSERT INTO PRODUIT  (REFERENCE,ID_MARQUE,NOM,TYPE,PRIX,TAUX_REDUCTION,NOMBRE_POINT,PHOTO,DESCRIPTION,QUANTITE,QUANTITE_VENDU) VALUES  (?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = this.connection.prepareStatement(req);
    
            ps.setString(1, p.getReference());
            ps.setInt(2, p.getIdMarque());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getType());
            ps.setFloat(5, p.getPrix());
            ps.setFloat(6, p.getTauxReduction());
            ps.setInt(7, p.getNombrePoint());
            ps.setString(8, p.getPhoto());
            ps.setString(9, p.getDescription());
            ps.setInt(10, p.getQuantite());
            ps.setInt(11, p.getQuantiteVendu());
            
            System.out.println(ps.toString());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
    
    
    @Override
    public boolean updateProduit(Produit p){
        String req="UPDATE PRODUIT SET  NOM=?,TYPE=?,PRIX=?,TAUX_REDUCTION=?,NOMBRE_POINT=?,PHOTO=?,DESCRIPTION=?,QUANTITE=? WHERE REFERENCE=?";
        try {
            PreparedStatement ps  = this.connection.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getType());
            ps.setFloat(3, p.getPrix());
            ps.setFloat(4, p.getTauxReduction());
            ps.setInt(5, p.getNombrePoint());
            ps.setString(6, p.getPhoto());
            ps.setString(7, p.getDescription());
            ps.setInt(8, p.getQuantite());
            ps.setString(9, p.getReference());
            
            System.out.println(ps.toString());
            ps.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public boolean removeProduit(String reference){
        String req="DELETE FROM PRODUIT WHERE REFERENCE=?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(req);
            ps.setString(1, reference);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    @Override
    public Produit findProduitByReference(String reference){
            String req="Select * FROM PRODUIT WHERE REFERENCE=?";
            Produit produitToReturn = new Produit();
        try {
            PreparedStatement ps = this.connection.prepareStatement(req);
            ps.setString(1, reference);
            ResultSet res  = ps.executeQuery();
            res.first();
            produitToReturn.setId(res.getInt("ID"));
            produitToReturn.setReference(res.getString("REFERENCE"));
            produitToReturn.setIdMarque(res.getInt("ID_MARQUE"));
            produitToReturn.setNom(res.getString("NOM"));
            produitToReturn.setType(res.getString("TYPE"));
            produitToReturn.setPrix(res.getFloat("PRIX"));
            produitToReturn.setTauxReduction(res.getFloat("TAUX_REDUCTION"));
            produitToReturn.setNombrePoint(res.getInt("NOMBRE_POINT"));
            produitToReturn.setPhoto(res.getString("PHOTO"));
            produitToReturn.setDescription(res.getString("DESCRIPTION"));
            produitToReturn.setPhoto(res.getString("PHOTO"));
            produitToReturn.setQuantite(res.getInt("QUANTITE"));
            produitToReturn.setQuantiteVendu(res.getInt("QUANTITE_VENDU"));
            
                return produitToReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        produitToReturn.setId(-1);
        return produitToReturn;
    }
    
    @Override
    public Produit findProduitCorrespondanceByReference(String reference){
            String req="Select * FROM CORRESPONDANCE_PRODUIT WHERE REFERENCE=?";
            Produit produitToReturn = new Produit();
        try {
            PreparedStatement ps = this.connection.prepareStatement(req);
            ps.setString(1, reference);
            ResultSet res  = ps.executeQuery();
            res.first();
            produitToReturn.setId(res.getInt("ID"));
            produitToReturn.setReference(res.getString("REFERENCE"));
            produitToReturn.setIdMarque(res.getInt("ID_MARQUE"));
            produitToReturn.setNom(res.getString("NOM"));
            produitToReturn.setType(res.getString("TYPE"));
            produitToReturn.setPrix(res.getFloat("PRIX"));
            produitToReturn.setTauxReduction(res.getFloat("TAUX_REDUCTION"));
            produitToReturn.setNombrePoint(res.getInt("NOMBRE_POINT"));
            produitToReturn.setPhoto(res.getString("PHOTO"));
            produitToReturn.setDescription(res.getString("DESCRIPTION"));
            produitToReturn.setPhoto(res.getString("PHOTO"));
            produitToReturn.setQuantite(res.getInt("QUANTITE"));
            produitToReturn.setQuantiteVendu(res.getInt("QUANTITE_VENDU"));
            
                return produitToReturn;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        produitToReturn.setId(-1);
        return produitToReturn;
    }
    @Override
    public ResultSet afficherProduit(int idMarque){
        try {
            System.out.println(idMarque);
            String requette = "SELECT * FROM PRODUIT WHERE ID_MARQUE=?";
            PreparedStatement ps = this.connection.prepareStatement(requette); 
            ps.setInt(1, idMarque);
            ResultSet result = ps.executeQuery();
            return (result);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    /*** METHODE AJOUTE PAR ANTAR ***/
   
    
    public List<Produit> afficherProduitByQuantiteVendu() {  // REDONDANCE DU CODE AVEC LA METHODE QUI SUIT
        List<Produit> produits = new ArrayList<>();
        Produit p ;
        String req4= "SELECT * FROM PRODUIT ORDER BY QUANTITE_VENDU DESC ";
        try {
            Statement ste = this.connection.createStatement();
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
                System.out.println(res.getString("NOM"));
               p= new Produit(res.getInt("ID"),
                      res.getString("REFERENCE"),
                      res.getInt("ID_MARQUE"),
                      res.getString("NOM"),
                      res.getString("TYPE"),
                      res.getFloat("PRIX"),
                      res.getFloat("TAUX_REDUCTION"), 
                      res.getInt("NOMBRE_POINT"), 
                      res.getString("PHOTO"), 
                      res.getString("DESCRIPTION"),
                      res.getInt("QUANTITE"),
                      res.getInt("QUANTITE_VENDU")); 
                       
               produits.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }

    
    public List<Produit> afficherAlertProduitByQuantite() {

        List<Produit> produits = new ArrayList<>();
        Produit p ;
        String req4= "SELECT * FROM PRODUIT WHERE QUANTITE < 10";
        try {
            Statement ste = this.connection.createStatement();
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
               p= new Produit(res.getInt("ID"),
                      res.getString("REFERENCE"),
                      res.getInt("ID_MARQUE"),
                      res.getString("NOM"),
                      res.getString("TYPE"),
                      res.getFloat("PRIX"),
                      res.getFloat("TAUX_REDUCTION"), 
                      res.getInt("NOMBRE_POINT"), 
                      res.getString("PHOTO"), 
                      res.getString("DESCRIPTION"),
                      res.getInt("QUANTITE"),
                      res.getInt("QUANTITE_VENDU")); 
                       
               produits.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
    
    
    // FIN METHODE AJOUTE PAR ANTAR 
    
    
    
    
    

    
    /**** Fatma Jaafar *****/   
    
    
    
     public List<Produit> afficherProduitClient() {

        List<Produit> produits = new ArrayList<>();
        Marque e ;
        Produit p;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE limit 1,4";
      
         ResultSet res = null  ;
        try {
            System.out.println(req4);
            //res = ste.executeQuery(req4);
            Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                System.out.println(e);
                produits.add(p);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(produits);
         return produits;}
    
     public List<Produit> afficherProduitpartypefmepaginate(String type, int pos) {

        List<Produit> produits = new ArrayList<>();
        Marque e ;
        Produit p;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,p.`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE where p.type like '%"+type+"%' limit "+pos+",4";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
             Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                 e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                System.out.println(e);
                produits.add(p);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(produits);
         return produits;}
     
     public List<Produit> afficherProduitnouv(int pos) {

        List<Produit> produits = new ArrayList<>();
        Marque e ;
        Produit p;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,p.`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE order by p.id desc limit "+pos+",4";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                System.out.println(e);
                produits.add(p);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(produits);
         return produits;}
     
     
     
      public List<Produit> afficherProduitparintprix(int prix) {

        List<Produit> produits = new ArrayList<>();
        Marque e ;
        Produit p;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,p.`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE where PRIX<"+prix+" ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                System.out.println(e);
                produits.add(p);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(produits);
         return produits;}
     
     public List<Produit> RechercheProdcritere(String critere, int pos) {

        List<Produit> produits = new ArrayList<>();
        Marque e ;
        Produit p;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE where REFERENCE like '%"+critere+"%' or p.nom like '%"+critere+"%' or TYPE like '%"+critere+"%' or DESCRIPTION like '%"+critere+"%' or m.nom like '%"+critere+"%' or prix like '%"+critere+"%' limit "+pos+",4";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                System.out.println(e);
                produits.add(p);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(produits);
         return produits;}
     
     
     
 public int researchid(String a) {
       int resultat=0;
        String req4= "SELECT ID FROM  produit  where REFERENCE='"+a+"'  ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
             Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                resultat=res.getInt("ID");
                       
                
                
            }  } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultat);
         return resultat;}

   
 
 
 
 
 
 
 
  public List<Produit> afficherProduitpaginate(int pos) {

        List<Produit> produits = new ArrayList<>();
        Marque e ;
        Produit p;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE limit "+pos+",4";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
          Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                System.out.println(e);
                produits.add(p);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(produits);
         return produits;}
    public Produit afficherProduit1(String reference) {

        
        Marque e ;
        Produit p = null;
        String req4= "SELECT `REFERENCE`,p.`NOM`,`ID_MARQUE`,`TYPE`,`PRIX`,`DESCRIPTION` ,`PHOTO`, m.nom FROM  `produit`p INNER JOIN marque m ON m.id = p.ID_MARQUE where REFERENCE='"+reference+"'";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            Statement ste = this.connection.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Marque();
                e.setId(res.getInt("ID_MARQUE"));
                e.setNom(res.getString("m.nom"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("REFERENCE"));
                p.setNom(res.getString("p.NOM"));
                p.setType(res.getString("TYPE"));
                p.setPhoto(res.getString("photo"));
                p.setDescription(res.getString("DESCRIPTION"));
                p.setPrix(res.getFloat("PRIX"));
                p.setMarque(e);
                //String reference, String Nom, String type, String photo, String description, Marque marque
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(p);
         return p;}

    public void resprod(int idp, int quantite) {
           int resultat=0;
        String req4= "UPDATE `produit` SET `QUANTITE_VENDU`="+quantite+" WHERE ID='"+idp+"'";
      
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
            PreparedStatement ps  = this.connection.prepareStatement(req4);
           ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }

 public void resprodsupp(int idp, int quantite) {
           int resultat=0;
        String req4= "UPDATE `produit` SET `QUANTITE_VENDUE`+="+quantite+" WHERE ID='"+idp+"'";
      
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
         PreparedStatement ps  = this.connection.prepareStatement(req4);
           ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
 
    
    
    
}
