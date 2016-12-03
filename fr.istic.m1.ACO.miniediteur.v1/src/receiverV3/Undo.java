package receiverV3;

public class Undo implements Command {

	/**
	 * Référence vers le caretaker qui enregistre les états du moteur à chaque commande, et qui est le Receiver pour cette commande
	 */
	private CaretakerMoteur caretaker;
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento
	 */
	private Enregistreur recorder;
	
	/**
	 * Constructeur de la classe Undo
	 * @param caretaker
	 * @param recorder
	 */
	public Undo(CaretakerMoteur caretaker, Enregistreur recorder) {
		this.caretaker = caretaker;
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		
		if(recorder.isRecording())
			recorder.enregistrer(this);
		
		this.caretaker.undoEvent();
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(Memento m) {
	}
}
