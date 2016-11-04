package receiverV2;

public class MementoSelectionner implements Memento {
	private int[] selection;
	
	public MementoSelectionner(int[] selection) {
		this.selection = selection;
	}
	
	public int[] getSelection() {
		return this.selection;
	}
}
