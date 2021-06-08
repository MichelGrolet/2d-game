package test;

import application.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestLabyrinthe {
	/**
	* Test du constructeur
	*/
	@Test
	public void testConstructerVide() {
		Labyrinthe la = new Labyrinthe();
 		assertFalse(la.getTabCase().equals(null));
	}

	/**
	* Test les differents pattern de labyrinthe
	*/
	@Test
	public void testGenererContour(){
		Labyrinthe l1=new Labyrinthe();
		Labyrinthe l2=new Labyrinthe();
		Labyrinthe l3=new Labyrinthe();

		l1.genererMur(0);
		l1.genererMur(1);
		l1.genererMur(2);

		boolean res1=true;
		boolean res2=true;
		boolean res3=true;

		for(int i=0;i<Labyrinthe.TAILLE;i++){
			if(l1.getCase(i,0) instanceof Sol){
				res1=false;
			}
			if(l2.getCase(i,0) instanceof Sol){
				res2=false;
			}
			if(l3.getCase(i,0) instanceof Sol){
				res3=false;
			}
			if(!res1 && !res2 && !res3){
				break;
			}
		}

		if(res1 || res2 || res3){
			for(int j=0;j<Labyrinthe.TAILLE;j++){
				if(l1.getCase(0,j) instanceof Sol){
					res1=false;
				}
				if(l2.getCase(0,j) instanceof Sol){
					res2=false;
				}
				if(l3.getCase(0,j) instanceof Sol){
					res3=false;
				}
				if(!res1 && !res2 && !res3){
					break;
				}
			}
		}

		if(res1 || res2 || res3){
			for(int j=0;j<Labyrinthe.TAILLE;j++){
				if(l1.getCase(Labyrinthe.TAILLE-1,j) instanceof Sol){
					res1=false;
				}
				if(l2.getCase(Labyrinthe.TAILLE-1,j) instanceof Sol){
					res2=false;
				}
				if(l3.getCase(Labyrinthe.TAILLE-1,j) instanceof Sol){
					res3=false;
				}
				if(!res1 && !res2 && !res3){
					break;
				}
			}
		}

		if(res1 || res2 || res3){
			for(int i=0;i<Labyrinthe.TAILLE;i++){
				if(l1.getCase(i,Labyrinthe.TAILLE-1) instanceof Sol){
					res1=false;
				}
				if(l2.getCase(i,Labyrinthe.TAILLE-1) instanceof Sol){
					res2=false;
				}
				if(l3.getCase(i,Labyrinthe.TAILLE-1) instanceof Sol){
					res3=false;
				}
				if(!res1 && !res2 && !res3){
					break;
				}
			}
		}

		assertTrue("Le pattern 1 n'est pas bon",res1);
		assertTrue("Le pattern 2 n'est pas bon",res2);
		assertTrue("Le pattern 3 n'est pas bon",res3);
	}

	/**
	* Test d'un mauvais parametre
	*/
	@Test
	public void testMauvaisParam(){
		Labyrinthe l=new Labyrinthe();
		boolean res=true;

		l.genererMur(5);

		for(int i=0;i<Labyrinthe.TAILLE;i++){
			if(l.getCase(i,0) instanceof Sol){
				res=false;
			}
		}

		assertTrue("Il devrait y avoir des murs",res);
	}
}
