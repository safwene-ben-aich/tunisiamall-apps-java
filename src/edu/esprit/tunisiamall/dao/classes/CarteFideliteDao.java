/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.entities.CarteFidelite;
import edu.esprit.tunisiamall.entities.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.esprit.tunisiamall.technique.DataSource;
import java.util.ArrayList;

/**
 *
 * @author Mariem
 */
public class CarteFideliteDao {
    
    
    Statement ste;
    Connection connexion;

    public CarteFideliteDao() {
         try {
             connexion =  DataSource.getInstance().getConnection();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CarteFideliteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public CarteFidelite afficherBonus(String nom, int ID) {
    
       ResultSet res = null  ;
       // int cf=0;
       
       CarteFidelite c =null;
        // String req= "SELECT c.NOMBRE_POINT FROM `marque` m, `carte_fidilite` c WHERE m.ID=c.ID_MARQUE and c.ID_CLIENT="+id+"";
         //  String req="SELECT c.NOMBRE_POINT,m.seuilAchat FROM `carte_fidilite` c inner join `marque` m on m.ID=c.ID_MARQUE and m.Nom='"+zara+"'";
     //  String req="SELECT c.NOMBRE_POINT FROM `carte_fidilite` c inner join `marque` m on m.ID=c.ID_MARQUE and m.Nom='"+zara+"'";
             String req= "SELECT carte_fidilite.NOMBRE_POINT,marque.seuilAchat FROM `carte_fidilite` inner join `marque` WHERE marque.ID=carte_fidilite.ID_MARQUE AND carte_fidilite.ID_CLIENT="+ID+" AND marque.Nom='"+nom+"'";
            System.out.println(req);
        try {
            res = ste.executeQuery(req);
        
            while (res.next()) {
               c=new CarteFidelite(res.getInt("NOMBRE_POINT"),res.getInt("seuilAchat"));
               
               
               
            
            }
     } catch (SQLException ex) {
            Logger.getLogger(CarteFideliteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
     }
     
      
//    public ArrayList<Client> getListCarteByMarque(String marque){
//        ArrayList<Client> list=new ArrayList<>();
//        
//        
//         //String req= "SELECT * FROM `carte_fidilite` inner join `marque` inner join `user` WHERE marque.Nom='"+marque+"';";
//         String req="SELECT * FROM `carte_fidilite` c  join `marque` m on c.ID_MARQUE=m.ID  join `user` u on c.ID_CLIENT=u.ID WHERE m.Nom='"+marque+"';";
//            System.out.println(req);
//        try {
//            if(ste!=null){
//            ResultSet res = ste.executeQuery(req);
//        
//            while (res.next()) {
//               Client client=new Client(res.getString("TELEPHONE"),res.getString("NOM"),res.getString("PRENOM"),res.getInt("ID"));
//               list.add(client);
//            }
//          }
//     } catch (SQLException ex) {
//            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//        
//        return list;
//    }
    
    
     
     
     
}
