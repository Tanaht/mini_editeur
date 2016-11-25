package receiverV3;

public class Undo implements Command {

	private CaretakerMoteur caretaker;
	public Undo(CaretakerMoteur caretaker) {
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
		this.caretaker.undoEvent();
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return new MementoImpl();
	}

	@Override
	public void setMemento(Memento m) {
	}
}
