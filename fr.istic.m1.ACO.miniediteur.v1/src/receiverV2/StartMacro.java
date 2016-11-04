package receiverV2;

public class StartMacro implements Command {
	private Enregistreur  recorder;
	
	StartMacro(Enregistreur recorder){
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		recorder.effacerMacro();
		recorder.enableRecording();
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
