package receiverV3;

public class MementoMoteur implements Memento {
	private String buffer;
	private Selection selection;
	private String clipboard;
	
	public MementoMoteur(String buffer, String clipboard, Selection selection) {
		this.buffer = buffer;
		this.clipboard = clipboard;
		
		try {
			this.selection = (Selection) selection.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	public String getClipboard() {
		return clipboard;
	}

	public void setClipboard(String clipboard) {
		this.clipboard = clipboard;
	}
	
}
