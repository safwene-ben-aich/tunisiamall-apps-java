/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.entities.Client;
import edu.esprit.tunisiamall.entities.Panier;
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
public class PanierDAO {
     Statement ste;
    Connection connexion;

    public PanierDAO() {
        try {
             connexion =  DataSource.getInstance().getConnection();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PanierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param c
     */
    public void add(int idc, int idp,int quantite) {
         try {
            
            String req1 = "insert into panier( `ID_CLIENT`, `ID_PRODUIT`, `QUANTITE`)"
                    + "values( '"+idc+"','"+idp+"','"+quantite+"')";
             System.out.println(req1);
            ste.executeUpdate(req1);
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
      public List<Panier> afficherPANIER(int id) {

        List<Panier> paniers = new ArrayList<>();
        Panier PA;
        Produit p;
        Client client;
        String req4= "SELECT p.nom, p.photo,p.prix ,p.REFERENCE, p.id, p.TAUX_REDUCTION,pa.`ID_PRODUIT`,pa.`ID_CLIENT`,pa.`QUANTITE` from panier pa inner join produit p on pa.`ID_PRODUIT`=p.id where pa.`ID_CLIENT`='"+id+"'";
      System.out.println(req4);
            ResultSet res = null  ;
        try {
            System.out.println(req4);
            res = ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(PanierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                client= new Client();
                client.setId(res.getInt("pa.ID_CLIENT"));
                //String reference, String Nom, String type, String photo, String description, Marque marque                      

                p=new Produit();
               p.setNom(res.getString("p.nom"));
               p.setPhoto(res.getString("p.photo"));
               p.setPrix(res.getFloat("p.prix"));
               p.setId(res.getInt("p.id"));
               p.setTauxReduction(res.getFloat("p.TAUX_REDUCTION"));
               p.setReference(res.getString("p.REFERENCE"));
                System.out.println(p);
                PA= new Panier(client,p,res.getInt("pa.QUANTITE"));
                paniers.add(PA);
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(PanierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(paniers);
         return paniers;}

   public void updatepanier(int idc, int idp, int quantite) {
       int resultat=0;
        String req4= "update panier set quantite='"+quantite+"' where ID_CLIENT='"+idc+"' and ID_PRODUIT='"+idp+"'";
      
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
           ste.executeUpdate(req4);
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierDAO.class.getName()).log(Level.SEVERE, null, ex);
       }}

    public void DELETE(Panier p) {

        try {
            String sql = "DELETE FROM  panier where quantite='"+p.getQuantite()+"'  and ID_CLIENT='"+p.getClient().getId()+"' and ID_PRODUIT='"+p.getProduit().getId()+"'";
             ste.executeUpdate(sql);

            System.out.println("deleted");

        } catch (SQLException ex) {
            System.out.println("nope !!!");
        }

    }
    
}
