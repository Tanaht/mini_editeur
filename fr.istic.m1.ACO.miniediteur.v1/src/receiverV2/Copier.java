package receiverV2;

public class Copier implements Command {
	
	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento
	 */
	private Enregistreur recorder;
	
	/**
	 * Constructeur de la classe Copier
	 * @param receiver
	 * @param recorder
	 */
	public Copier(Receiver receiver, Enregistreur recorder) {
		this.receiver = receiver;
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		if(recorder.isRecording())
			recorder.enregistrer(this);
		receiver.copier();
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
