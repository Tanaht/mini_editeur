package receiverV3;

public interface Command {
	void execute();
	
	Memento getMemento();
	
	void setMemento(Memento m);
}
