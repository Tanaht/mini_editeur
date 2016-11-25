package receiverV3;

public class RedoMacro implements Command {

	private Enregistreur  recorder;
	private CaretakerMoteur caretaker;
	
	RedoMacro(Enregistreur recorder, CaretakerMoteur caretaker){
		this.recorder = recorder;
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
		caretaker.addMemento();
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
