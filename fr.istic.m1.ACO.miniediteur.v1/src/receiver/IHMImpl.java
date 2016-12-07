package receiver;

import java.util.Scanner;

/**
 * Une implémentation de l'IHM pour le mini éditeur
 * @author Antoine
 *
 */
public class IHMImpl implements IHM {
	
	/**
	 * Permet d'enregistrer le texte entrée par l'utilisateur pour les besoins de la commande InsTexte
	 */
	private String texteTapper;
	
	/**
	 * Les différentes commandes qui vont agir sur le moteur.
	 */
	private Command copier, couper, coller, insTexte, selectionner;
	
	/**
	 * Permet d'enregistrer la selection entrée par l'utilisateur pour les besoins de la commande Selectionner
	 */
	private int[] sel;
	
	/**
	 * Le scanner pour lire les entrées utilisateurs
	 */
	private Scanner sc;
	
	/**
	 * Constructeur de l'IHM
	 */
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
	public void eventInsererTexte(String texte) {
		this.texteTapper = texte;
		insTexte.execute();
	}
	
	@Override
	public void eventSelectionner(int[] sel) {
		this.sel = sel;
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

	/**
	 * Permet de demandé une action à l'utilisateur
	 * @return un boolean, si faux (en tapant la commande "::exit") le programme s'arrète
	 */
	public boolean prompt() {
		System.out.print("$>");
		String line = sc.nextLine();
		
		return commandes(line);
	}
	
	/**
	 * Effectue un traitement pour reconnaitre la commande entrée par l'utilisateur et agir en conséquence
	 * @param cmd l'action entrée par l'utilisateur
	 * @return
	 */
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
						eventSelectionner(new int[]{ sel1, sc2.nextInt()});
					}
				}
				
				eventCopier(); 
			break;
			case "::cut" : 
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						eventSelectionner(new int[]{ sel1, sc2.nextInt()});
					}
				}
				eventCouper(); 
			break;
			case "::paste" :
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						eventSelectionner(new int[]{ sel1, sc2.nextInt()});
					}
				}
				eventColler(); 
			break;
			case "::end" : 
				this.sc.close();
				sc2.close(); 
				return false;
			case "::select":
				if(sc2.hasNextInt()) {
					int sel1 = sc2.nextInt();
					
					if(sc2.hasNextInt()) {
						eventSelectionner(new int[]{ sel1, sc2.nextInt()});
					}
				}
				break;
			default : 
				eventInsererTexte(cmd);
		}
		
		sc2.close();
		return true;
	}

	@Override
	public void setCopier(Command copier) {
		this.copier = copier;
	}

	@Override
	public void setCouper(Command couper) {
		this.couper = couper;
	}

	@Override
	public void setColler(Command coller) {
		this.coller = coller;
	}

	@Override
	public void setInsTexte(Command insTexte) {
		this.insTexte = insTexte;
	}
	
	@Override
	public void setSelectionner(Command selectionner) {
		this.selectionner = selectionner;
	}
}
