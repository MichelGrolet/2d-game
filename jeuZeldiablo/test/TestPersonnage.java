package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe de test du Personnage
 *
 */
public class TestPersonnage{
    @Test
    public void testConstructeurNegatif() {
        Personnage p = new Personnage(0,0);
        assertTrue("edzsfre", true);
    }
    
    @Test
	public void testSubirDegats() {
		Entite e = new Personnage(0,0);
		e.subirDegats(1);
		assertEquals("devrait etre 9",9, e.getPv());
	}
	
	@Test
	public void testAttaquerBonneDistance() {
		Entite e1 = new Personnage(0,0);
		Entite e2 = new Monstre(1,0);
		e1.attaquer(e2);
		assertEquals("devrait etre 8",8, e2.getPv());
	}
	
	@Test
	public void testAttaquerTropLoin() {
		Entite e1 = new Personnage(0,0);
		Entite e2 = new Monstre(2,0);
		e1.attaquer(e2);
		assertEquals("devrait etre 10",10, e2.getPv());
		e2.attaquer(e1);
		assertEquals("devrait etre 10",10, e1.getPv());
		Entite e3 = new Monstre(10,1);
		e3.attaquer(e1);
		assertEquals("devrait etre 10",10, e1.getPv());
	}
}