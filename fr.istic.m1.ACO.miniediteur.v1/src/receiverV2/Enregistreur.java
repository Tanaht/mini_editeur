package receiverV2;

import java.util.ArrayList;
import java.util.List;

/**
 * Permet d'enregistrer et de rejouer une macro.
 * @author 17004304
 * @link {@link RedoMacro} {@link StopMacro} {@link StartMacro}
 */
public class Enregistreur {
	
	/**
	 * Une liste de références vers les différentes commandes composant la macro
	 */
	private List<Command> commandes;
	
	/**
	 * Une liste de Mementos pour rejouer les commandes proprement.
	 */
	private List<Memento> mementos;
	
	/**
	 * Booleen permettant de savoir si le mode d'enregistrement est actif ou non
	 */
	private boolean recording;
	
	/**
	 * Constructeur de la classe Enregistreur
	 */
	public Enregistreur() {
		this.commandes = new ArrayList<>();
		this.mementos = new ArrayList<>();
	}
	
	/**
	 * Méthode qui enregistre une commande et son memento correspondant.
	 * @param commande la commande à enregistrer
	 */
	public void enregistrer(Command commande) {
		this.mementos.add(commande.getMemento());
		this.commandes.add(commande);
	}
	
	/**
	 * Méthode qui permet de rejouer une macro
	 */
	public void jouer() {
		Command commande = null;
		
		for(int i = 0 ; i < commandes.size() ; i++) {
			commande = commandes.get(i);
			commande.setMemento(mementos.get(i));
			commande.execute();
		}
	}
	
	/**
	 * Méthode qui efface la macro.
	 */
	public void effacerMacro() {
		this.commandes = new ArrayList<>();
		this.mementos = new ArrayList<>();
	}
	
	/**
	 * Méthode qui active l'enregistrement
	 * @see Enregistreur.recording
	 */
	public void enableRecording() {
		this.recording = true;
	}
	
	/**
	 * Méthode qui désactive l'enregistrement
	 * @see Enregistreur.recording
	 */
	public void disableRecording() {
		this.recording = false;
	}
	
	/**
	 * Indique si l'enregistreur enregistre.
	 * @see Enregistreur.recording
	 * @return True si Enregistreur.recording est Vrai
	 */
	public boolean isRecording() {
		return this.recording;
	}
	
	/**
	 * Indique si la macro est vide
	 * @return True si aucune commande n'est enregistrer
	 * @see Enregistreur.commandes, Enregistreur.mementos
	 */
	public boolean isEmpty() {
		return this.commandes.size() == 0 && this.mementos.size() == 0;
	}
}
