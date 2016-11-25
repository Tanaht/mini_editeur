package receiver;

/**
 * La commande coller, sert à coller
**/
public class Coller implements Command {

	private Receiver receiver;
	
	/**
	 * Constructeur de la classe Coller
	**/
	public Coller(Receiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Appele la methode coller du moteur
	**/
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.coller();
	}

}
