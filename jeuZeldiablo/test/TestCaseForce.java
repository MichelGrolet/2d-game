package test;

import application.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.*;

/**
* Classe de test de CaseForce
*/
public class CaseForce{
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
        assertTrue("Devrait etre non active",res3);
    }
}