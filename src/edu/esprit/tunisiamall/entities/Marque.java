/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.entities;

/**
 *
 * @author antar
 */
public class Marque{
    private int id;
    private String nom;
    private float seuilAchat;
    

  public Marque(){
    this.id=0;
    this.nom="";
    this.seuilAchat=0;
    } 
  
  public Marque (String nom){
    this.nom=nom;
    } 
  
  public Marque(int id,String nom,float seuilAchat){
    this.id=id;
    this.nom=nom;
    this.seuilAchat=seuilAchat;
    }
  
  public Marque(String nom,float seuilAchat){
    
    this.nom=nom;
    this.seuilAchat=seuilAchat;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getSeuilAchat() {
        return seuilAchat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom=nom;
    }

    public void setSeuilAchat(float seuilAchat) {
        this.seuilAchat=seuilAchat;
    }
  
  @Override
  public String toString (){
      return "Marque{" + "id=" + id + ", nom=" + nom + ", seuil d'achat=" + seuilAchat + '}';
    
    }
    @Override
    
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Boutique other = (Boutique) obj;
        return this.id == other.id;
    }

    

}  
  
