/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.esprit.tunisiamall.entities.Client;
import edu.esprit.tunisiamall.entities.ResponsableEnseigne;
import edu.esprit.tunisiamall.technique.DataSource;
import edu.esprit.tunisiamall.utils.SHA;


/**
 *
 * @author dali
 */
public class ClientDao {
    
        private Connection connection;
         public ClientDao() {
        this.connection= DataSource.getInstance().getConnection();
    }
  



    public void delete(Client c) {
   
        try {
            String req3= "delete from user"
                    + " where ID="+c.getId();
            Statement ste = this.connection.createStatement();
            ste.executeUpdate(req3);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     public  ArrayList<Client> getAllResEns() {
        ArrayList<Client> listRes=new ArrayList<>();
         try {
 String req1 = " select u.nom , u.prenom,u.id ,u.ROLE from user u where u.role= 'RESPONSABLE' and u.id not in (select m.ID_RESPONSABLE from marque m)";

           // String req1 = "select * from user  where ROLE='RESPONSABLE'";
            System.out.println(req1);
            Statement ste = this.connection.createStatement();

            ResultSet resultSet =ste.executeQuery(req1);
            if(resultSet!=null){
                            System.out.println(req1);

                while (resultSet.next()) {
                    Client client=new Client(resultSet.getString("NOM"), resultSet.getString("PRENOM"), resultSet.getInt("ID"));
                    listRes.add(client);
                }
            }
             //System.out.println("result:"+result);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRes;
    }
    

    public List<Client> Display() {
        List<Client> liste=new ArrayList<Client>();
     Client clt ;
    
        String req4= "select `username`,`NOM`,`PRENOM`,`email`,`ADRESSE`,`ETAT` from user where ROLE='CLIENT' AND ETAT=2";
        System.out.println("HELLO");
        try {
            Statement ste = this.connection.createStatement();
            ResultSet res =  ste.executeQuery(req4);
            while (res.next()) {
                System.out.println(res.getString("username"));
               clt= new Client(
                       res.getString("username"),
                       res.getString("NOM"),
                       res.getString("PRENOM"),
                       res.getString("EMAIL"),
                       res.getString("ADRESSE"),
                       res.getInt("ETAT")
                       );
               liste.add(clt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(liste);
        return liste;
    }

    
    
    public void Block(Client cl) {
            try {
                String requette = "UPDATE USER SET ETAT=? WHERE username =?";
                PreparedStatement ps = this.connection.prepareStatement(requette);
                ps.setInt(1, 1);
                ps.setString(2, cl.getLogin());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    
     public void DEBlock(Client cl) {
          try {
                String requette = "UPDATE USER SET ETAT=? WHERE username =?";
                PreparedStatement ps = this.connection.prepareStatement(requette);
                ps.setInt(1, 2);
                ps.setString(2, cl.getLogin());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
            }
}
     
     
     
     
     
     public List<Client> Display1() {
        List<Client> liste=new ArrayList<Client>();
     Client clt ;
    
        String req4= "select `username`,`NOM`,`PRENOM`,`email`,`ADRESSE`,`ETAT` from user where ROLE='CLIENT' AND ETAT=1";
        
        try {
            Statement ste = this.connection.createStatement();
            ResultSet res1 =  ste.executeQuery(req4);
            while (res1.next()) {
               clt= new Client(
                       res1.getString("username"),
                  
                       res1.getString("NOM"),
                       res1.getString("PRENOM"),
                       res1.getString("EMAIL"),
                       res1.getString("ADRESSE"),
                       res1.getInt("ETAT")
                       );
               liste.add(clt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }

    
     
     
     
     
     /**** Fatma Jaafar *****/
     
     
     
     
    public void add(Client cl) {
//         try {
//            
//            String req1 = "insert into user( `NOM`, `PRENOM`, `email`, `PASSWORD`, `EMAIL`, `ADRESSE`, `ETAT`, `ROLE`,`SEXE`) "
//                    + "values( '"+cl.getNom()+"','"+cl.getPrenom()+"','"+cl.getLogin()+"','"+cl.getPassword()+"','"+cl.getEmail()+"','"+cl.getAdresse()+"','1','CLIENT','"+cl.getSexe()+"')";
//             System.out.println(req1);
//             PreparedStatement prepp = this.connection.prepareStatement(req1);
//               prepp.execute();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//         
//         
         
          SHA sha = new SHA();
        String salt = sha.getStringSalt();
            try {
//            String req1 = "insert into user (CIN,NOM,PRENOM,LOGIN,PASSWORD,MAIL,ADRESSE,TELEPHONE,ROLE,ETAT) "
//                    + "values('"+c.getCin()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getLogin()+"','"+c.getPassword()+"',"+c.getMail()+"','"+c.getAdresse()+"','"+c.getTelephone()+"','"+c.getRole()+"',"+c.getEtat()+")";
            String req1="INSERT INTO USER (NOM,PRENOM,SEXE,USERNAME,USERNAME_CANONICAL,PASSWORD,EMAIL,EMAIL_canonical,ENABLED,SALT,LOCKED,EXPIRED,ROLES,CREDENTIALS_EXPIRED,ROLE,ETAT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepp = this.connection.prepareStatement(req1);
            
           
            prepp.setString(1,  cl.getNom());
            prepp.setString(2,  cl.getPrenom());
            prepp.setString(3,  cl.getSexe());
            prepp.setString(4,  cl.getLogin());
            prepp.setString(5,  cl.getLogin()+"canonical");
            prepp.setString(6,  sha.get_SHA_512_SecurePassword(cl.getPassword(), salt));
    
            prepp.setString(7,  cl.getEmail());
            prepp.setString(8, cl.getEmail()+"canonincal");
            prepp.setInt(9, 1);
            prepp.setString(10,salt);
            prepp.setInt(11, 0);
            prepp.setInt(12, 0);
            prepp.setInt(13, 0);
            prepp.setInt(14, 0);
          
            prepp.setString(15, "CLIENT");
            prepp.setInt   (16,1);
            
            prepp.execute();
            System.out.println("Insert Done");
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableEnseigneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
         
         
         
         
         
         
    }

 

   
    public Client researchclient(String a) {
       int resultat=0;
       Client e = null;
        String req4= "SELECT * FROM  user  where username='"+a+"'  ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
              Statement ste = this.connection.createStatement();
          res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             while (res.next()) {
                e= new Client();
                e.setLogin(res.getString("username"));
                
                //String reference, String Nom, String type, String photo, String description, Marque marque
              
                
                
            }  } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultat);
         return e;}
    
    
    
     public int researchid(String a) {
       int resultat=0;
        String req4= "SELECT ID FROM  user  where username='"+a+"'  ";
      
            ResultSet res = null  ;
        try {
            System.out.println(req4);
              Statement ste = this.connection.createStatement();
        res =  ste.executeQuery(req4);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()) {
                resultat=res.getInt("ID");
                       
                
                
            }  } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultat);
         return resultat;}
//    
//public void updateClient(Client c) {
//       int resultat=0;
//        String req4= "UPDATE `user` SET `NOM`='"+c.getNom()+"',`PRENOM`='"+c.getPrenom()+"',`LOGIN`='"+c.getLogin()+"',`PASSWORD`='"+c.getPassword()+"',`MAIL`='"+c.getEmail()+"',`ADRESSE`='"+c.getAdresse()+"' WHERE ID='"+c.getId()+"'";
//      
//            //ResultSet res = null  ;
//        try {
//            System.out.println(req4);
//         PreparedStatement ps = this.connection.prepareStatement(req4);
//                
//                ps.executeUpdate();
//           System.out.println("updated");
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
//       }}
//
//    public void DELETE(Client p) {
//
//        try {
//            String sql = "DELETE FROM  User WHERE id=" + p.getId();
//          
// PreparedStatement ps = this.connection.prepareStatement(sql);
//                
//                ps.executeUpdate();
//            System.out.println("deleted");
//
//        } catch (SQLException ex) {
//            System.out.println("nope !!!");
//        }
//
//    }

    
    public void updateNom(String nom, int id) {
             String req4= "update user set nom='"+nom+"' where ID='"+id+"'";
            System.out.println(req4);
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
            PreparedStatement ps = this.connection.prepareStatement(req4);
                
                ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
   
    public void updatePrenom(String prenom, int id) {
             String req4= "update user set prenom='"+prenom+"' where ID='"+id+"'";
            System.out.println(req4);
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
            PreparedStatement ps = this.connection.prepareStatement(req4);
                
                ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void updateLogin(String login, int id) {
             String req4= "update user set username='"+login+"' where ID='"+id+"'";
            System.out.println(req4);
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
            PreparedStatement ps = this.connection.prepareStatement(req4);
                
                ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     public void updateMail(String mail, int id) {
             String req4= "update user set EMAIL='"+mail+"' where ID='"+id+"'";
            System.out.println(req4);
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
         PreparedStatement ps = this.connection.prepareStatement(req4);
                
                ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
 public void updateAsresse(String adresse, int id) {
             String req4= "update user set ADRESSE='"+adresse+"' where ID='"+id+"'";
            System.out.println(req4);
            //ResultSet res = null  ;
        try {
            System.out.println(req4);
          PreparedStatement ps = this.connection.prepareStatement(req4);
                
                ps.executeUpdate();
           System.out.println("updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
 
   
     public Client chercherclientID(int id) {

      Client etd =null ;
        String req4= "select * from user where ID="+id;
         System.out.println(req4);
        try {
            
              Statement ste = this.connection.createStatement();
            ResultSet res =  ste.executeQuery(req4);
           res.next();
           //String nom, String prenom, String email, String sexe, int id, String login, String password
           //(String nom, String prenom, String email, String sexe, String Adresse, String login, String password) 
               etd= new Client(res.getString("nom"),res.getString("prenom"),res.getString("EMAIL"),res.getString("sexe"),res.getString("ADRESSE"),res.getInt("ID"),res.getString("username"),res.getString("password"));
                       
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etd;
    }
    
      
     
     
     
     
     
} 
  
   



    
