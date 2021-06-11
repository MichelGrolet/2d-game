package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import application.*;

public class TestMonstre {
    @Test
    public void testSeDeplacerBon() throws FileNotFoundException, ClassNotFoundException, IOException {
    	JeuPerso j = new JeuPerso(0);
    	Monstre m = new Monstre(2,0);
    	j.faireApparaitre(m);

    	m.seDeplacer(j.getCasesLibres(), j.getPersonnage());
    	assertEquals("le monstre devrait etre en x : 1", 1,m.getX());
    	assertEquals("le monstre devrait etre en y : 0", 0,m.getY());
    }
}
