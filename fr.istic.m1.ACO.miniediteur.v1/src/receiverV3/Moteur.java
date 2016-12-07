package receiverV3;

/**
 * Le moteur du mini éditeur
 * Implémente l'interface Receiver du design pattern Command
 * @link Receiver
 * @author Antoine
 */
public class Moteur implements Receiver {
	/**
	 * Le buffer permet de sauvegarder le texte en cours d'édition par le mini éditeur
	 */
	private String buffer;
	
	/**
	 * la selection effectué sur le texte
	 */
	private Selection selection;
	
	/**
	 * Dans le cas d'un copy ou d'un cut, l'eventuel texte sélectionné est sauvegardé dans le presse papier.
	 */
	private String clipboard;
	
	/**
	 * 
	 * @return le presse papier
	 */
	public String getClipboard() {
		return clipboard;
	}
	
	/**
	 * Constructeur du moteur du mini éditeur
	 * Initialisation du buffer, du presse papier et de la selection.
	 */
	public Moteur() {
		this.selection = new Selection();
		this.buffer = "";
		this.clipboard = "";
	}
	
	@Override
	public void copier() {
		this.clipboard = this.selection.getSelectedText(buffer);
	}
	
	@Override
	public void couper() {
		this.clipboard = this.selection.getSelectedText(buffer);
		this.buffer = this.buffer.substring(0, this.selection.getStartSelection()) + this.buffer.substring(this.selection.getEndSelection());
		this.selection.resetSelection(this.selection.getStartSelection());
	}

	@Override
	public void coller() {
		//System.err.println("Texte to paste: [" + this.clipboard + "]");
		this.insTexte(this.clipboard);
	}

	@Override
	public void insTexte(String texte) {

		this.buffer = this.buffer.substring(0, this.selection.getStartSelection()) + texte + this.buffer.substring(this.selection.getEndSelection());
		
		if(this.selection.hasTextSelected()) {
			this.selection.resetSelection(this.selection.getStartSelection() + texte.length());
		}
		else {
			this.selection.moveForward(texte.length());
		}
		
	}

	@Override
	public void selectionner(int[] selection) {
		
		if(selection[0] < 0 || selection[1] > this.buffer.length() || selection[0] > selection[1]) {
			System.out.println("La selection est incorrecte, Veuillez réessayer");
			return;
		}
		
		this.selection.setSelection(selection[0], selection[1]);
	}
	
	@Override
	public String getBuffer() {
		if(this.selection.hasTextSelected()) {
			return this.buffer.substring(0, this.selection.getStartSelection()) + this.selection.getSelectedText(buffer) + this.buffer.substring(this.selection.getEndSelection());
		}
		return this.buffer.substring(0, this.selection.getStartSelection()) + this.buffer.substring(this.selection.getEndSelection());
	}
	
	@Override
	public int[] getSelection(){
		int[] selection = {this.selection.getStartSelection(), this.selection.getEndSelection()};
		return selection;
	}

	@Override
	public MementoMoteur createMemento() {
		return new MementoMoteur(this.buffer, this.clipboard, this.selection);
	}

	@Override
	public void setMemento(MementoMoteur memento) {
		this.clipboard = memento.getClipboard();
		this.buffer = memento.getBuffer();
		this.selection = memento.getSelection();
	}
}
