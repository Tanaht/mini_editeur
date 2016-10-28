package receiver;

public interface IHM {
	void eventCopier();
	void eventCouper();
	void eventColler();
	void eventInsererTexte();
	String getTexte();
	int[] getSelection();
	void eventSelectionner();
}
