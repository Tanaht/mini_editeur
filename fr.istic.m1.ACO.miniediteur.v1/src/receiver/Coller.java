package receiver;

public class Coller implements Command {

	private Receiver receiver;
	
	public Coller(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.coller();
	}

}
