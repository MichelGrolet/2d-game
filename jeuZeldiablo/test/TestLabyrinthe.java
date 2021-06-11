package test;

import application.*;
import labyrinthe.Labyrinthe;
import labyrinthe.Sol;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	*/
	@Test
	public void testGenererContour() throws FileNotFoundException, ClassNotFoundException, IOException{
		Labyrinthe l1=new Labyrinthe();


		l1.genererMur();
		
		boolean res1=true;

		for(int i=0;i<Labyrinthe.TAILLE;i++){
			if(l1.getCase(i,0) instanceof Sol){
				res1=false;
			}
			if(!res1){
				break;
			}
		}

		if(res1){
			for(int j=0;j<Labyrinthe.TAILLE;j++){
				if(l1.getCase(0,j) instanceof Sol){
					res1=false;
				}
				if(!res1){
					break;
				}
			}
		}

		if(res1){
			for(int j=0;j<Labyrinthe.TAILLE;j++){
				if(l1.getCase(Labyrinthe.TAILLE-1,j) instanceof Sol){
					res1=false;
				}
				if(!res1){
					break;
				}
			}
		}

		if(res1){
			for(int i=0;i<Labyrinthe.TAILLE;i++){
				if(l1.getCase(i,Labyrinthe.TAILLE-1) instanceof Sol){
					res1=false;
				}
				if(!res1){
					break;
				}
			}
		}

		assertTrue("Le pattern 1 n'est pas bon",res1);
	}

	/**
	* Test d'un mauvais parametre
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	*/
	@Test
	public void testMauvaisParam() throws FileNotFoundException, ClassNotFoundException, IOException{
		Labyrinthe l=new Labyrinthe();
		boolean res=true;

		l.genererMur();

		for(int i=0;i<Labyrinthe.TAILLE;i++){
			if(l.getCase(i,0) instanceof Sol){
				res=false;
			}
		}

		assertTrue("Il devrait y avoir des murs",res);
	}
}
