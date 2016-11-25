package receiver;

/**
 * La commande Copier, sert à copier
**/
public class Copier implements Command {

	private Receiver receiver;
	
	/**
	 * Constructeur de la classe Copier
	**/
	public Copier(Receiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Appelle la methode copier du moteur
	**/
	@Override
	public void execute() {
		receiver.copier();
	}

}
