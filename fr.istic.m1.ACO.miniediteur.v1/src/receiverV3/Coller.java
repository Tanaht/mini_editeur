package receiverV3;

public class Coller implements Command {

	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento
	 */
	private Enregistreur recorder;
	
	/**
	 * Référence vers le caretaker qui enregistre les états du moteur à chaque commande
	 */
	private CaretakerMoteur caretaker;
	
	/**
	 * Constructeur de la classe Coller
	 * @param receiver
	 * @param recorder
	 * @param caretaker
	 */
	public Coller(Receiver receiver, Enregistreur recorder, CaretakerMoteur caretaker) {
		this.receiver = receiver;
		this.recorder = recorder;
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
		if(!recorder.isPlaying())
			caretaker.addMemento();
		
		if(recorder.isRecording())
			recorder.enregistrer(this);
		receiver.coller();
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
