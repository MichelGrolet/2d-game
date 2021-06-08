package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestJeu {
	
	@Test
	public void testGenererMonstre() {
		JeuPerso j = new JeuPerso();
		j.genererMonstres(1);
		assertNotNull("le jeu devrait contenir un monstre",j.getMonstres().get(0));
	}
	
	@Test
	public void testGenererMonstreNegatif() {
		JeuPerso j = new JeuPerso();
		j.genererMonstres(2);
		j.genererMonstres(-1);
		assertNotNull("le jeu devrait contenir 2 monstres",j.getMonstres().get(1));
	}
}
