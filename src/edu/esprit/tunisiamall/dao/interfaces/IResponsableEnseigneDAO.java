/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;

import edu.esprit.tunisiamall.entities.ResponsableEnseigne;
import java.util.List;

/**
 *
 * @author Safwene
 */
public interface IResponsableEnseigneDAO {
    
    ResponsableEnseigne findResponsableEnseigneById(int id);
    int findIDMarqueByIDResponsable (int id);
    void Block(String CIN);
    public void add(ResponsableEnseigne r);
    public void delete(int id);
    List <ResponsableEnseigne> Display();
    
    
    
    
 
}
