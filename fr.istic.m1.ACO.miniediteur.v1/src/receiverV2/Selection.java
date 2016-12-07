package receiverV2;


/**
 * Représente le curseur ou le texte selectionner
 * @author Antoine
 *
 */
public class Selection {
	/**
	 * Correspond à la position du début de la selection inclus et de la fin de la selection exclus
	 */
	private int start, end;
	
	/**
	 * Constructeur de la classe Selection, initialise la position de la Selection à 0:0
	 */
	public Selection() {
		this.start = 0;
		this.end = 0;
	}
	
	/**
	 * Augmente la position de la selection en fonction du nombre donnée en paramètre.
	 * @param step un entier représentant la valeur à ajouter à la position de la selection
	 * @throws IllegalArgumentException Lève une exception si le paramètre est inférieur ou égale à 0
	 */
	public void moveForward(int step) throws IllegalArgumentException {
		if(step <= 0)
			throw new IllegalArgumentException("Impossible de traiter une valeur négative ou nulle");
		
		this.start += step;
		this.end += step;
	}
	
	/**
	 * Diminue la position de la selection en fonction du nombre donnée en paramètre.
	 * @param step un entier représentant  la valeur à soustraire à la position de la selection
	 * @throws IllegalArgumentException Lève une exception si le paramètre est inférieur ou égale à 0, ou supérieur à une des deux valeurs de la selection
	 */
	public void moveBackward(int step) throws IllegalArgumentException {
		if(step <= 0 || step > Math.min(this.start, this.end))
			throw new IllegalArgumentException();
		this.start -= step;
		this.end -= step;
	}
	
	/**
	 * Met à jour la position de la selection avec le nombre donnée en paramètre
	 * @param position un entier supérieur ou égale à 0 représentant la nouvelle position du curseur
	 * @throws IllegalArgumentException si la position en paramètre est négative
	 */
	public void resetSelection(int position) throws IllegalArgumentException{
		if(position < 0)
			throw new IllegalArgumentException("La position du curseur ne peut être négative");
		
		this.start = this.end = position;
	}
	
	/**
	 * Retourne la selection en fonction du buffer
	 * @param buffer le buffer 
	 * @return une sous chaine du buffer.
	 * @throws ArrayIndexOutOfBoundsException si le texte selectionner ne correspond pas à la taille du buffer
	 */
	public String getSelectedText(String buffer) throws ArrayIndexOutOfBoundsException {
		if(this.start < 0 || this.end < 0 || this.start > buffer.length() || this.end > buffer.length())
			throw new ArrayIndexOutOfBoundsException("La selection ne correspond pas à la taille du buffer");
		return buffer.substring(start, end);
	}
	
	/**
	 * Retourne un boolean qui indique si la selection contient du texte.
	 * @return un boolean égale à vrai si les extrémité de la selection ne sont pas égales
	 */
	public boolean hasTextSelected() {
		return this.start != this.end;
	}
	
	/**
	 * 
	 * @return la position du premier caractère de la selection
	 */
	public int getStartSelection() {
		return this.start;
	}
	
	/**
	 * 
	 * @return la position suivant le dernier caractère de la selection
	 */
	public int getEndSelection() {
		return this.end;
	}

	/**
	 * Met à jour la sélection
	 * @param start la position du début de la selection
	 * @param end la position de fin de la selection [exclue]
	 * @throws IllegalArgumentException si les paramètres sont incohérent (selection négative ou à l'envers)
	 */
	public void setSelection(int start, int end) throws IllegalArgumentException {
		if(start < 0 || end < 0 || end < start)
			throw new IllegalArgumentException("Les valeurs de mises à jour de la selection sont invalides");
		this.start = start;
		this.end = end;
	}
}

