package receiverV2;

public class StartMacro implements Command {
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento, et de Receiver pour cette commande
	 */
	private Enregistreur  recorder;
	
	/**
	 * Constructeur de la classe StartMacro
	 * @param recorder
	 */
	StartMacro(Enregistreur recorder){
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		recorder.effacerMacro();
		recorder.enableRecording();
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
