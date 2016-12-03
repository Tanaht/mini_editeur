package receiverV3;

import java.util.Stack;

/**
 * Le Bibliothécaire du design pattern memento, il enregistre les états du moteur entre chaque commandes sous forme de MementoMoteur
 * @author Antoine
 *
 */
public class CaretakerMoteur {
	/**
	 * La pile des états successeurs du moteur
	 */
	private Stack<MementoMoteur> suivants;
	/**
	 * La pile des états prédécesseurs du moteur
	 */
	private Stack<MementoMoteur> precedents;
	
	/**
	 * Le moteur
	 */
	private Receiver moteur;
	
	/**
	 * Le constructeur du caretaker
	 * @param moteur
	 */
	public CaretakerMoteur(Receiver moteur) {
		this.moteur = moteur;
		this.suivants = new Stack<>();
		this.precedents = new Stack<>();
	}
	
	/**
	 * Cette méthode permet d'enregistrer les différents états du moteur au file de l'execution
	 * Ajout en sommet de la pile des états prédécesseurs
	 * Supprime tout les états successeurs
	 */
	public void addMemento() {
		if(this.suivants.size() != 0)
			this.suivants.removeAllElements();
		
		this.precedents.push(moteur.createMemento());
	}
	
	/**
	 * Action appelé par la commande Redo
	 * @see Redo.execute
	 * Permet de dépiler le Memento de la pile des états successeurs et de l'appliquer au moteur
	 * Ajoute l'état actuel du moteur en sommet de pile des états prédécesseurs
	 * Si aucun états successeurs, ne fait rien
	 */
	public void redoEvent() {
		if(this.suivants.size() == 0)
			return;
		
		this.precedents.push(moteur.createMemento());
		moteur.setMemento(this.suivants.pop());
	}
	
	/**
	 * Action appelé par la commande Undo
	 * @see Undo.execute
	 * Permet de dépiler le Memento de la pile des états prédécesseurs et de l'appliquer au moteur
	 * Ajoute l'état actuel du moteur en sommet de pile des états successeurs
	 * Si aucun états prédécesseurs, ne fait rien
	 */
	public void undoEvent() {
		if(this.precedents.size() == 0)
			return;
		
		this.suivants.push(moteur.createMemento());
		moteur.setMemento(this.precedents.pop());
	}
}
