package receiverV2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnregistreur {
	private Enregistreur enregistreur;
	
	public TestEnregistreur() {
		this.enregistreur = new Enregistreur();
	}
	
	@Test
	public void testInitialisation() {
		assertEquals(0, this.enregistreur.getCommandes().size());
		this.testAlwaysTrue();
		
	}
	
	@Test
	public void testAlwaysTrue() {
		assertEquals(this.enregistreur.getCommandes().size(), this.enregistreur.getMementos().size());
	}
}
