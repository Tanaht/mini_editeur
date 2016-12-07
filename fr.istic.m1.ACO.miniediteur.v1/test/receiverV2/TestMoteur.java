package receiverV2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMoteur {

	@Test
	public void testCopierVide() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.copier();
		assertEquals(0, m.getClipboard().length());
	}
	
	
	@Test
	public void testCopierNormal() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[] {0, 2});
		m.copier();
		assertTrue(m.getClipboard().equals("01"));
	}
	
	@Test
	public void testCouper() {
		Moteur m = new Moteur();
		m.insTexte("0123");
		m.selectionner(new int[] {0,1});
		m.couper();
		assertEquals("123", m.getBuffer());
		m.selectionner(new int[] {3,3});
		m.coller();
		assertEquals("1230", m.getBuffer());
	}
	
	@Test
	public void testColler() {
		Moteur m = new Moteur();
		m.insTexte("0123");
		m.selectionner(new int[] {0,1});
		m.copier();
		assertEquals("0123", m.getBuffer());
		m.selectionner(new int[] {4,4});
		m.coller();
		assertEquals("01230", m.getBuffer());
	}
	
	@Test
	public void testInsTexte() {
		String txt = "Success";
		
		Moteur m = new Moteur();
		m.insTexte(txt);
		assertTrue(m.getBuffer().equals(txt));
	}
	
	@Test
	public void testselectionner() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{1,3});
		assertArrayEquals(new int[]{1,3} , m.getSelection());
		
	}
	
	@Test
	public void testselectionner2() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{0,10});
		m.couper();
		assertTrue(m.getBuffer().equals(""));
	}
	
	@Test
	public void testselectionnerDebordement() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{-5,5});
		assertTrue(m.getSelection()[0] == 10 && m.getSelection()[1] == 10 );
		
	}
	
	@Test
	public void testselectionnerDebordement2() {
		Moteur m = new Moteur();
		m.insTexte("0123456789");
		m.selectionner(new int[]{5,2});
		assertTrue(m.getSelection()[0] == 10 && m.getSelection()[1] == 10 );
	}
}
