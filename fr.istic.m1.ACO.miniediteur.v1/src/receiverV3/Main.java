package receiverV3;


public class Main {
	
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
		
		Command undo = new Undo(caretaker);
		Command redo = new Redo(caretaker);
		
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
	
	public static void run(IHMImpl ihm, Receiver moteur) {
		while ( ihm.prompt() ) {
			System.out.println("Buffer:\n" + moteur.getBuffer() + "\n");
		}
	}
}
