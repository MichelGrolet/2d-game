package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.*;

public class TestAmulette {
	@Test
	public void constructeur() {
		Amulette a = new Amulette(0,0);
		assertEquals("devrait avoir x=0", 0, a.getX());
		assertEquals("devrait avoir y=0", 0, a.getY());
		assertEquals("devrait avoir aucun perso", null, a.getPersonnage());
	}
}
