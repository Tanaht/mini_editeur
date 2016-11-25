package receiverV3;

public class Selection implements Cloneable {
	private int start, end;
	
	public Selection() {
		this.start = 0;
		this.end = 0;
	}
	
	public Selection(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void moveForward(int step) {
		this.start += step;
		this.end += step;
	}
	
	public void moveBackward(int step) {
		this.start -= step;
		this.end -= step;
	}
	
	public void resetSelection(int position) {
		this.start = this.end = position;
	}
	
	public String getSelectedText(String buffer) {
		return buffer.substring(start, end);
	}
	
	public boolean hasTextSelected() {
		return this.start != this.end;
	}
	
	public int getStartSelection() {
		return this.start;
	}
	
	public int getEndSelection() {
		return this.end;
	}

	public void setSelection(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
