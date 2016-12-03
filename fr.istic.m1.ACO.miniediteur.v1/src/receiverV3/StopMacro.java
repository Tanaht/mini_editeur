package receiverV3;


public class StopMacro implements Command {
	
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento, et de Receiver pour cette commande
	 */
	private Enregistreur  recorder;
	
	/**
	 * Constructeur de la classe StopMacro
	 * @param recorder
	 */
	StopMacro(Enregistreur recorder){
		this.recorder = recorder;
	}

	@Override
	public void execute() {
		this.recorder.disableRecording();
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
