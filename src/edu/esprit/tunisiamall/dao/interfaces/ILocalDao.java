/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;

import edu.esprit.tunisiamall.entities.Boutique;
import edu.esprit.tunisiamall.entities.Local;
import java.util.List;

/**
 *
 * @author antar
 */
public interface ILocalDao {
    
    public boolean ajouterLocal(Local l);
    public void modifierLocal(Local l);
    public void supprimerLocal(Local l);
    public List<Local> afficherLocal();
    public String afficherAdresseLocal(int ID);
    public int getIDLocalByAdresse(String adresse);
    public void ReserverLocal(int IdLocal);
    public void LibererLocal(int IdLocal);
    public List<Local> afficherLocalDisponible();
    
}
