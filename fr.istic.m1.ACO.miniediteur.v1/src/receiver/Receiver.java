package receiver;

public interface Receiver {
	void copier();
	void couper();
	void coller();
	void selectionner(int[] selection);
	void insTexte(String texte);
	int[] getSelection();
	public String getBuffer();
}
