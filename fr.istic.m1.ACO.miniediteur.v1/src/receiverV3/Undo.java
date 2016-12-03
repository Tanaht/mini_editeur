package receiverV3;

public class Undo implements Command {

	private CaretakerMoteur caretaker;
	private Enregistreur recorder;
	
	
	public Undo(CaretakerMoteur caretaker, Enregistreur recorder) {
		this.caretaker = caretaker;
		this.recorder = recorder;
	}
	
	@Override
	public void execute() {
		
		if(recorder.isRecording())
			recorder.enregistrer(this);
		
		this.caretaker.undoEvent();
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(Memento m) {
	}
}
