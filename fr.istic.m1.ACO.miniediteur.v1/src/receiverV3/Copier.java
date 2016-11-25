package receiverV3;

public class Copier implements Command {
	
	private Enregistreur recorder;
	private Receiver receiver;
	private CaretakerMoteur caretaker;
	
	public Copier(Receiver receiver, Enregistreur recorder, CaretakerMoteur caretaker) {
		this.receiver = receiver;
		this.recorder = recorder;
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
		caretaker.addMemento();
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
