package receiver;


public class Moteur implements Receiver {
	private String buffer;
	private Selection selection;
	private String clipboard;
	
	public Moteur() {
		this.selection = new Selection();
		this.buffer = "";
	}
	
	/**
	 * 
	 */
	@Override
	public void copier() {
		this.clipboard = this.selection.getSelectedText(buffer);
	}

	/**
	 */
	@Override
	public void couper() {
		this.clipboard = this.selection.getSelectedText(buffer);
		this.buffer = this.buffer.substring(0, this.selection.getStartSelection()) + this.buffer.substring(this.selection.getEndSelection());
		this.selection.resetSelection(this.selection.getStartSelection());
	}

	/**
	 */
	@Override
	public void coller() {
		//System.err.println("Texte to paste: [" + this.clipboard + "]");
		this.insTexte(this.clipboard);
	}

	/**
	 * 
	 */
	@Override
	public void insTexte(String texte) {
		if(this.selection.hasTextSelected())
			this.buffer = this.buffer.substring(0, this.selection.getStartSelection()) + texte + this.buffer.substring(this.selection.getEndSelection());
		else
			this.buffer = this.buffer.substring(0, this.selection.getStartSelection()) + texte + this.buffer.substring(this.selection.getEndSelection());
		
		this.selection.moveForward(texte.length());
		
	}

	/**
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@Override
	public void selectionner(int[] selection) throws ArrayIndexOutOfBoundsException {
		
		if(selection[0] < 0 || selection[1] > this.buffer.length() || selection[0] > selection[1]) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		this.selection.setSelection(selection[0], selection[1]);
	}
	
	@Override
	public String getBuffer() {
		if(this.selection.hasTextSelected()) {
			return this.buffer.substring(0, this.selection.getStartSelection()) + "\u001B[32m" + this.selection.getSelectedText(buffer) + "\u001B[0m" + this.buffer.substring(this.selection.getEndSelection());
		}
		return this.buffer.substring(0, this.selection.getStartSelection()) + "\u001B[32mI\u001B[0m" + this.buffer.substring(this.selection.getEndSelection());
	}
	
	public int[] getSelection(){
		int[] selection = {this.selection.getStartSelection(), this.selection.getEndSelection()};
		return selection;
	}
}
