package receiverV3;

/**
 * Memento qui enregistre l'état interne de la commande InsTexte
 * @author 17004304
 * @link InsTexte
 */
public class MementoInserer implements Memento {
	
	/**
	 * Le texte à insérer pour la commande InsTexte
	 */
	private String texte;
	
	/**
	 * Constructeur de MementoInserer
	 * @param texte le texte dont le memento doit se souvenir.
	 */
	public MementoInserer(String texte){
		this.texte = texte;
	}

	/**
	 * 
	 * @return Le texte à insérer.
	 */
	public String getTexte() {
		return this.texte;
	}
}
