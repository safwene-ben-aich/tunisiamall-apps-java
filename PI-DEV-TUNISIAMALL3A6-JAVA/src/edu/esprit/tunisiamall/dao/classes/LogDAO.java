/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.dao.interfaces.Ilog;
import edu.esprit.tunisiamall.entities.Log;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Safwene
 */
public class LogDAO implements Ilog{
    
    @Override
    public boolean writeLogFile(String mesString,Log logfile){
        
        try {
            
            File fileWriter =
                new File(logfile.getFileName());

            BufferedWriter bw = new BufferedWriter (new FileWriter (fileWriter, true));
 bw.write (mesString);
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
                + logfile.getFileName() + "'");
            return false;
       
        }
    }
        
        
        
    
    @Override
    public String readLogFile (Log logFile){
        
        
           
        // This will reference one line at a time
        String line = null;
        String messString="";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(logFile.getFileName());

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
                logFile.getFileName()+ "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + logFile.getFileName() + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return messString;
    }
    
    
    @Override
    public void cleanLogFile(Log logFile){
        PrintWriter writer =
                null;
        try {
            File fileWriter =
                    new File(logFile.getFileName());
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
    


