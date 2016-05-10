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
public class Twitter {
    
    private int ID;
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
    private String idResponsable;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the consumerKey
     */
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * @param consumerKey the consumerKey to set
     */
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * @return the consumerSecret
     */
    public String getConsumerSecret() {
        return consumerSecret;
    }

    /**
     * @param consumerSecret the consumerSecret to set
     */
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return the accessTokenSecret
     */
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    /**
     * @param accessTokenSecret the accessTokenSecret to set
     */
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
    
    /**
     * @return the idResponsable
     */
    public String getIdResponsable() {
        return idResponsable;
    }

    /**
     * @param idResponsable the idResponsable to set
     */
    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    public String toString(){
        return "Configuration Twitter  : \n ID : "+this.ID+"\n Consumer Key : "+this.consumerKey+"\n Consumer secret : "+this.consumerSecret+"\n Access Token : "+this.accessToken+"\n Access Token Secret : "+this.accessTokenSecret+"\n ID Responsable : "+this.idResponsable+"\n";
    }

    
    
    
}
