/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.tunisiamall.entities;

/**
 *
 * @author Fatma Jaafar
 */
public class Client extends User {
  
  
    private int id ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String login ;
    private String password ;
    private String mail ;
    private String adresse ;
    private String telephone ;
    private String role ="CLIENT";
    private int Etat;
    private String sexe;
    public Client() {
    }

    public Client(String login) {
        super(login);
    }

    public Client(String nom, String prenom, String email, String role,int etat, String sexe, int id, String login, String password) {
        super(id, login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.mail = email;
        this.role = role;
        this.Etat = etat;
        this.sexe = sexe;
    }

    public Client(String login,String nom, String prenom, String email,String Adresse,int etat) {
       super(login);
        this.nom = nom;
        this.prenom = prenom;
        this.mail = email;
        this.Etat = etat;
        this.adresse = Adresse;
    }

  

    public Client(String nom, String prenom, String email, String sexe, String Adresse, int id, String login, String password) {
        super(id, login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.mail = email;
        this.sexe = sexe;
        this.adresse = Adresse;
    }

    public Client(String nom, String prenom, String email, String sexe, String Adresse, String login, String password) {
        super( login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.mail = email;
        this.sexe = sexe;
        this.adresse = Adresse;
    }

    public Client(int id) {
        super(id);
    }

    public Client(String nom, String prenom, String email, String sexe, int id, String login, String password) {
        super(id, login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.mail = email;
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return mail;
    }

    

    public void setEmail(String email) {
        this.mail = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        this.Etat = etat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }

  
    @Override
    public String toString() {
        return "Client{" +super.toString()+ "nom=" + nom + ", prenom=" + prenom + ", email=" + mail + ", role=" + role + ", etat=" + Etat + ", sexe=" + sexe + '}';
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
    
    
}
