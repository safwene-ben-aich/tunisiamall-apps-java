/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.utils;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Mariem
 */
public class SendSMS {
    
    
    
    public static void sendSMS(String phone,String message){
        String key = "2a13a421-4e57-4a9f-9704-a0fb59a914e0";
                String secret = "byOR21Bur02ZOfniKJec6g==";
                
        try{
                Date date = new java.util.Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+01:00"));
                String timestamp = dateFormat.format(date);

                String httpVerb = "POST";
                String path = "/v1/sms/+216"+phone;
                String contentType = "application/json";
                String canonicalizedHeaders = "x-timestamp:" + timestamp;
                String body = "{\"message\":\"" + message + "\"}";

                String contentMd5 = Base64.encode(md5Digest(body));
                String stringToSign = httpVerb + "\n" + contentMd5 + "\n" + contentType + "\n" + canonicalizedHeaders + "\n" + path;
                String signature = signature(secret, stringToSign);
                String authorization = "Application " + key + ":" + signature;

                URL url = new URL("https://messagingApi.sinch.com" + path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("content-type", "application/json");
                connection.setRequestProperty("x-timestamp", timestamp);
                connection.setRequestProperty("authorization", authorization);

                OutputStream os = connection.getOutputStream();
                os.write(body.getBytes());

                StringBuilder response = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = br.readLine()) != null)
                    response.append(line);
                br.close();
                os.close();

                System.out.println(response.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
      private static byte[] md5Digest(String body) {
        MessageDigest md = null;
        byte[] bytesOfBody = null;
        try {
            bytesOfBody = body.getBytes("UTF-8");
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md.digest(bytesOfBody);
    }
     
     
     private static String signature(String secret, String message) {
        String signature = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(Base64.decode(secret.getBytes()), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            signature = Base64.encode(sha256_HMAC.doFinal(message.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }
}
