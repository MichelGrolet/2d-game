package test;

import application.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestLabyrinthe {
	@Test
	public void testConstructerVide() {
		Labyrinthe la = new Labyrinthe();
 		assertFalse(la.getTabCase().equals(null));
	}
}
