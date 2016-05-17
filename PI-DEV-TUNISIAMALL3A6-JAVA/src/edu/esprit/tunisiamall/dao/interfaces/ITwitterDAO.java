/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;

import edu.esprit.tunisiamall.entities.Twitter;
import java.util.List;
import twitter4j.Status;

/**
 *
 * @author Safwene
 */
public interface ITwitterDAO {
    
    public Twitter getTwitterInformationByIDResponsable(int idResponsable);
    public  List<Status> getTwitterTimeLine (int idResponsable);
    
}
