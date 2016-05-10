/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.utils;

/**
 *
 * @author Fatma Jaafar
 */
public class Utilis {
     public static boolean isAlphanumeric(String string){

         return string.matches("[^a-zA-Z0-9]");
       // return true;
       
    }
    public static boolean isAlphabetic(String string) {
       return string.matches("[^a-zA-Z]");
    }

    public static boolean isValid(String email)
{
	if( email!=null && email.trim().length()>0 )
		return email.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$");
	return false;
}  
    
    public static boolean isNumeric(String string) {
       return string.matches("[^0-9]");
    }
}
