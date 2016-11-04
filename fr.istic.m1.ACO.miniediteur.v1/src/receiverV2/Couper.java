package receiverV2;

public class Couper implements Command {

	private Receiver receiver;
	private Enregistreur recorder;
	
	public Couper(Receiver receiver, Enregistreur recorder) {
		this.receiver = receiver;
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
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
