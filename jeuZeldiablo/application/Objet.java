package application;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * classe qui représente un objet
 */
public abstract class Objet {
	
	/**
	 * coordonnes de l'objet
	 */
    protected int x, y;
    
    /**
     * personnage qui a l'objet
     */
    protected Personnage p;

    /**
     * construit les objets
     * @param x, abscisse
     * @param y, ordonnee
     */
    public Objet(int x, int y) {
        this.x = x;
        this.y = y;
        this.p = null;
    }
    
    /**
     * retourne l'abscisse
     * @return l'abscisse du personnage
     */
    public int getX() {
        return x;
    }
    
    /**
    * retourne l'ordonnee
    * @return l'ordonnee du personnage
    */
    public int getY() {
        return y;
    }

    /**
     * permet de set le personnage
     * @param p, le personnage voulu
     */
    public void setPersonnage(Personnage p) {
        this.p = p;
    }

    public abstract void dessiner(Graphics2D g);
    
    public abstract void dessinerInventaire(Graphics2D g,int x);
}
