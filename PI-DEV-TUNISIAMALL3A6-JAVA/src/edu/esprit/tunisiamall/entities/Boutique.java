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
public class Boutique {
    int id;
    private int id_marque;
    private int id_local;
    private byte[] logo;
    
public Boutique(){
    this.id=0;
    this.id_marque=0;
    this.id_local=0;
    this.logo=null;
    }    
    public Boutique(int id,int id_marque,int id_local,byte[] logo){
    this.id=id;
    this.id_marque=id_marque;
    this.id_local=id_local;
    this.logo=logo;
    }

    public int getId() {
        return id;
    }

    public int getId_marque() {
        return id_marque;
    }

    public int getId_local() {
        return id_local;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }
    
    /**
     *
     * @return 
     */
    @Override
    public String toString (){
      return "Boutique{" + "id=" + id + ", marque=" + id_marque + ", local=" + id_local + '}';
    
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

