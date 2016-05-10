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
/**
 *
 * @author Safwene
 */
public class Test {
    public static void main(String[] args){

            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

   // ShadowedWindow sh=new ShadowedWindow(new BufferedImage);
            LoginChoiseGUI loginGUI = new LoginChoiseGUI();
          loginGUI.setVisible(true);
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
