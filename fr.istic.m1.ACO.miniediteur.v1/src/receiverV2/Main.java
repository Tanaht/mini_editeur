package receiverV2;


public class Main {
	
	/**
	 * Point d'entrée du programme, initialise les commandes, le moteur, l'enregistruer et l'ihm
	 * @param args
	 */
	public static void main(String[] args) {
	
		Enregistreur recorder = new Enregistreur();
		Receiver moteur = new Moteur();
		IHMImpl ihm = new IHMImpl();
		
		Command copier = new Copier(moteur, recorder);
		Command coller = new Coller(moteur, recorder);
		Command couper = new Couper(moteur, recorder);
		Command insTexte = new InsTexte(moteur, recorder, ihm);
		Command selectionner = new Selectionner(moteur, recorder, ihm);
		Command startMacro = new StartMacro(recorder);
		Command stopMacro = new StopMacro(recorder);
		Command redoMacro = new RedoMacro(recorder);
		
		ihm.setColler(coller);
		ihm.setCopier(copier);
		ihm.setCouper(couper);
		ihm.setInsTexte(insTexte);
		ihm.setSelectionner(selectionner);
		ihm.setStartMacro(startMacro);
		ihm.setStopMacro(stopMacro);
		ihm.setRedoMacro(redoMacro);
		Main.run(ihm, moteur);

	}
	
	/**
	 * Fait tourner le moteur
	 * @param ihm
	 * @param moteur
	 */
	public static void run(IHMImpl ihm, Receiver moteur) {
		while ( ihm.prompt() ) {
			System.out.println("Buffer:\n" + moteur.getBuffer() + "\n");
		}
	}
}
