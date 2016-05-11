/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;


import edu.esprit.tunisiamall.technique.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.tunisiamall.entities.Thread;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Max
 */
public class ThreadDAO {
    Statement ste;
    Connection connexion;

    public ThreadDAO() {
        try {
             connexion =  DataSource.getInstance().getConnection();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void add(int id) {
         try {
            
            String req1 = "INSERT INTO `thread`(`id`, `permalink`, `is_commentable`, `num_comments`, `last_comment_at`) VALUES ('"+id+"','http://localhost/TunisiaMallLebes/web/app_dev.php/produits'+'"+id+"',1,0,NOW()')";
            System.out.println(req1);
            ste.executeUpdate(req1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void updatenumcomments(Thread thread) {
       int resultat=0;
        String req4= "UPDATE `thread` SET `num_comments`=`num_comments`+1 ,`last_comment_at`=NOW() where `id`='"+thread.getId()+"'";
      
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
           ste.executeUpdate(req4);
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
       }}

     
   
   public int researchid(int a) {
       int resultat=0;
        String req4= "SELECT id FROM  Thread  where id='"+a+"'  ";
      
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
                resultat=res.getInt("id");
                       
                
                
            }  } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultat);
         return resultat;}
   
   
   public int researchnumcomments(int a) {
       int resultat=0;
        String req4= "SELECT num_comments FROM  Thread  where id='"+a+"'  ";
      
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
                resultat=res.getInt("num_comments");
                       
                
                
            }  } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultat);
         return resultat;}

     
   
   
    public void updatenumcommentsdelete1(Thread thread) {
       int resultat=0;
        String req4= "UPDATE `thread` SET `num_comments`=0 ,`last_comment_at`=NULL where `id`='"+thread.getId()+"'";
      
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
           ste.executeUpdate(req4);
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
       }}
    
   public void updatenumcommentsdelete2(Thread thread) {
       int resultat=0;
        String req4= "UPDATE `thread` SET `num_comments`=`num_comments`-1 where `id`='"+thread.getId()+"'";
      
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
           ste.executeUpdate(req4);
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDAO.class.getName()).log(Level.SEVERE, null, ex);
       }}

   
}
