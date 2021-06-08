package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

/**
* Classe de test de CaseForce
*/
public class TestCaseForce{
    /**
    * Test si le constructeur fonctionne
    */
    @Test
    public void testConstructeur(){
        CaseForce caseF=new CaseForce(2,5);

        int res1=caseF.getX();
        int res2=caseF.getY();
        boolean res3=caseF.getActive();

        assertEquals("Le x de caseF devrait etre 2",2,res1);
        assertEquals("Le y de caseF devrait etre 5",5,res2);
        assertFalse("Devrait etre non active",res3);
    }

    /**
    * Test si declencherEffet change active
    */
    @Test
    public void testDeclencher(){
        CaseForce caseF=new CaseForce(2,5);
        Personnage j=new Personnage(2,5);

        caseF.declencherEffet(j);

        boolean res=caseF.getActive();

        assertTrue("Devrait etre activee",res);
    }

    /**
    * Test si le joueur subit des degats en activant le piege
    */
    @Test
    public void testGagnerPuissance(){
        CaseForce caseF=new CaseForce(2,5);
        Personnage j=new Personnage(2,5);

        caseF.declencherEffet(j);

        int res=j.getPuissance();

        assertEquals("Le joueur doit avoir 3 de puissance",3,res);
    }
}