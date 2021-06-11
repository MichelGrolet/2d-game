package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * classe qui represent une amulette
 */
public class Amulette extends Objet {
	
	/**
	 * creer une amulette
	 * @param x, coordonne en x
	 * @param y, coordonne en y 
	 */
    public Amulette(int x, int y) {
        super(x, y);
    }

    /**
     * permet de dessiner l'amulette sur le terrain
     * @param g, ou on dessine
     */
    public void dessiner(Graphics2D g) {
    	try {
    		//on recupere l'image dans les fichiers
    		BufferedImage im = ImageIO.read(new File("./sprites/amulet.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}
    
    /**
     * peremt de dessiner l'amulette dans l'inventaire
     * @param g, ou on dessine
     */
    public void dessinerInventaire(Graphics2D g,int x) {
    	try {
    		int position = 0;
        	switch(x) {
	        	case 0 : position = Personnage.CASE_INVENTAIRE1;break;
	        	case 1 : position = Personnage.CASE_INVENTAIRE2;break;
	        	case 2 : position = Personnage.CASE_INVENTAIRE3;break;
	        	default : break;
	        }
        	//on recupere l'image dans les fichiers
    		BufferedImage im = ImageIO.read(new File("./sprites/amulet.png"));
    		g.drawImage(im,position, Labyrinthe.TAILLE+6*(DessinPerso.TAILLE_CASE),null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
    }
}
