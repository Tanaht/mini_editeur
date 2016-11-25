package receiverV3;

public class Redo implements Command {

	private CaretakerMoteur caretaker;
	public Redo(CaretakerMoteur caretaker) {
		this.caretaker = caretaker;
	}
	
	@Override
	public void execute() {
		this.caretaker.redoEvent();
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
