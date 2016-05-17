/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.entities;

/**
 *
 * @author Safwene
 */
public class Log {
    private String fileName;
    private int idResponsable;

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the idResponsable
     */
    public int getIdResponsable() {
        return idResponsable;
    }

    /**
     * @param idResponsable the idResponsable to set
     */
    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    public String toString(){
        return "Log fil, La location est : "+this.fileName+"L'id du responsable est : "+this.idResponsable+"\n";
    }
    
    
    
}
