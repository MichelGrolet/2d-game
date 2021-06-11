package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gobelin extends Monstre {

    /**
     * construit un monstre aux coordonnees donnees en parametre
     *
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Gobelin(int x, int y) {
        super(x, y);
        this.vitesse = 2;
        this.pv = 5;
    }
    
    /**
     * permet de dessiner le gobelin dans le jeu
     * @param g, la ou on dessine
     */
    public void dessiner(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/goblin.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
    }
}
