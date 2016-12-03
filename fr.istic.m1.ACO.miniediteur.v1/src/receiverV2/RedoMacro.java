package receiverV2;

/**
 * Commande RedoMacro qui permet de rejouer la macro enregistrée
 * @author Antoine
 *
 */
public class RedoMacro implements Command {

	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento, et de Receiver pour cette commande
	 */
	private Enregistreur  recorder;
	
	/**
	 * Constructeur de la classe RedoMacro
	 * @param recorder
	 */
	RedoMacro(Enregistreur recorder){
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		this.recorder.jouer();
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(Memento m) {
		// TODO Auto-generated method stub
		
	}

}
