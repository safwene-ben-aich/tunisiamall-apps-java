/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import edu.esprit.tunisiamall.entities.Login;

import edu.esprit.tunisiamall.dao.interfaces.ILoginDAO;
import edu.esprit.tunisiamall.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.internal.runners.TestMethod;
import edu.esprit.tunisiamall.utils.SHA;

/**
 *
 * @author Safwene
 */
public class LoginDAO implements ILoginDAO{
        
        private Connection connection;

    public LoginDAO() {
            this.connection = DataSource.getInstance().getConnection();
    }
        
        
        
    
    
    @Override
        public String[] checkUser(Login login){
            ResponsableEnseigneDAO responsableEnseigneDAO = new ResponsableEnseigneDAO();
            SHA sha = new SHA();
            
            String[] tabToReturn = new String[2];
            try {
                String req= "SELECT * FROM USER WHERE (USERNAME =? AND PASSWORD=?)";
                
                PreparedStatement ps = this.connection.prepareStatement(req);
                ps.setString(1, login.getUsername());
                ps.setString(2, sha.get_SHA_512_SecurePassword(login.getPassword(), responsableEnseigneDAO.getUserSalt(login.getUsername())));
                System.out.println(sha.get_SHA_512_SecurePassword(login.getPassword(), responsableEnseigneDAO.getUserSalt(login.getUsername())));
                ResultSet res = ps.executeQuery();
                if (res.first()){
                    tabToReturn[0] = res.getString("ROLE");
                    tabToReturn[1] = res.getString("ID");
   
                    return tabToReturn;
                }
                else{
                     tabToReturn[0] = "FALSE";
                     return tabToReturn;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                     tabToReturn[0] = "FALSE";
                     return tabToReturn;
            
        }
        @Override
        public String[] checkQRCode(Login login){
           
            
             String[] tabToReturn = new String[2];
            try {
                String req= "SELECT * FROM USER WHERE (QRCODE=?)";
                
                PreparedStatement ps = this.connection.prepareStatement(req);
                ps.setString(1, login.getQRCode());
                ResultSet res = ps.executeQuery();
                if (res.first()){
                    tabToReturn[0] = res.getString("ROLE");
                    tabToReturn[1] = res.getString("ID");
   
                    return tabToReturn;
                }
                else{
                     tabToReturn[0] = "FALSE";
                     return tabToReturn;
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                     tabToReturn[0] = "FALSE";
                     return tabToReturn;
            
            
        }
        
        @Override
        public void testMethode(){
            System.out.println("HEY THERE §");
            try {
                String requette = "SELECT PASSWORD,SALT FROM USER";
                PreparedStatement ps = this.connection.prepareStatement(requette);
                ResultSet res = ps.executeQuery();
                
                while (res.next())
                {
                    System.out.println("PASSWORD = "+res.getString("PASSWORD")+" SALT = "+res.getString("SALT"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
      
        
        
    
    
}
