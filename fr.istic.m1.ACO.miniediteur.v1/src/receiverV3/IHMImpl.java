package receiverV3;

import java.util.Scanner;

public class IHMImpl implements IHM {
	
	private String texteTapper;
	private Command copier, couper, coller, insTexte, selectionner, stopMacro, startMacro, redoMacro, undo, redo;
	
	private int[] sel;
	private Scanner sc;
	
	public IHMImpl() {
		this.texteTapper = "";
		this.sc = new Scanner(System.in);
		
		sel = new int[2];
		sel[0] = 0; sel[1] = 0;
		
	}
	
	@Override
	public void eventStartMacro(){
		startMacro.execute();
	}
	
	@Override
	public void eventStopMacro(){
		stopMacro.execute();
	}
	
	@Override
	public void eventRedoMacro(){
		redoMacro.execute();
	}
	
	@Override
	public void eventCopier() {
		copier.execute();
	}

	@Override
	public void eventCouper() {
		couper.execute();
	}

	@Override
	public void eventColler() {
		coller.execute();
	}

	@Override
	public void eventInsererTexte(String texte) {
		this.texteTapper = texte;
		insTexte.execute();
	}
	
	@Override
	public void eventSelectionner() {
		selectionner.execute();
	}
	
	@Override
	public void eventRedo() {
		this.redo.execute();
		
	}

	@Override
	public void eventUndo() {
		this.undo.execute();
	}

	@Override
	public String getTexte() {
		return this.texteTapper;
	}
	
	
	@Override
	public int[] getSelection() {
		return this.sel;
	}

	public boolean prompt() {
		System.out.print("$>");
		String line = sc.nextLine();
		
		return commandes(line);
	}
	
	private boolean commandes(String cmd){
		Scanner sc2 = new Scanner(cmd);
		
		if (!sc2.hasNext()){
			sc2.close();
			return true;
		}
		
		switch(sc2.next()) {
			case "::copy" : 
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						sel[0] = sel1;
						sel[1] = sc2.nextInt();
						eventSelectionner();
					}
				}
				
				eventCopier(); 
			break;
			case "::cut" : 
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						sel[0] = sel1;
						sel[1] = sc2.nextInt();
						eventSelectionner();
					}
				}
				eventCouper(); 
			break;
			case "::paste" :
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						sel[0] = sel1;
						sel[1] = sc2.nextInt();
						eventSelectionner();
					}
				}
				eventColler(); 
			break;
			case "::start" : 
				eventStartMacro(); 
			break;
			case "::stop" : 
				eventStopMacro(); 
			break;
			case "::play" : 
				eventRedoMacro(); 
			break;
			case "::undo" : 
				eventUndo(); 
			break;
			case "::redo" : 
				eventRedo(); 
			break;
			case "::help":
				System.out.println("Liste des commandes: start, stop, play, help, cut, copy, paste, select, undo, redo.");
				break;
			case "::end" : 
				this.sc.close();
				sc2.close(); 
				return false;
			case "::select":
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						sel[0] = sel1;
						sel[1] = sc2.nextInt();
						eventSelectionner();
					}
				}
				break;
			default : 
				eventInsererTexte(cmd);
		}
		
		sc2.close();
		return true;
	}

	public void setCopier(Command copier) {
		this.copier = copier;
	}

	public void setCouper(Command couper) {
		this.couper = couper;
	}

	public void setColler(Command coller) {
		this.coller = coller;
	}

	public void setInsTexte(Command insTexte) {
		this.insTexte = insTexte;
	}

	public void setSelectionner(Command selectionner) {
		this.selectionner = selectionner;
	}
	
	public void setStartMacro(Command startMacro) {
		this.startMacro = startMacro;
	}
	
	public void setStopMacro(Command stopMacro) {
		this.stopMacro = stopMacro;
	}
	
	public void setRedoMacro(Command redoMacro) {
		this.redoMacro = redoMacro;
	}

	public void setUndo(Command undo) {
		this.undo = undo;
	}

	public void setRedo(Command redo) {
		this.redo = redo;
	}

}
