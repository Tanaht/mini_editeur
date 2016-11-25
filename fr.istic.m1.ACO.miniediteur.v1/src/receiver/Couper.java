package receiver;

/**
 * La commande Couper, sert à couper
**/
public class Couper implements Command {

	private Receiver receiver;
	
	/**
	 * Le constructeur de la classe Couper
	**/
	public Couper(Receiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Appelle la methode couper du moteur
	**/
	@Override
	public void execute() {
		receiver.couper();
	}

}
