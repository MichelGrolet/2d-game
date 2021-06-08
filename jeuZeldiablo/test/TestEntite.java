package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestEntite {
	
	@Test
	public void subirDegats() {
		Entite e = new Entite(0,0);
		e.subirDegats();
		assertEquals("devrait etre 9",9, e.getPv());
	}
	
	@Test
	public void testAttaquerBonneDistance() {
		Entite e1 = new Entite(0,0);
		Entite e2 = new Entite(1,0);
		e1.attaquer(e2);
		assertEquals("devrait etre 9",9, e2.getPv());
	}
	
	@Test
	public void testAttaquerTropLoin() {
		Entite e1 = new Entite(0,0);
		Entite e2 = new Entite(2,0);
		e1.attaquer(e2);
		assertEquals("devrait etre 9",10, e2.getPv());
	}
}