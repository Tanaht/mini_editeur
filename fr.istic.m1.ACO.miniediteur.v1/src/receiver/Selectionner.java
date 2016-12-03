package receiver;

/**
 * La commande Selectionner, sert à selectionner une sous partie du buffer, ou positionner le curseur
 * (Une selection vide correspond à la position du curseur)
**/
public class Selectionner implements Command {
	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Référence vers l'IHM afin de récupérer la selection de l'utilisateur
	 */
	private IHM ihm;
	
	/**
	 * Le constructeur de la classe Selectionner
	 * @param receiver le moteur
	 * @param ihm l'interface utilisateur
	**/
	public Selectionner(Receiver receiver, IHM ihm) {
		this.receiver = receiver;
		this.ihm = ihm;
	}

	@Override
	public void execute() {
		this.receiver.selectionner(this.ihm.getSelection());
	}

}
