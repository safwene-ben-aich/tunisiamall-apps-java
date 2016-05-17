/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.tests;

import edu.esprit.tunisiamall.entities.ResponsableEnseigne;
import edu.esprit.tunisiamall.gui.HomeAdmin;
import edu.esprit.tunisiamall.gui.ResponsableEnseigneGUI;
import edu.esprit.tunisiamall.gui.LoginGUI;
import edu.esprit.tunisiamall.gui.LoginChoiseGUI;
import edu.esprit.tunisiamall.gui.LoginQRcodeGUI;
import edu.esprit.tunisiamall.gui.ResponsableEnseigneGUI;
import org.opencv.core.Core;
import edu.esprit.tunisiamall.gui.ShadowedWindow;
import java.awt.image.BufferedImage;
import edu.esprit.tunisiamall.utils.SHA;
/**
 *
 * @author Safwene
 */
public class Test {
    public static void main(String[] args){

            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            //11111111111111111111111111111111111111

   // ShadowedWindow sh=new ShadowedWindow(new BufferedImage);

            LoginChoiseGUI loginGUI = new LoginChoiseGUI();
          loginGUI.setVisible(true);
  
    /*
            LoginGUI loginGUI = new LoginGUI();
          loginGUI.setVisible(true);
          
          /*
          SHA sha = new SHA();
          System.out.println(sha.get_SHA_512_SecurePassword("aa", "4qdr7dmqwcg0kgkww0gsc040cckgc44"));
          if (sha.get_SHA_512_SecurePassword("aa", "4qdr7dmqwcg0kgkww0gsc040cckgc44").equals("4cc9891557b28bedfe7ab972e35c099b11f8047207a247de5cb42c052e140ff29c1c70ad09557362c2d98965abcf3f36250b370724501def02fea6a386ed988f")){
              System.out.println("YES");
          }
          */
          
          
          
          
/*
            
            HomeAdmin homeAdmin = new HomeAdmin();
            homeAdmin.setVisible(true);
            
*/
  /*          ResponsableEnseigneGUI responsableEnseigneGUI =  ResponsableEnseigneGUI.getInstance();
            responsableEnseigneGUI.setIdResponsableEnseigne(3);
            responsableEnseigneGUI.setInformationsResponsableEnseigne();
            responsableEnseigneGUI.setVisible(true);
  */  
    }   

}
