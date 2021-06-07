package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

/**
* Classe de test de Mur
*/

public class TestMur{
    /**
    * Test si le constructeur fonctionne
    */
    @Test
    public void testConstructeur(){
        Mur mur=new Mur(2,5);

        int res1=mur.getX();
        int res2=mur.getY();

        assertEquals("Le x de mur devrait etre 2",2,res1);
        assertEquals("Le y de mur devrait etre 5",5,res2);
    }

    /**
    * Test si les getters fonctionnent
    */
    @Test
    public void testGetter(){
        Mur mur=new Mur(2,3);

        int res1=mur.getX();
        int res2=mur.getY();

        assertEquals("Le x de mur devrait etre 2",2,res1);
        assertEquals("Le y de mur devrait etre 3",3,res2);
    }

    /**
    * Test si le constructeur fonctionne avec des parametres negatifs
    */
    @Test
    public void testConstructeurNegatif(){
        Mur mur1=new Mur(-2,5);
        Mur mur2=new Mur(2,-5);

        int res1=mur1.getX();
        int res2=mur2.getY();

        assertEquals("Le x de mur1 devrait etre 0",0,res1);
        assertEquals("Le y de mur2 devrait etre 0",0,res2);
    }
}