package receiverV3;


/**
 * L'interface Command, du design pattern homonyme qui permet de mettre en relation une IHM avec un moteur.
 * @since 2.0 l'interface remplit aussi le rôle de l'Originator du design pattern Memento
 * @author Antoine
 *
 */
public interface Command {
	/**
	 * Appele le moteur pour exécuter la commande en question.
	 * Si l'enregistreur est en train d'enregistrer une macro, un appelle à Enregistreur.enregistrer est également effectué
	 */
	void execute();
	
	/**
	 * 
	 * @return un memento représentant l'état interne de la commande
	 */
	Memento getMemento();
	
	/**
	 * Met à jour la commande avec le memento donnée en paramètre
	 * @param m le memento qui servira à mettre à jour l'état interne de la commande
	 */
	void setMemento(Memento m);
}
