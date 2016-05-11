/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Safwene
 */
public class SHA {
    public String get_SHA_512_SecurePassword(String passwordToHash, String saltString)
    {
      byte[] salt = "".getBytes();
      passwordToHash = passwordToHash+'{'+saltString+'}';
      String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
      }
    
    public static byte[] getBytes() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[16];
        sr.nextBytes(bytes);
        return bytes;
    }
    public String getStringSalt() {
         final Random rs = new SecureRandom();
         byte[] salt = new byte[16];
         rs.nextBytes(salt);
         return DatatypeConverter.printHexBinary(salt);
    }

    
}
