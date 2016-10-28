package receiver;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		Receiver moteur = new Moteur();
		
		IHMImpl ihm = new IHMImpl();
		
		Command copier = new Copier(moteur);
		Command coller = new Coller(moteur);
		Command couper = new Couper(moteur);
		Command insTexte = new InsTexte(moteur, ihm);
		Command selectionner = new Selectionner(moteur, ihm);
		
		ihm.setColler(coller);
		ihm.setCopier(copier);
		ihm.setCouper(couper);
		ihm.setInsTexte(insTexte);
		ihm.setSelectionner(selectionner);
		
		Main.run(ihm, moteur);

	}
	
	public static void run(IHMImpl ihm, Receiver moteur) {
		while ( ihm.prompt() ) {
			System.out.println("Buffer:\n" + moteur.getBuffer() + "\n");
		}
	}
}
