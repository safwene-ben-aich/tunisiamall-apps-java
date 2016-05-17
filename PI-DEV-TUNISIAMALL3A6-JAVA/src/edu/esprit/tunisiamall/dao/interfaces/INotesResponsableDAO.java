/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;
import edu.esprit.tunisiamall.entities.NotesResponsable;

/**
 *
 * @author Safwene
 */
public interface INotesResponsableDAO {
    
    public boolean writeMesNotesFile(String messString, NotesResponsable mesNotesFile);
    public String readMesNotesFile (NotesResponsable mesNotesFile);
    public void cleanMesNotesFile(NotesResponsable mesNotesFile);
    
}
