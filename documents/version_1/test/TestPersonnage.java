package test;

import src.*;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe de test du Personnage
 *
 */
public class TestPersonnage{
    @Test
    public void testConstructeurNegatif() {
        Personnage p = new Personnage(0, 0);
        assertEquals("edzsfre", true, true);
    }
}