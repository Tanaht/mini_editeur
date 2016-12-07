package receiverV3;

public class Main {
	
	/**
	 * Point d'entrée du programme, initialise les commandes, le moteur, l'enregistruer et l'ihm
	 * @param args
	 */
	public static void main(String[] args) {
	
		Enregistreur recorder = new Enregistreur();
		Receiver moteur = new Moteur();
		CaretakerMoteur caretaker = new CaretakerMoteur(moteur);
		
		IHMImpl ihm = new IHMImpl();
		
		Command copier = new Copier(moteur, recorder, caretaker);
		Command coller = new Coller(moteur, recorder, caretaker);
		Command couper = new Couper(moteur, recorder, caretaker);
		Command insTexte = new InsTexte(moteur, recorder, ihm, caretaker);
		Command selectionner = new Selectionner(moteur, recorder, ihm, caretaker);
		Command startMacro = new StartMacro(recorder);
		Command stopMacro = new StopMacro(recorder);
		Command redoMacro = new RedoMacro(recorder, caretaker);
		
		Command undo = new Undo(caretaker, recorder);
		Command redo = new Redo(caretaker, recorder);
		
		ihm.setUndo(undo);
		ihm.setRedo(redo);
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
		System.out.println("Auteurs:\n\tAntoine CHARPENTIER\n\tLouis AUDREN\nPour voir la liste des commandes tapez '::help'\nPour fermer tapez '::end'");
		while ( ihm.prompt() ) {
			System.out.println("Buffer:\n" + moteur.getBuffer() + "\n");
		}
	}
}
