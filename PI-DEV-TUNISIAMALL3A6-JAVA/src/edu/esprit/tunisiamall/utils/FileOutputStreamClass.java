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
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOutputStreamClass {


public void add(String content)
{
		FileOutputStream fop = null;
		File file;

		try {

			file = new File("D:/ajout.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			//System.out.println("Done");

		} catch (IOException e) {
			                 System.out.println(e.getMessage());
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
