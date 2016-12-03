package receiverV2;

public class Selectionner implements Command {
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento
	 */
	private Enregistreur recorder;
	
	/**
	 * Le memento représentant l'état interne de la commande Selectionner
	 * @see MementoSelectionner
	 */
	private MementoSelectionner memento;
	
	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Référence vers l'IHM afin de récupérer la selection à utiliser
	 */
	private IHM ihm;
	
	/**
	 * Le constructeur de la classe Selectionner
	 * @param receiver le moteur appelé par la commande
	 * @param ihm l'interface utilisateur qui appele la commande
	**/
	public Selectionner(Receiver receiver, Enregistreur recorder, IHM ihm) {
		this.receiver = receiver;
		this.recorder = recorder;
		this.ihm = ihm;
	}

	
	@Override
	public void execute() {
		if(!recorder.isPlaying()) {
			this.memento = new MementoSelectionner(this.ihm.getSelection());
		}
		
		if(recorder.isRecording())
			recorder.enregistrer(this);
		
		this.receiver.selectionner(this.memento.getSelection());
	}


	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return this.memento;
	}


	@Override
	public void setMemento(Memento m) {
		this.memento = (MementoSelectionner) m;
	}

}
