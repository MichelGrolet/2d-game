package test;

import application.*;
import labyrinthe.Sol;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

/**
* Classe de test de Sol
*/

public class TestSol{
    /**
    * Test si le constructeur fonctionne
    */
    @Test
    public void testConstructeur(){
        Sol sol=new Sol(2,5);

        int res1=sol.getX();
        int res2=sol.getY();
        boolean res3=sol.getLibre();

        assertEquals("Le x de sol devrait etre 2",2,res1);
        assertEquals("Le y de sol devrait etre 5",5,res2);
        assertTrue("Devrait etre libre",res3);
    }

    /**
    * Test si les getters fonctionnent
    */
    @Test
    public void testGetter(){
        Sol sol=new Sol(2,3);

        int res1=sol.getX();
        int res2=sol.getY();

        assertEquals("Le x de sol devrait etre 2",2,res1);
        assertEquals("Le y de sol devrait etre 3",3,res2);
    }

    /**
    * Test si le constructeur fonctionne avec des parametres negatifs
    */
    @Test
    public void testConstructeurNegatif(){
        Sol sol1=new Sol(-2,5);
        Sol sol2=new Sol(2,-5);

        int res1=sol1.getX();
        int res2=sol2.getY();

        assertEquals("Le x de sol1 devrait etre 0",0,res1);
        assertEquals("Le y de sol2 devrait etre 0",0,res2);
    }
}