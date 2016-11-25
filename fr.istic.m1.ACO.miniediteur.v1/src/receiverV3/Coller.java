package receiverV3;

public class Coller implements Command {

	private Receiver receiver;
	private Enregistreur recorder;
	private CaretakerMoteur caretaker;
	
	public Coller(Receiver receiver, Enregistreur recorder, CaretakerMoteur caretaker) {
		this.receiver = receiver;
		this.recorder = recorder;
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
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
