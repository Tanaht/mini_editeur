package receiver;

/**
 * La commande coller, sert à coller
**/
public class Coller implements Command {

	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Constructeur de la classe Coller
	**/
	public Coller(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.coller();
	}

}
