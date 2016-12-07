package receiverV2;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestSelection {
	@Test
	public void testInitialisation() {
		Selection selection = new Selection();
		
		assertEquals(0, selection.getStartSelection());
		assertEquals(0, selection.getEndSelection());
	}
	
	@Test
	public void testForward() {
		Selection selection = new Selection();
		
		selection.moveForward(5);
		assertEquals(5, selection.getStartSelection());
		assertEquals(5, selection.getEndSelection());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalForward() {
		Selection selection = new Selection();
		
		selection.moveForward(-5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalForward2() {
		Selection selection = new Selection();
		
		selection.moveForward(0);
	}
	
	
	@Test
	public void testReset() {
		Selection selection = new Selection();
		
		selection.resetSelection(20);
		assertEquals(20, selection.getStartSelection());
		assertEquals(20, selection.getEndSelection());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalReset() {
		Selection selection = new Selection();
		
		selection.resetSelection(-20);
	}
	
	
	@Test
	public void testBackward() {
		Selection selection = new Selection();
		selection.resetSelection(10);
		
		selection.moveBackward(5);
		assertEquals(5, selection.getStartSelection());
		assertEquals(5, selection.getEndSelection());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalBackward() {
		Selection selection = new Selection();
		selection.resetSelection(10);
		
		selection.moveBackward(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalBackward2() {
		Selection selection = new Selection();
		selection.resetSelection(10);
		
		selection.moveBackward(-5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalBackward3() {
		Selection selection = new Selection();
		selection.resetSelection(10);
		
		selection.moveBackward(11);
	}
	
	@Test
	public void testHasTextSelectedFalse() {
		Selection selection = new Selection();
		assertFalse(selection.hasTextSelected());
	}
	
	@Test
	public void testSetSelection() {
		Selection selection = new Selection();
		selection.setSelection(0, 5);
		assertEquals(0, selection.getStartSelection());
		assertEquals(5, selection.getEndSelection());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadSetSelection() {
		Selection selection = new Selection();
		selection.setSelection(-1, 5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadSetSelection2() {
		Selection selection = new Selection();
		selection.setSelection(-1, -5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadSetSelection3() {
		Selection selection = new Selection();
		selection.setSelection(5, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadSetSelection4() {
		Selection selection = new Selection();
		selection.setSelection(5, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadSetSelection5() {
		Selection selection = new Selection();
		selection.setSelection(-5, -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBadSetSelection6() {
		Selection selection = new Selection();
		selection.setSelection(-5, 1);
	}
	
	@Test
	public void testHasTextSelectedTrue() {
		Selection selection = new Selection();
		selection.setSelection(0, 5);
		
		assertTrue(selection.hasTextSelected());
	}
	
	@Test
	public void testGetSelectedText() {
		String buffer = "Hello World !!!";
		Selection selection = new Selection();
		selection.setSelection(0, "Hello".length());
		
		assertEquals("Hello", selection.getSelectedText(buffer));
	}
	
	@Test
	public void testGetSelectedText2() {
		String buffer = "Hello World !!!";
		Selection selection = new Selection();
		selection.setSelection("Hello ".length(), "Hello World".length());
		
		assertEquals("World", selection.getSelectedText(buffer));
	}
	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testBadGetSelectedText() {
		String buffer = "Hello";
		Selection selection = new Selection();
		selection.setSelection(0, "Hello World".length());
		
		selection.getSelectedText(buffer);
	}
	
	
}
