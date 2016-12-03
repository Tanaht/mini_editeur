package receiver;

/**
 * La commande Copier, sert à copier
**/
public class Copier implements Command {

	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Constructeur de la classe Copier
	**/
	public Copier(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.copier();
	}

}
