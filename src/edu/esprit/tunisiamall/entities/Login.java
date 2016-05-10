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
    
    private String login;
    private String password;
    private String QRCode;

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
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
       return "Classe login => login est : "+this.getLogin()+"Password est : "+this.getPassword()+"Le QRCode est : "+this.getQRCode()+"\n";
   }
    
    
    
}
