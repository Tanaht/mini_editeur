package receiver;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IHMImpl implements IHM {
	
	private String texteTapper;
	private Command copier, couper, coller, insTexte, selectionner;
	private int[] sel;
	private Scanner sc;
	
	public IHMImpl() {
		this.texteTapper = "";
		this.sc = new Scanner(System.in);
		
		sel = new int[2];
		sel[0] = 0; sel[1] = 0;
		
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
	public void eventInsererTexte() {
		insTexte.execute();
	}
	
	@Override
	public void eventSelectionner() {
		selectionner.execute();
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
			case "::end" : 
				this.sc.close();
				sc2.close(); 
				return false;
			case "::select":
				sel[0] = sc2.nextInt();
				sel[1] = sc2.nextInt();
				this.selectionner.execute();
				break;
			default : 
				this.texteTapper = cmd; 
				eventInsererTexte();
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
}
