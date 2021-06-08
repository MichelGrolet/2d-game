package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

/**
* Classe de test de CaseSpeciale
*/
public class TestCaseSpeciale{
    /**
    * Test si le constructeur fonctionne
    */
    @Test
    public void testConstructeur(){
        CaseSpeciale caseS=new CaseSpeciale(2,5);

        int res1=caseS.getX();
        int res2=caseS.getY();
        boolean res3=caseS.getActive();

        assertEquals("Le x de caseS devrait etre 2",2,res1);
        assertEquals("Le y de caseS devrait etre 5",5,res2);
        assertFalse("Devrait etre non active",res3);
    }

    /**
    * Test si declencherEffet change active
    */
    @Test
    public void testDeclencher(){
        CaseSpeciale caseS=new CaseSpeciale(2,5);
        Personnage j=new Personnage(2,5);

        caseS.declencherEffet(j);

        boolean res=caseS.getActive();

        assertTrue("Devrait etre activee",res);
    }
}
    