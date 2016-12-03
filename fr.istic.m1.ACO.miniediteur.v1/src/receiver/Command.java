package receiver;

/**
 * L'interface Command, du design pattern homonyme qui permet de mettre en relation une IHM avec un moteur.
 * @author Antoine
 *
 */
public interface Command {
	/**
	 * Appele le moteur pour exécuter la commande en question.
	 */
	void execute();
}
