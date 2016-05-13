package edu.esprit.tunisiamall.utils;

public class Animateur extends Thread {

	private final Banniere banniere;
	private final boolean actif=true;

	public Animateur(Banniere banniere){
		this.banniere=banniere;
	}

	@Override
	public void run(){
		while(actif){
			try {
				Thread.sleep(100);
				banniere.avancer();
			} 
			catch (InterruptedException e) {
			}
		}
	}

}
