package receiverV2;

public class Selectionner implements Command {
	private Receiver receiver;
	private Enregistreur recorder;
	private IHM ihm;
	private MementoSelectionner memento;
	
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
