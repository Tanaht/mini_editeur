package receiverV3;

public interface Receiver {
	void copier();
	void couper();
	void coller();
	void selectionner(int[] selection);
	void insTexte(String texte);
	int[] getSelection();
	public String getBuffer();
	
	//Originator parts
	MementoMoteur createMemento();
	void setMemento(MementoMoteur memento);
}
