/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;
import edu.esprit.tunisiamall.dao.classes.NotesResponsableDAO;
import edu.esprit.tunisiamall.dao.interfaces.INotesResponsableDAO;
import edu.esprit.tunisiamall.dao.interfaces.INotesResponsableDAO;
import edu.esprit.tunisiamall.entities.NotesResponsable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Safwene
 */
public class NotesResponsableDAO implements INotesResponsableDAO{
    
    
    @Override
    public boolean writeMesNotesFile(String messString, NotesResponsable mesNotesFile){
         try {
             this.cleanMesNotesFile(mesNotesFile);
            
            File fileWriter =
                new File(mesNotesFile.getFileName());

            BufferedWriter bw = new BufferedWriter (new FileWriter (fileWriter, true));
 bw.write (messString);
 bw.newLine();
 bw.flush();
           
         /*
            if (stringToWrite!=""){
                bufferedWriter.newLine();
            }
            bufferedWriter.write(mesString);
           */ 
            bw.close();
            return true;
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + mesNotesFile.getFileName() + "'");
            return false;
       
        }
    }
    
     @Override
     public String readMesNotesFile (NotesResponsable mesNotesFile){
         
         
           
           
        // This will reference one line at a time
        String line = null;
        String messString="";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(mesNotesFile.getFileName());

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
      
                messString+=line+"\n";
    
              
            }   
     

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                mesNotesFile.getFileName()+ "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + mesNotesFile.getFileName() + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return messString;
    }
     @Override
     public void cleanMesNotesFile(NotesResponsable mesNotesFile){
         PrintWriter writer =
                null;
        try {
            File fileWriter =
                    new File(mesNotesFile.getFileName());
            writer = new PrintWriter(fileWriter);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LogDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
     }
    
    
    
    

