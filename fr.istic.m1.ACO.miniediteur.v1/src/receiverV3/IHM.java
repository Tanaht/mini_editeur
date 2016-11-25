package receiverV3;

public interface IHM {
	void eventCopier();
	void eventCouper();
	void eventColler();
	void eventRedo();
	void eventUndo();
	void eventStartMacro();
	void eventStopMacro();
	void eventRedoMacro();
	void eventInsererTexte(String texte);
	String getTexte();
	int[] getSelection();
	void eventSelectionner();
}
