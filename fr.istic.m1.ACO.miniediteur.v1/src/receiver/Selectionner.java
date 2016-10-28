package receiver;

public class Selectionner implements Command {
	private Receiver receiver;
	private IHM ihm;
	
	public Selectionner(Receiver receiver, IHM ihm) {
		this.receiver = receiver;
		this.ihm = ihm;
	}

	
	@Override
	public void execute() {
		this.receiver.selectionner(this.ihm.getSelection());
	}

}
