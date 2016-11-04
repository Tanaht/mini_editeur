package receiverV2;

public class Copier implements Command {
	
	private Enregistreur recorder;
	private Receiver receiver;
	
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
