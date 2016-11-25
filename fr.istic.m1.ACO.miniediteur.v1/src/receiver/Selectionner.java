package receiver;

/**
 * La commande Selectionner, sert à selectionner une sous partie du buffer, ou placer le curseur
**/
public class Selectionner implements Command {
	private Receiver receiver;
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

	/**
	 * Récupère la sélection dans l'IHM et la transfère au moteur
	**/
	@Override
	public void execute() {
		this.receiver.selectionner(this.ihm.getSelection());
	}

}
