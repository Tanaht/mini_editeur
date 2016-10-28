package receiver;


public class Moteur implements Receiver {
	private String buffer;
	private int[] selection;
	private String clipboard;
	
	public Moteur() {
		this.buffer = "";
		this.selection = new int[2];
		this.selection[0] = 0;
		this.selection[1] = 0;
	}
	
	/**
	 * 
	 */
	@Override
	public void copier() {
		this.clipboard = this.buffer.substring(selection[0], selection[1]+1);
	}

	/**
	 */
	@Override
	public void couper() {
		this.clipboard = this.buffer.substring(selection[0], selection[1]+1);
		this.buffer = this.buffer.substring(0, this.selection[0]) + this.buffer.substring(this.selection[1]+1);
		
		this.selection[1] = this.selection[0];
	}

	/**
	 */
	@Override
	public void coller() {
		this.insTexte(this.clipboard);
	}

	/**
	 * 
	 */
	@Override
	public void insTexte(String texte) {
		if(this.selection[0] != this.selection[1])
			this.buffer = this.buffer.substring(0, this.selection[0]) + texte + this.buffer.substring(this.selection[1]+1);
		else
			this.buffer = this.buffer.substring(0, this.selection[0]) + texte + this.buffer.substring(this.selection[1]);
		
		this.selection[0] += texte.length();
		this.selection[1] += texte.length();
		
	}

	/**
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@Override
	public void selectionner(int[] selection) throws ArrayIndexOutOfBoundsException {
		
		if(selection[0] < 0 || selection[1] >= this.buffer.length() || selection[0] > selection[1]) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		this.selection = selection;
	}
	
	@Override
	public String getBuffer() {
		return this.buffer;
	}
	
	public int[] getSelection(){
		return this.selection;
	}
}
