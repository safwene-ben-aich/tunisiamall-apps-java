/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;

import edu.esprit.tunisiamall.entities.Produit;
import java.sql.ResultSet;
import java.util.List;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Safwene
 */
public interface IProduitDAO {
     
    Produit findProduitByReference(String reference);
    boolean addProduit(Produit p);
    boolean updateProduit(Produit p);
    boolean removeProduit(String reference);
    ResultSet afficherProduit(int idMarque);
    Produit findProduitCorrespondanceByReference(String reference);
    List<Produit> afficherAlertProduitByQuantite();
    List<Produit> afficherProduitByQuantiteVendu();
    
    
     
    
    
    
}
