package receiverV3;

import java.util.Stack;

public class CaretakerMoteur {
	private Stack<MementoMoteur> suivants;
	private Stack<MementoMoteur> precedents;
	private Receiver moteur;
	
	public CaretakerMoteur(Receiver moteur) {
		this.moteur = moteur;
		this.suivants = new Stack<>();
		this.precedents = new Stack<>();
	}
	
	/**
	 * Cette méthode permet d'enregistrer les différents états du moteur au file de l'execution
	 * @param memento
	 */
	public void addMemento() {
		if(this.suivants.size() != 0)
			this.suivants.removeAllElements();
		
		this.precedents.push(moteur.createMemento());
	}
	
	public void redoEvent() {
		if(this.suivants.size() == 0)
			return;
		
		this.precedents.push(moteur.createMemento());
		moteur.setMemento(this.suivants.pop());
	}
	
	public void undoEvent() {
		if(this.precedents.size() == 0)
			return;
		
		this.suivants.push(moteur.createMemento());
		moteur.setMemento(this.precedents.pop());
	}
}
