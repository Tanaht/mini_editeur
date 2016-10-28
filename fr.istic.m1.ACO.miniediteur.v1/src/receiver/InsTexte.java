package receiver;

public class InsTexte implements Command {

	private Receiver receiver;
	private IHM ihm;
	
	public InsTexte(Receiver receiver, IHM ihm) {
		this.receiver = receiver;
		this.ihm = ihm;
	}

	@Override
	public void execute() {
		String texte = this.ihm.getTexte();
		this.receiver.insTexte(texte);

	}

}
