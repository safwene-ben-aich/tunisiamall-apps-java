/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;
import edu.esprit.tunisiamall.entities.Log;

/**
 *
 * @author Safwene
 */
public interface Ilog {
    
    public boolean writeLogFile(String messString, Log logFile);
    public String readLogFile (Log logFile);
    public void cleanLogFile(Log logFile);
    
    
}
