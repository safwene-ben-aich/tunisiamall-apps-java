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
public class ResponsableEnseigne {

    public ResponsableEnseigne() {
    
    }
    
    
    
    
    private int id;
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;
    private String login;
    private String password;
    private String QRCode;
    private String mail;
    private String adresse;
    private String telephone;
    private String role;
    private String image;
    private int etat;

    public ResponsableEnseigne(int id, String cin, String nom, String prenom,String sexe, String login, String password, String QRCode, String mail, String adresse, String telephone, String role, String image, int etat) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.login = login;
        this.password = password;
        this.QRCode = QRCode;
        this.mail = mail;
        this.adresse = adresse;
        this.telephone = telephone;
        this.role = role;
        this.image = image;
        this.etat = etat;
    }
    
    
    
    
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(String cin) {
        this.cin = cin;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

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
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
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
    
      /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    
    @Override
    public String toString(){
        return "Responsable d'enseigne : "+this.getId()+"\n"+this.getCin()+"\n"+this.getNom()+"\n"+this.getPrenom()+"\n"+this.getLogin()+"\n"+this.getPassword()+"\n"+this.getQRCode()+"\n"+this.getMail()+"\n"+this.getAdresse()+"\n"+this.getTelephone()+"\n"+this.image+"\n"+this.getRole()+"\n"+this.getEtat()+"\n";
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

  
}
