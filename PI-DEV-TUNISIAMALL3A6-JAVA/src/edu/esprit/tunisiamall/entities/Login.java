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
public class Login {
    
    private String username;
    private String password;
    private String QRCode;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username  the login to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    

    /**
     * @return the QRCode
     */
    public String getQRCode() {
        return QRCode;
    }

    /**
     * @param QRCode the QRCode to set
     */
    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }
   
   @Override 
   public String toString()
   {
       return "Classe login => username est : "+this.getUsername()+"Password est : "+this.getPassword()+"Le QRCode est : "+this.getQRCode()+"\n";
   }
    
    
    
}
