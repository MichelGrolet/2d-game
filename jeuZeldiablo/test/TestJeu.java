package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestJeu {
	
	@Test
	public void testConstructerVide() {
		Labyrinthe la = new Labyrinthe();
		Case[][] c = new Case[10][10];
		for(int i  =0; i<10; i++) {
			for(int j=0; j<10; j++) {
				c[i][j] = new Sol(i, j);
			}
		}
 		assertEquals("devrait un tableau de case", c, la.getTabCase());
	}
}
