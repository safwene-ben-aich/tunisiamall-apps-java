/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.dao.interfaces;
import edu.esprit.tunisiamall.entities.Login;

/**
 *
 * @author Safwene
 */
public interface ILoginDAO {

    String[] checkUser(Login login);
    String[] checkQRCode(Login login);
    

}
