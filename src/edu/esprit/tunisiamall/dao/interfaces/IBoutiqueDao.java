/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.interfaces;

import edu.esprit.tunisiamall.entities.Boutique;
import java.sql.Blob;
import java.util.List;

public interface IBoutiqueDao {
    
    public boolean ajouterBoutique(Boutique e);
    public boolean modifierBoutique(Boutique e);
    public void supprimerBoutique(Boutique e);
    public List<Boutique> afficherBoutique();
    public Boutique chercherBoutique(Boutique e);
    public List<Boutique>afficherBoutiqueByMarque(int id);
    public List<Boutique>afficherBoutiqueById(int id);
    public List<Boutique>afficherBoutiqueByLocal(int id);
    public boolean supprimerBoutique2(Boutique b);
    

    
}
