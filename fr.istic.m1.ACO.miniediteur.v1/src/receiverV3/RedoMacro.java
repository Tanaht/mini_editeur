package receiverV3;

public class RedoMacro implements Command {
	
	/**
	 * Référence vers le caretaker qui enregistre les états du moteur à chaque commande
	 */
	private CaretakerMoteur caretaker;
	
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento, et de Receiver pour cette commande
	 */
	private Enregistreur  recorder;
	
	/**
	 * Constructeur de la classe RedoMacro
	 * @param recorder
	 */
	RedoMacro(Enregistreur recorder, CaretakerMoteur caretaker){
		this.recorder = recorder;
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
		caretaker.addMemento();
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
