package receiver;

/**
 * La commande Couper, sert à couper
**/
public class Couper implements Command {

	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Le constructeur de la classe Couper
	**/
	public Couper(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.couper();
	}

}
