package receiverV2;

public class MementoInserer implements Memento {
	
	private String texte;
	
	public MementoInserer(String texte){
		this.texte = texte;
	}

	public String getTexte() {
		return this.texte;
	}
}
