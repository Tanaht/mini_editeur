package receiverV2;

public class InsTexte implements Command {

	private Receiver receiver;
	private Enregistreur recorder;
	private IHM ihm;
	private MementoInserer memento;
	
	public InsTexte(Receiver receiver, Enregistreur recorder, IHM ihm) {
		this.receiver = receiver;
		this.recorder = recorder;
		this.ihm = ihm;
	}

	@Override
	public void execute() {
		this.memento = new MementoInserer(this.ihm.getTexte());
		
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
