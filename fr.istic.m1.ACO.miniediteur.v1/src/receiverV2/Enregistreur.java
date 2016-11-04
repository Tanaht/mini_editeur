package receiverV2;

import java.util.ArrayList;
import java.util.List;

public class Enregistreur {
	private List<Command> commandes;
	private List<Memento> mementos;
	private boolean recording;
	
	public Enregistreur() {
		this.commandes = new ArrayList<>();
		this.mementos = new ArrayList<>();
	}
	
	public void enregistrer(Command commande) {
		this.mementos.add(commande.getMemento());
		this.commandes.add(commande);
	}
	
	public void jouer() {
		Command commande = null;
		
		for(int i = 0 ; i < commandes.size() ; i++) {
			commande = commandes.get(i);
			commande.setMemento(mementos.get(i));
			commande.execute();
		}
	}
	
	public void effacerMacro() {
		this.commandes = new ArrayList<>();
		this.mementos = new ArrayList<>();
	}
	
	public void enableRecording() {
		this.recording = true;
	}
	
	public void disableRecording() {
		this.recording = false;
	}
	
	public boolean isRecording() {
		return this.recording;
	}
}
