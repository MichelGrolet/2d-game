package test;

import application.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class TestJeuPerso {
	
	@Test
	public void testGenererMonstre() throws FileNotFoundException, ClassNotFoundException, IOException {
		JeuPerso j = new JeuPerso(0);
		j.genererMonstres(1);
		assertNotNull("le jeu devrait contenir un monstre",j.getMonstres().get(0));
	}
	
	@Test
	public void testGenererMonstreNegatif() throws FileNotFoundException, ClassNotFoundException, IOException {
		JeuPerso j = new JeuPerso(0);
		System.out.println(j.getCasesLibres().size());
		j.genererMonstres(-1);
		assertNotNull("le jeu devrait contenir 0 monstres",j.getMonstres().get(0));
	}
	
	
	@Test
	public void faireApparaitreBon() throws FileNotFoundException, ClassNotFoundException, IOException {
		JeuPerso j = new JeuPerso(0);
		Orc m = new Orc(2,1);
		boolean res = j.faireApparaitre(m);
		
		assertTrue("la methode aurait du fonctionne",res);
		assertEquals("l orc devrai etre en x = 2", 2,j.getMonstres().get(5).getX());
		assertEquals("l orc devrai etre en y = 1", 1,j.getMonstres().get(5).getY());
	}
}
