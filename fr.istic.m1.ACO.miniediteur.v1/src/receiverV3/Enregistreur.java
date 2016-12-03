package receiverV3;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente le Caretaker du design pattern Memento
 * @author Antoine
 *
 */
public class Enregistreur {
	/**
	 * Une liste pour enregistré les références vers les commandes composant la macro
	 */
	private List<Command> commandes;
	/**
	 * Une liste pour enregistré les états de chaques commandes de la premières liste
	 */
	private List<Memento> mementos;
	
	/**
	 * Boolean qui indique si l'enregistreur est en train d'enregistrer une macro
	 */
	private boolean recording;
	/**
	 * Boolean qui indique si l'enregistreur est en train de rejouer une macro
	 */
	private boolean isplaying;
	
	/**
	 * Constructeur de l'enregistreur
	 * Initialise les deux listes de commandes et de mementos
	 */
	public Enregistreur() {
		this.commandes = new ArrayList<>();
		this.mementos = new ArrayList<>();
	}
	
	/**
	 * Action appelé par toutes les autres commandes (à l'exception de StartMacro, StopMacro, RedoMacro)
	 * quand l'enregistreur est en train d'enregistreur
	 */
	public void enregistrer(Command commande) {
		this.mementos.add(commande.getMemento());
		this.commandes.add(commande);
	}
	
	/**
	 * Action appelé par la commande RedoMacro qui rejoue la macro enregistrée
	 * @see RedoMacro.execute
	 */
	public void jouer() {
		Command commande = null;
		this.isplaying = true;
		for(int i = 0 ; i < commandes.size() ; i++) {
			commande = commandes.get(i);
			commande.setMemento(mementos.get(i));
			commande.execute();
		}
		this.isplaying = false;
	}
	
	/**
	 * Getter qui indique si l'enregistreur joue une macro
	 * @return
	 */
	public boolean isPlaying() {
		return this.isplaying;
	}
	
	/**
	 * Efface la macro enregistrer
	 */
	public void effacerMacro() {
		this.commandes = new ArrayList<>();
		this.mementos = new ArrayList<>();
	}
	
	/**
	 * Action appelé par la commande StartMacro
	 * @see StartMacro.execute
	 */
	public void enableRecording() {
		this.recording = true;
	}
	
	/**
	 * Action appelé par la commande StopMacro
	 * @see StopMacro.execute
	 */
	public void disableRecording() {
		this.recording = false;
	}
	
	/**
	 * Getter qui indique si l'enregistreur est en train d'enregistrer une macro
	 * @return
	 */
	public boolean isRecording() {
		return this.recording;
	}
	
	/**
	 * Getter qui indique si la macro est vide ou non
	 * @return
	 */
	public boolean isEmpty() {
		return this.commandes.size() == 0 && this.mementos.size() == 0;
	}
}
