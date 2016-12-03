package receiver;

/**
 * Interface Receiver du design pattern Command
 * @author Antoine
 *
 */
public interface Receiver {
	/**
	 * Permet de copier le texte selectionnée dans le presse papier
	 */
	void copier();
	
	/**
	 * Permet de copier le texte selectionnée dans le presse papier,
	 * puis supprime le texte selectionnée du buffer.
	 * Met à jour la selection pour correspondre à la position du premier caractère du texte qui à été supprimé.
	 */
	void couper();
	
	/**
	 * Permet de coller le contenu du presse papier à la place de la selection,
	 * puis met à jour la selection pour correspondre à la position suivant le dernier caractère du texte qui vient d'etre collé
	 */
	void coller();
	
	/**
	 * Permet de mettre à jour la selection du texte
	 * @param selection un tableau de deux entier, représentant la selection, le premier entier inclue, le second exclue.
	 */
	void selectionner(int[] selection);
	
	/**
	 * Insère du texte à la place de la selection et met à jour la selection 
	 * pour correspondre à la position du dernier caractère insérée.
	 * @param texte le texte à insérer
	 */
	void insTexte(String texte);
	
	/**
	 * 
	 * @return un tableau de deux entiers représentant la selection.
	 */
	int[] getSelection();
	
	/**
	 * Getter du buffer du moteur
	 * @return le buffer représentant le texte en cours d'édition.
	 */
	public String getBuffer();
}
