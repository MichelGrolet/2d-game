package labyrinthe;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import entite.*;
import application.*;
import objet.*;

/**
* Classe representant un mur
* herite de Case
*/
public class Mur extends Case{
    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Mur(int x,int y){
        super(x,y);
        
        //Instancie a non libre
        this.libre=false;
    }
    
    /**
     * permet de dessiner le mur
     * @param g, ou on dessine
     */
    public void dessiner(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/wall.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
    }
}