package receiverV3;

/**
 * Memento qui permet de sauvegardé l'état du moteur
 * @author Antoine
 *
 */
public class MementoMoteur implements Memento {
	/**
	 * Le buffer permet de sauvegarder le texte en cours d'édition par le mini éditeur
	 */
	private String buffer;
	
	/**
	 * la selection effectué sur le texte
	 */
	private Selection selection;
	
	/**
	 * Dans le cas d'un copy ou d'un cut, l'eventuel texte sélectionné est sauvegardé dans le presse papier.
	 */
	private String clipboard;
	
	/**
	 * Le constructeur de MementoMoteur, prend en paramètre tout ce qu'il doit sauvegardé
	 * @param buffer
	 * @param clipboard
	 * @param selection
	 */
	public MementoMoteur(String buffer, String clipboard, Selection selection) {
		this.buffer = buffer;
		this.clipboard = clipboard;
		
		try {
			this.selection = (Selection) selection.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter du buffer
	 * @return le contenu du buffer
	 */
	public String getBuffer() {
		return buffer;
	}

	/**
	 * Setter du buffer
	 * @param buffer le buffer à mettre à jour
	 */
	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	/**
	 * Getter de la selection
	 * @return la selection
	 */
	public Selection getSelection() {
		return selection;
	}

	/**
	 * Setter de la selection 
	 * @param selection la nouvelle selection
	 */
	public void setSelection(Selection selection) {
		try {
			this.selection = (Selection) selection.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Getter du presse papier
	 * @return le contenu du presse papier
	 */
	public String getClipboard() {
		return clipboard;
	}

	/**
	 * Setter du presse papier
	 * @param clipboard le nouveau presse papier
	 */
	public void setClipboard(String clipboard) {
		this.clipboard = clipboard;
	}
	
}
