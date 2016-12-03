package receiver;

/**
 * La commande InsTexte, sert à insérer du texte
**/
public class InsTexte implements Command {

	/**
	 * Référence au receiver qui sera appelé à chaque exécution de la commande
	 */
	private Receiver receiver;
	
	/**
	 * Référence vers l'IHM afin de récupérer le texte à insérer
	 */
	private IHM ihm;
	
	/**
	 * Le constructeur de la classe InsTexte
	 * @param receiver le moteur appelé par la commande
	 * @param ihm l'interface utilisateur qui appele la commande
	**/
	public InsTexte(Receiver receiver, IHM ihm) {
		this.receiver = receiver;
		this.ihm = ihm;
	}

	/**
	 * Récupère le texte dans l'IHM et appelle la methode du moteur avec le texte en paramètre
	 * @see Receiver.insTexte
	**/
	@Override
	public void execute() {
		String texte = this.ihm.getTexte();
		this.receiver.insTexte(texte);

	}

}
