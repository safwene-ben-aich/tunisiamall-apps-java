/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.entities.Client;
import edu.esprit.tunisiamall.entities.Commentaire;
import edu.esprit.tunisiamall.entities.Produit;
import edu.esprit.tunisiamall.technique.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatma Jaafar
 */
public class CommentaireDAO {
   Statement ste;
   Connection connexion;
   
    public CommentaireDAO() {
        try {
            connexion =  DataSource.getInstance().getConnection();
        ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public List<Commentaire> affichercommentairesPROD(String reference) {

        List<Commentaire> commentaires = new ArrayList<>();
        Client e;
        Produit p;
        Commentaire c;
        String req4= "SELECT u.username , c.commentaire ,c.id , p.nom , p.reference FROM `commentaires` c inner join user u on u.id=c.idclient inner join produit p on p.id= c.idproduit where p.reference='"+reference+"' order by id desc limit 5 ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            res = ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Client();
                e.setLogin(res.getString("u.username"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit();
                p.setReference(res.getString("p.reference"));
                p.setNom(res.getString("p.nom"));
                c=new Commentaire(res.getInt("c.id"),e,p,res.getString("c.commentaire"));
                System.out.println(e);
                commentaires.add(c);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(commentaires);
         return commentaires;}
     
     
      public void add(Commentaire c) {
         try {
            
            String req1 = "INSERT INTO `commentaires`( `idclient`, `idproduit`, `commentaire`) values ('"+c.getClient().getId()+"','"+c.getProduit().getId()+"','"+c.getDescription()+"')";
             System.out.println(req1);
            ste.executeUpdate(req1);
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
       public void DELETE(Commentaire p) {

        try {
            String sql = "DELETE FROM  commentaires  WHERE id=" + p.getId();
             ste.executeUpdate(sql);
            System.out.println(sql);
            System.out.println("deleted");

        } catch (SQLException ex) {
            System.out.println("nope !!!");
        }

    }
    
}
