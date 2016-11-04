package receiverV2;

public class StopMacro implements Command {
	
	private Enregistreur  recorder;
	
	StopMacro(Enregistreur recorder){
		this.recorder = recorder;
	}

	@Override
	public void execute() {
		this.recorder.disableRecording();
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
