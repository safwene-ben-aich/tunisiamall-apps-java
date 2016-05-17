/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.utils;

/**
 *
 * @author dali
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class FileInputStreamClass {
    public char[] get(){
  File file = new File("D:/ajout.txt");
		FileInputStream fis = null;
char [] chars=new char[2000];
		try {
			fis = new FileInputStream(file);

//			System.out.println("Total file size to read (in bytes) : "
//					+ fis.available());

			int content;
                        int i=0;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				//System.out.print((char) content);
                                chars[i]=(char) content;
                                i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                return chars;
	}  
}
