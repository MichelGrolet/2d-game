package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Amulette extends Objet {

    public Amulette(int x, int y) {
        super(x, y);
    }

    public void dessiner(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/amulet.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}
    
    public void dessinerInventaire(Graphics2D g,int x) {
    	try {
    		int position = 0;
        	switch(x) {
        	case 0 : position = Personnage.CASE_INVENTAIRE1;break;
        	case 1 : position = Personnage.CASE_INVENTAIRE2;break;
        	case 2 : position = Personnage.CASE_INVENTAIRE3;break;
        	default : break;
        	}
    		BufferedImage im = ImageIO.read(new File("./sprites/amulet.png"));
    		g.drawImage(im,position, Labyrinthe.TAILLE+6*(DessinPerso.TAILLE_CASE),null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
    }
}
