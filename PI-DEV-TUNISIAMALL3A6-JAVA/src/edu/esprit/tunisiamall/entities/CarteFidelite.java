/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.entities;

/**
 *
 * @author Mariem
 */
public class CarteFidelite {
    
    private int nbPoint;
    private float seuil;

    public float getSeuil() {
        return seuil;
    }

    public CarteFidelite(int nbPoint, float seuil) {
        this.nbPoint = nbPoint;
        this.seuil = seuil;
    }
    public CarteFidelite(int nbPoint) {
        this.nbPoint = nbPoint;
    }

    /**
     * @return the nbPoint
     */
    public int getNbPoint() {
        return nbPoint;
    }

    /**
     * @param nbPoint the nbPoint to set
     */
    public void setNbPoint(int nbPoint) {
        this.nbPoint = nbPoint;
    }

    @Override
    public String toString() {
        return "CarteFidelite{" + "nbPoint=" + nbPoint + '}';
    }
    
    
    
    
  
}
