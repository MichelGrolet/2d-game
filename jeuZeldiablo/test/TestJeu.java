package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestJeu {
	
	@Test
	public void testGenererMonstre() {
		JeuPerso j = new JeuPerso(0);
		j.genererMonstres(1);
		assertNotNull("le jeu devrait contenir un monstre",j.getMonstres().get(0));
	}
	
	@Test
	public void testGenererMonstreNegatif() {
		JeuPerso j = new JeuPerso(0);
		System.out.println(j.getCasesLibres().size());
		j.genererMonstres(2);
		j.genererMonstres(-1);
		assertNotNull("le jeu devrait contenir 2 monstres",j.getMonstres().get(1));
	}
	
	@Test
	public void testGenererMonstrePlusDePlaces() {
		JeuPerso j = new JeuPerso(0);
		j.genererMonstres(100);
		assertEquals("le jeu devrait contenir 68 monstres correpsondant aux cases libres",j.getMonstres().size(),68);
	}
	
	@Test
	public void faireApparaitreBon() {
		JeuPerso j = new JeuPerso(0);
		Orc m = new Orc(2,1);
		boolean res = j.faireApparaitre(m);
		
		assertTrue("la methode aurait du fonctionne",res);
		assertEquals("l orc devrai etre en x = 2", 2,j.getCasesEntites().get(0).getX());
		assertEquals("l orc devrai etre en y = 1", 2,j.getCasesEntites().get(0).getY());

	}
}
