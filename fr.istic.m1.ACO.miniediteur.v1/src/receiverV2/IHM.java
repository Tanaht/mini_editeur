package receiverV2;

/**
 * Représente les différentes méthodes qui devront être implémentée par une IHM
 * @author Antoine
 *
 */
public interface IHM {
	/**
	 * Méthode qui va exécuter la commande Copier
	 * @link Copier
	 */
	void eventCopier();
	/**
	 * Méthode qui va exécuter la commande Couper
	 * @link Couper
	 */
	void eventCouper();
	/**
	 * Méthode qui va exécuter la commande Coller
	 * @link Coller
	 */
	void eventColler();
	/**
	 * Méthode qui va exécuter la commande InsTexte
	 * @link InsTexte
	 * @param texte le texte à insérer
	 */
	void eventInsererTexte(String texte);
	/**
	 * Méthode qui retourne le texte insérer par l'utilisateur
	 * @see InsTexte.execute
	 */
	String getTexte();
	
	/**
	 * Méthode qui retourne la selection entrée par l'utilisateur
	 * @see Selectionner.execute
	 * @return un tableau de deux entiers représentant la selection.
	 */
	int[] getSelection();
	
	/**
	 * Méthode qui va exécuter la commande Selectionner
	 * @link Selectionner
	 */
	void eventSelectionner();
	
	/**
	 * Setter qui donne la commande Copier à l'IHM
	 * @param copier une instance de Copier
	 */
	public void setCopier(Command copier);

	/**
	 * Setter qui donne la commande Couper à l'IHM
	 * @param couper une instance de Couper
	 */
	public void setCouper(Command couper);

	/**
	 * Setter qui donne la commande Coller à l'IHM
	 * @param coller une instance de Coller
	 */
	public void setColler(Command coller);

	/**
	 * Setter qui donne la commande InsTexte à l'IHM
	 * @param insTexte une instance de InstTexte
	 */
	public void setInsTexte(Command insTexte);

	/**
	 * Setter qui donne la commande Selectionner à l'IHM
	 * @param selectionner une instance de Selectionner
	 */
	public void setSelectionner(Command selectionner);
	
	/**
	 * Setter qui donne la commande RedoMacro à l'IHM
	 * @param redoMacro une instance de RedoMacro
	 */
	void setRedoMacro(Command redoMacro);
	
	/**
	 * Setter qui donne la commande StopMacro à l'IHM
	 * @param stopMacro une instance de StopMacro
	 */
	void setStopMacro(Command stopMacro);
	
	/**
	 * Setter qui donne la commande StartMacro à l'IHM
	 * @param startMacro une instance de StartMacro
	 */
	void setStartMacro(Command startMacro);
}
