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
public class Local {
    private int id;
    private String adresse;
    private int etat;
    private byte[] emplacement;
    

  public Local(){
    this.id=0;
    this.adresse="";
    this.etat=0;
    } 
  
  public Local(String adresse){
    this.adresse=adresse;
    } 
  
   public Local(String adresse,int etat,byte[] emplacement){
   
    this.adresse=adresse;
    this.etat=etat;
    this.emplacement=emplacement;
    }
  
  public Local(int id,String adresse,int etat,byte[] emplacement){
    this.id=id;
    this.adresse=adresse;
    this.etat=etat;
    this.emplacement=emplacement;
    }

    public byte[] getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(byte[] emplacement) {
        this.emplacement = emplacement;
    }
  
  public Local(String adresse,int etat){
    this.adresse=adresse;
    this.etat=etat;
    }

    public int getId() {
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getEtat() {
        return etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
  
  @Override
  public String toString (){
      return "Local{" + "id=" + id + ", adresse=" + adresse + ", etat=" + etat + '}';
    
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