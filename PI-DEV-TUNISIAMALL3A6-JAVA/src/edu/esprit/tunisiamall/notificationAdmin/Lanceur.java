package edu.esprit.tunisiamall.notificationAdmin;


public class Lanceur {

	public static void main(String[] args){
		Notifieur notifieur = new Notifieur(
				"Le titre", 
				"Le texte � afficher dans le message", 
				TypeNotification.ERREUR
		);
		notifieur.start();
	}

}
