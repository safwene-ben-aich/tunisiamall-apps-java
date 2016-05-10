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
            String[] tabToReturn = new String[2];
            try {
                String req= "SELECT * FROM USER WHERE (LOGIN=? AND PASSWORD=?)";
                
                PreparedStatement ps = this.connection.prepareStatement(req);
                ps.setString(1, login.getLogin());
                ps.setString(2, login.getPassword());
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
        
        
        
    
    
}
