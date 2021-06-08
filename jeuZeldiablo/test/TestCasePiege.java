package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

/**
* Classe de test de CasePiege
*/
public class TestCasePiege{
    /**
    * Test si le constructeur fonctionne
    */
    @Test
    public void testConstructeur(){
        CasePiege caseP=new CasePiege(2,5);

        int res1=caseP.getX();
        int res2=caseP.getY();
        boolean res3=caseP.getActive();

        assertEquals("Le x de caseP devrait etre 2",2,res1);
        assertEquals("Le y de caseP devrait etre 5",5,res2);
        assertFalse("Devrait etre non active",res3);
    }

    /**
    * Test si declencherEffet change active
    */
    @Test
    public void testDeclencher(){
        CasePiege caseP=new CasePiege(2,5);
        Personnage j=new Personnage(2,5);

        caseP.declencherEffet(j);

        boolean res=caseP.getActive();

        assertTrue("Devrait etre activee",res);
    }

    /**
    * Test si le joueur subit des degats en activant le piege
    */
    @Test
    public void testSubirDegats(){
        CasePiege caseP=new CasePiege(2,5);
        Personnage j=new Personnage(2,5);

        caseP.declencherEffet(j);

        int res=j.getPv();

        assertEquals("Le joueur doit avoir 6 pv",6,res);
    }
}