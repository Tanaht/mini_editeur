package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMoteur {

	@Test
	public void testCopier() {
		Moteur m = new Moteur();
		m.copier();
		//chaine vide est bien vide
		fail("Not yet implemented");
	}
	
	@Test
	public void testCouper() {
		Moteur m = new Moteur();
		m.couper();
		fail("Not yet implemented");
	}
	
	@Test
	public void testColler() {
		Moteur m = new Moteur();
		m.coller();
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsTexte() {
		String txt = "Success";
		
		Moteur m = new Moteur();
		m.insTexte(txt);
		
		assertTrue(txt.length() == m.getBuffer().length());
	}
	
	@Test
	public void testselectionner() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{1,3});
		assertArrayEquals(new int[]{1,3} , m.getSelection());
		
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testselectionnerDebordement() throws ArrayIndexOutOfBoundsException {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{1,10});
		//assertArrayEquals(expecteds, actuals);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testselectionnerDebordement2() throws ArrayIndexOutOfBoundsException {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{-5,5});
		
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testselectionnerDebordement3() throws ArrayIndexOutOfBoundsException {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{5,2});
		
	}
}
