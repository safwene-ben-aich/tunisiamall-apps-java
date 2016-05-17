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
public class Commentaire {
    private int id;
    private Client client;
    private Produit produit;
    private String description;

    public Commentaire() {
    }

    public Commentaire(int id) {
        this.id = id;
    }

    public Commentaire(int id, Client client, Produit produit, String description) {
        this.id = id;
        this.client = client;
        this.produit = produit;
        this.description = description;
    }

    public Commentaire(Client client, Produit produit, String description) {
        this.client = client;
        this.produit = produit;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", client=" + client + ", produit=" + produit + ", description=" + description + '}';
    }
    
    
    
    
}
