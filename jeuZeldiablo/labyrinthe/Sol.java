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
* Classe representant du sol
* herite de Case
*/
public class Sol extends Case{
    protected boolean active;

    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Sol(int x,int y){
        super(x,y);
        
        //Instancie a libre
        this.libre=true;

        //Instancie a non activable
        this.active=false;
    }

    /**
    * Permet de declencher l'effet et passe la case en inactivable
    * @param joueur le joueur qui subit l'effet
    */   
    public void declencherEffet(Personnage joueur){
        //Aucun effet
    }

    /**
    * Retourne si la case est activable ou non
    * @return un booleen
    */
    public boolean getActive(){
        return this.active;
    }

    /**
    * Dessine la case
    * @param g Graphics2D
    */
    public void dessiner(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/floor.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}
}