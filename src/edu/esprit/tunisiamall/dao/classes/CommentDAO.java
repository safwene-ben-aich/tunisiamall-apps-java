/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.entities.Client;
import edu.esprit.tunisiamall.technique.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.tunisiamall.entities.Comment;

import edu.esprit.tunisiamall.entities.Thread;
import edu.esprit.tunisiamall.entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fatma
 */
public class CommentDAO {
    Statement ste;
    Connection connexion;

    public CommentDAO() {
        try {
             connexion =  DataSource.getInstance().getConnection();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void add(Comment comment) {
         try {
            
            String req1 =" INSERT INTO `comment`(`thread_id`, `author_id`, `body`, `ancestors`, `depth`, `created_at`, `state`, `score`) VALUES ('"+comment.getThread().getId()+"','"+comment.getAuthor().getId()+"','"+comment.getBody()+"','"+comment.getAncestor()+"','"+comment.getDepth()+"',NOW(),'"+comment.getState()+"','"+comment.getScore()+"')";
               System.out.println(req1);
            ste.executeUpdate(req1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
       public void DELETE(Comment p) {
        try {
            String sql = "DELETE FROM  Vote where comment_id='"+p.getId()+"'";
             ste.executeUpdate(sql);

            System.out.println("deleted");
            System.out.println(sql);

        } catch (SQLException ex) {
            System.out.println("nope !!!");
        }
        try {
            String sql = "DELETE FROM  Comment where id='"+p.getId()+"'";
             ste.executeUpdate(sql);

            System.out.println("deleted");
            System.out.println(sql);

        } catch (SQLException ex) {
            System.out.println("nope !!!");
        }

    }
   
       
        public List<Comment> affichercommentairesPROD(int idprod) {

        List<Comment> comments = new ArrayList<>();
        Client e;
        Produit p;
        Thread t;
        Comment c;
        String req4= "SELECT u.username , c.body ,c.id , p.nom , p.id FROM comment c inner join user u on u.id=c.author_id inner join produit p on p.id= c.thread_id where p.id='"+idprod+"' order by c.id desc limit 5 ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            res = ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                e= new Client();
                e.setLogin(res.getString("u.username"));
                //String reference, String Nom, String type, String photo, String description, Marque marque
                p=new Produit(res.getInt("p.id"),res.getString("p.nom"));
                t= new Thread(res.getInt("p.id"));
                c=new Comment(res.getInt("c.id"),e,t,res.getString("c.body"));
                System.out.println(e);
                comments.add(c);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(comments);
         return comments;}
     
        
        
         public int researchthread(int a) {
       int resultat=0;
        String req4= "SELECT thread_id FROM  Comment  where id='"+a+"'  ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
             Statement ste = this.connexion.createStatement();
           res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                resultat=res.getInt("thread_id");
                       
                
                
            }  } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultat);
         return resultat;}
     
       
       
       
}
