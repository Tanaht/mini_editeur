package receiver;

public class Copier implements Command {

	private Receiver receiver;
	
	public Copier(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.copier();
	}

}
