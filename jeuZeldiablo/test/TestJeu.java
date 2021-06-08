package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestJeu {
	
	@Test
	public void testGenererMonstre() throws InterruptedException {
		JeuPerso j = new JeuPerso();
		j.genererMonstres(1);
		assertNotNull("le jeu devrait contenir un monstre",j.getMonstres().get(0));
	}
	
	@Test
	public void testGenererMonstreNegatif() throws InterruptedException {
		JeuPerso j = new JeuPerso();
		System.out.println(j.getCasesLibres().size());
		j.genererMonstres(2);
		j.genererMonstres(-1);
		assertNotNull("le jeu devrait contenir 2 monstres",j.getMonstres().get(1));
	}
	
	@Test
	public void testGenererMonstrePlusDePlaces() throws InterruptedException {
		JeuPerso j = new JeuPerso();
		j.genererMonstres(110);
		assertEquals("le jeu devrait contenir 100 monstres correpsondant aux cases libres",j.getMonstres().size(),100);
	}
}
