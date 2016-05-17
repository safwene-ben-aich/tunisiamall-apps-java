package edu.esprit.tunisiamall.notificationAdmin;

import java.awt.Color;

/**
 * <b>TypeNotification est la classe qui permet de d�finir les types de notification</b>
 * <p>
 * Cette classe est caract�ris�e par les informations suivantes :
 * <ul>
 * <li>La couleur du coin haut gauche</li>
 * <li>La couleur du coin bas droit</li>
 * </ul>
 * </p>
 * <p>
 * Cette classe poss�de �galement des accesseurs sur ces couleurs.
 * </p>
 * <p>
 * Dans cette classe sont pr�d�finis des types de notifications rouges verts et bleus
 * correspondant � erreur, confirmation, information
 * </p>
 * 
 * @author Julien
 * @version 1.0
 *
 */
public class TypeNotification {
	
	/**
	 * Type de notification pr�d�finit "erreur"
	 */
	public static TypeNotification ERREUR = new TypeNotification(Color.red, Color.WHITE);
	
	/**
	 * Type de notification pr�d�finit "information"
	 */
	public static TypeNotification INFO = new TypeNotification(new Color(100, 100, 255), Color.WHITE);
	
	/**
	 * Type de notification pr�d�finit "confirmation"
	 */
	public static TypeNotification VALIDATION = new TypeNotification(Color.GREEN, Color.WHITE);
	
	/**
	 * La couleur du coin haut gauche
	 */
	private Color couleur1;
	
	/**
	 * La couleur du coin bas droit
	 */
	private Color couleur2;

	
	/**
	 * <b>Constructeur de PanelGradient</b>
	 * @param couleur1
	 * 	La couleur du coin haut gauche
	 * @param couleur2
	 * 	La couleur du coin bas droit
	 */
	public TypeNotification(Color couleur1, Color couleur2) {
		this.couleur1 = couleur1;
		this.couleur2 = couleur2;
	}
	
	/**
	 * @return the couleur1
	 */
	public Color getCouleur1() {
		return couleur1;
	}
	
	/**
	 * @return the couleur2
	 */
	public Color getCouleur2() {
		return couleur2;
	}
	

}
