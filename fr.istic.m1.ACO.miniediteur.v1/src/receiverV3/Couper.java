package receiverV3;

public class Couper implements Command {

	private Receiver receiver;
	private Enregistreur recorder;
	private CaretakerMoteur caretaker;
	
	public Couper(Receiver receiver, Enregistreur recorder, CaretakerMoteur caretaker) {
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
		receiver.couper();
		

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
