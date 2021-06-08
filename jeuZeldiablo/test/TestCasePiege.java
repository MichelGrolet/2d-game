package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

/**
* Classe de test de CasePiege
*/
public class CasePiege{
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
        assertTrue("Devrait etre non active",res3);
    }
}