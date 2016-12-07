package receiverV2;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestIhm {
	private IHM ihm;
	private Receiver moteur;
	
	public TestIhm() {
		Enregistreur enregistreur = new Enregistreur();
		this.moteur = new Moteur();
		this.ihm = new IHMImpl();
		
		Command copier = new Copier(moteur, enregistreur);
		Command coller = new Coller(moteur, enregistreur);
		Command couper = new Couper(moteur, enregistreur);
		Command insTexte = new InsTexte(moteur, enregistreur, ihm);
		Command selectionner = new Selectionner(moteur, enregistreur, ihm);
		Command startMacro = new StartMacro(enregistreur);
		Command stopMacro = new StopMacro(enregistreur);
		Command redoMacro = new RedoMacro(enregistreur);
		
		ihm.setColler(coller);
		ihm.setCopier(copier);
		ihm.setCouper(couper);
		ihm.setInsTexte(insTexte);
		ihm.setSelectionner(selectionner);
		ihm.setStartMacro(startMacro);
		ihm.setStopMacro(stopMacro);
		ihm.setRedoMacro(redoMacro);
	}
	
	@Test
	public void testInsTexteSaveTexte() {
		this.ihm.eventInsererTexte("Hello");
		assertEquals("Hello", this.ihm.getTexte());
	}
	
	@Test
	public void testExecuteInsTexte() {
		this.ihm.eventInsererTexte("Hello");
		assertEquals("Hello", this.ihm.getTexte());
		assertEquals(this.ihm.getTexte(), this.moteur.getBuffer());
	}
	
	@Test
	public void testDeplacerCurseur() {
		this.ihm.eventInsererTexte("Hello");
		assertArrayEquals(new int[]{5, 5}, this.moteur.getSelection());
		this.ihm.eventSelectionner(new int[]{0, 0});
		assertArrayEquals(new int[]{0, 0}, this.moteur.getSelection());
	}
	
	@Test
	public void testSelectionnerOverwrite() {
		this.ihm.eventInsererTexte("Hello");
		assertEquals("Hello", this.moteur.getBuffer());
		assertArrayEquals(new int[]{5, 5}, this.moteur.getSelection());
		this.ihm.eventSelectionner(new int[]{0, 5});
		this.ihm.eventInsererTexte("World");
		assertEquals("World", this.moteur.getBuffer());
	}
	
	@Test
	public void testCouperExecute() {
		this.ihm.eventInsererTexte("Hello");
		this.ihm.eventSelectionner(new int[]{0, 5});
		this.ihm.eventCouper();
		assertEquals("", this.moteur.getBuffer());
	}
	
	@Test
	public void testCollerExecute() {
		this.ihm.eventInsererTexte("Hello");
		this.ihm.eventSelectionner(new int[]{0, 5});
		this.ihm.eventCouper();
		assertEquals("", this.moteur.getBuffer());
		this.ihm.eventColler();
		assertEquals("Hello", this.moteur.getBuffer());
	}
	
	
	@Test
	public void testCopierExecute() {
		this.ihm.eventInsererTexte("Hello");
		this.ihm.eventSelectionner(new int[]{0, 5});
		this.ihm.eventCopier();
		this.ihm.eventSelectionner(new int[]{5, 5});
		this.ihm.eventColler();
		assertEquals("HelloHello", this.moteur.getBuffer());
	}
}
