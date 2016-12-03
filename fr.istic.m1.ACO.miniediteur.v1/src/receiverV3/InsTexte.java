package receiverV3;

public class InsTexte implements Command {

	/**
	 * Référence vers le caretaker qui enregistre les états du moteur à chaque commande
	 */
	private CaretakerMoteur caretaker;
	/**
	 * Référence à l'enregistreur qui joue le rôle de Caretaker pour le design pattern Memento
	 */
	private Enregistreur recorder;
	
	/**
	 * Le memento représentant l'état interne de la commande InsTexte
	 * @see MementoInserer
	 */
	private MementoInserer memento;
	
	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Référence vers l'IHM afin de récupérer le texte à insérer
	 */
	private IHM ihm;
	
	/**
	 * Le constructeur de la classe InsTexte
	 * @param receiver le moteur appelé par la commande
	 * @param ihm l'interface utilisateur qui appele la commande
	**/
	public InsTexte(Receiver receiver, Enregistreur recorder, IHM ihm, CaretakerMoteur caretaker) {
		this.receiver = receiver;
		this.recorder = recorder;
		this.ihm = ihm;
		this.caretaker = caretaker;
	}

	@Override
	public void execute() {
		if(!recorder.isPlaying()) {
			caretaker.addMemento();
			this.memento = new MementoInserer(this.ihm.getTexte());
		}
		
		if(recorder.isRecording())
			recorder.enregistrer(this);
		
		this.receiver.insTexte(this.memento.getTexte());
		

	}

	@Override
	public Memento getMemento() {
		return this.memento;
	}

	@Override
	public void setMemento(Memento m) {
		this.memento = (MementoInserer) m;
	}

}
