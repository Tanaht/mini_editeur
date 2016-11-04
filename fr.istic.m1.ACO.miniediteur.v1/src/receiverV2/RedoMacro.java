package receiverV2;

public class RedoMacro implements Command {

	private Enregistreur  recorder;
	
	RedoMacro(Enregistreur recorder){
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		this.recorder.jouer();
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
