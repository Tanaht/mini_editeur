package receiverV3;

/**
 * Memento qui enregistre l'état interne de la commande Selectionner
 * @author 17004304
 *
 */
public class MementoSelectionner implements Memento {
	/**
	 * La selection effectué par la Commande Selectionner
	 */
	private int[] selection;
	
	/**
	 * Le constructeur de MementoSelectionner
	 * @param selection la selection à mémoriser
	 */
	public MementoSelectionner(int[] selection) {
		this.selection = selection;
	}
	
	/**
	 * 
	 * @return la selection mémorisée
	 */
	public int[] getSelection() {
		return this.selection;
	}
}
