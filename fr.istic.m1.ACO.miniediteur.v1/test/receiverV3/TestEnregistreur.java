package receiverV3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnregistreur {
	private Enregistreur enregistreur;
	private IHM ihm;
	private Command copier, coller, couper, insTexte, selectionner, startMacro, stopMacro, redoMacro, undo, redo;
	private Receiver moteur;
	
	public TestEnregistreur() {
		this.enregistreur = new Enregistreur();
		this.moteur = new Moteur();
		this.ihm = new IHMImpl();
		CaretakerMoteur caretaker = new CaretakerMoteur(moteur);
		
		this.copier = new Copier(moteur, this.enregistreur, caretaker);
		this.coller = new Coller(moteur, this.enregistreur, caretaker);
		this.couper = new Couper(moteur, this.enregistreur, caretaker);
		this.insTexte = new InsTexte(moteur, this.enregistreur, ihm, caretaker);
		this.selectionner = new Selectionner(moteur, this.enregistreur, ihm, caretaker);
		this.startMacro = new StartMacro(this.enregistreur);
		this.stopMacro = new StopMacro(this.enregistreur);
		this.redoMacro = new RedoMacro(this.enregistreur, caretaker);
		
		this.undo = new Undo(caretaker, this.enregistreur);
		this.redo = new Redo(caretaker, this.enregistreur);
		
		ihm.setColler(coller);
		ihm.setCopier(copier);
		ihm.setCouper(couper);
		ihm.setInsTexte(insTexte);
		ihm.setSelectionner(selectionner);
		ihm.setStartMacro(startMacro);
		ihm.setStopMacro(stopMacro);
		ihm.setRedoMacro(redoMacro);
		ihm.setUndo(undo);
		ihm.setRedo(redo);
	}
	
	@Test
	public void testInitialisation() {
		assertEquals(0, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		
	}
	
	@Test
	public void testEnableRecording() {
		assertFalse(this.enregistreur.isRecording());
		this.enregistreur.enableRecording();
		assertTrue(this.enregistreur.isRecording());
		this.testAlwaysTrue();	
	}
	
	
	@Test
	public void testDisableRecording() {
		this.enregistreur.enableRecording();
		assertTrue(this.enregistreur.isRecording());
		this.enregistreur.disableRecording();
		assertFalse(this.enregistreur.isRecording());
		this.testAlwaysTrue();	
	}
	
	@Test
	public void testStartMacro() {
		assertFalse(this.enregistreur.isRecording());
		this.startMacro.execute();
		assertTrue(this.enregistreur.isRecording());
		this.testAlwaysTrue();	
	}
	
	
	/**
	 * Verifie que deux commandes startMacro successive ne désactive pas l'enregistreur
	 */
	@Test
	public void testStartMacro2() {
		assertFalse(this.enregistreur.isRecording());
		this.startMacro.execute();
		assertTrue(this.enregistreur.isRecording());
		this.startMacro.execute();
		assertTrue(this.enregistreur.isRecording());
		this.testAlwaysTrue();	
	}
	
	@Test
	public void testStopMacro() {
		this.enregistreur.enableRecording();
		assertTrue(this.enregistreur.isRecording());
		this.stopMacro.execute();
		assertFalse(this.enregistreur.isRecording());
		this.testAlwaysTrue();	
	}
	
	/**
	 * Verifie que deux commandes stopMacro successive ne réactive pas l'enregistreur
	 */
	@Test
	public void testStopMacro2() {
		this.enregistreur.enableRecording();
		assertTrue(this.enregistreur.isRecording());
		this.stopMacro.execute();
		assertFalse(this.enregistreur.isRecording());
		this.stopMacro.execute();
		assertFalse(this.enregistreur.isRecording());
		this.testAlwaysTrue();	
	}
	
	@Test
	public void testEmptyMacro() {
		assertTrue(this.enregistreur.isEmpty());
	}
	
	@Test
	public void testRecordMacro() {
		this.startMacro.execute();
		this.testAlwaysTrue();
		this.ihm.eventInsererTexte("toto");
		assertEquals(1, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.stopMacro.execute();
	}
	
	@Test
	public void testRecordMultipleMacro() {
		this.startMacro.execute();
		this.testAlwaysTrue();
		this.ihm.eventInsererTexte("toto");
		assertEquals(1, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.ihm.eventSelectionner(new int[] {0, 4});
		assertEquals(2, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.copier.execute();
		assertEquals(3, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.ihm.eventSelectionner(new int[] {4, 4});
		assertEquals(4, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.coller.execute();;
		assertEquals(5, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.stopMacro.execute();
	}
	
	
	@Test
	public void testPlayMacro() {
		this.startMacro.execute();
		this.testAlwaysTrue();
		this.ihm.eventInsererTexte("toto");
		assertEquals(1, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.stopMacro.execute();
		
		this.redoMacro.execute();
		assertEquals("totototo", this.moteur.getBuffer());
	}
	
	@Test
	public void testEffacerMacro() {
		this.startMacro.execute();
		this.testAlwaysTrue();
		this.ihm.eventInsererTexte("toto");
		assertEquals(1, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		this.stopMacro.execute();
		
		this.enregistreur.effacerMacro();
		assertEquals(0, this.enregistreur.getCommandes().size());
	}
	
	
	@Test
	public void testUndoRedoInMacro() {
		this.startMacro.execute();
		this.ihm.eventInsererTexte("toto");
		this.stopMacro.execute();
		
		assertEquals("toto", this.moteur.getBuffer());
		this.ihm.eventInsererTexte(" ");
		
		this.redoMacro.execute();
		
		assertEquals("toto toto", this.moteur.getBuffer());
		
		this.undo.execute();
		
		assertEquals("toto ", this.moteur.getBuffer());
		
		this.redo.execute();
		assertEquals("toto toto", this.moteur.getBuffer());
	}
	
	/**
	 * Un test qui doit toujours être vrai
	 */
	@Test
	public void testAlwaysTrue() {
		assertEquals(this.enregistreur.getCommandes().size(), this.enregistreur.getMementos().size());
	}
	
	
}
