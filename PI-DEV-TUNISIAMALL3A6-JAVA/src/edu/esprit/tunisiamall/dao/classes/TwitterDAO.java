/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;
import edu.esprit.tunisiamall.entities.Twitter;
import edu.esprit.tunisiamall.dao.interfaces.ITwitterDAO;
import edu.esprit.tunisiamall.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import edu.esprit.tunisiamall.entities.Twitter;
/**
 *
 * @author Safwene
 */
public class TwitterDAO implements ITwitterDAO{
    
        private Connection connection;

    public TwitterDAO() {
            this.connection = DataSource.getInstance().getConnection();
    }
        
    @Override
    public Twitter getTwitterInformationByIDResponsable(int idResponsable){
         
         Twitter twitterToFind = new Twitter();
         try {
                String requette = "SELECT * FROM TWITTER WHERE ID_RESPONSABLE=?";
                PreparedStatement ps = this.connection.prepareStatement(requette);
                ps.setInt(1, idResponsable);
                ResultSet result = ps.executeQuery();
                result.first();
                twitterToFind.setID(result.getInt("ID"));
                twitterToFind.setConsumerKey(result.getString("CONSUMER_KEY"));
                twitterToFind.setConsumerSecret(result.getString("CONSUMER_SECRET"));
                twitterToFind.setAccessToken(result.getString("ACCESS_TOKEN"));
                twitterToFind.setAccessTokenSecret(result.getString("ACCESS_TOKEN_SECRET"));
                twitterToFind.setIdResponsable(result.getString("ID_RESPONSABLE"));
            } catch (SQLException ex) {
                Logger.getLogger(TwitterDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return twitterToFind;
    }
    @Override
    public  List<Status> getTwitterTimeLine (int idResponsable){
        
        Twitter twitterToFind = new Twitter();
        twitterToFind = this.getTwitterInformationByIDResponsable(idResponsable);
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterToFind.getConsumerKey())
                .setOAuthConsumerSecret(twitterToFind.getConsumerSecret())
                .setOAuthAccessToken(twitterToFind.getAccessToken())
                .setOAuthAccessTokenSecret(twitterToFind.getAccessTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();
        List<Status> status = null;
        try {
            status = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                
        return status;
    }
    }
    
    
    
    
    

