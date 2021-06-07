package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestLabyrinthe {
	@Test
	public void testConstructerVide() {
		Labyrinthe la = new Labyrinthe();
		Sol s = new Sol(0, 0);
 		assertEquals("devrait contenir 10 sol", s, la.getCase(0,0));;
	}
}
