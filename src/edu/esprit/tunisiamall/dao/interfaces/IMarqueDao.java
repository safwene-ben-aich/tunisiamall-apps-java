/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;

import edu.esprit.tunisiamall.entities.Marque;
import java.util.List;

/**
 *
 * @author antar
 */
public interface IMarqueDao {
    public void ajouterMarque(Marque m);
    public void modifierMarque(Marque m);
    public void supprimerMarque(Marque m);
    public List<Marque> afficherMarque();
    public String afficherNomMarque(int ID);
    public int getIDMarqueByNom(String nom);

    
}
