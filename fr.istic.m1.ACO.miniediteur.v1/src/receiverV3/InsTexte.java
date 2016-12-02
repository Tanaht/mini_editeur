package receiverV3;

public class InsTexte implements Command {

	private Receiver receiver;
	private Enregistreur recorder;
	private IHM ihm;
	private MementoInserer memento;
	private CaretakerMoteur caretaker;
	
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
