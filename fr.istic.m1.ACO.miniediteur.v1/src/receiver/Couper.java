package receiver;

public class Couper implements Command {

	private Receiver receiver;
	
	public Couper(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.couper();
	}

}
