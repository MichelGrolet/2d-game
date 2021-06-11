package test;

import application.*;
import labyrinthe.Case;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

/**
* Classe de test de Case
*/

public class TestCase{
    /**
    * Test si le constructeur fonctionne
    */
    @Test
    public void testConstructeur(){
        Case caseT=new Case(2,5);

        int res1=caseT.getX();
        int res2=caseT.getY();

        assertEquals("Le x de caseT devrait etre 2",2,res1);
        assertEquals("Le y de caseT devrait etre 5",5,res2);
    }

    /**
    * Test si les getters fonctionnent
    */
    @Test
    public void testGetter(){
        Case caseT=new Case(2,3);

        int res1=caseT.getX();
        int res2=caseT.getY();
        boolean res3=caseT.getLibre();

        assertEquals("Le x de caseT devrait etre 2",2,res1);
        assertEquals("Le y de caseT devrait etre 3",3,res2);
        assertTrue("Devrait etre libre",res3);
    }

    /**
    * Test si le constructeur fonctionne avec des parametres negatifs
    */
    @Test
    public void testConstructeurNegatif(){
        Case case1=new Case(-2,5);
        Case case2=new Case(2,-5);

        int res1=case1.getX();
        int res2=case2.getY();

        assertEquals("Le x de case1 devrait etre 0",0,res1);
        assertEquals("Le y de case2 devrait etre 0",0,res2);
    }
}