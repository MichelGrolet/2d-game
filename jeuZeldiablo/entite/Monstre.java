package entite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import labyrinthe.Case;

public class Monstre extends Entite {
	
	/**
	 * représente la vitesse de la deplacement du monstre
	 */
	protected int vitesse;
	
	/**
     * construit un monstre aux coordonnees donnees en parametre
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Monstre(int x, int y) {
        super(x,y);
        this.vitesse = 1;
    }

    /**
     * permet le deplacement du monstre en se rapprochant du personnage
     * @param libres cases libres autour du monstre
     * @param p personnage que le monstre veut attaquer
     */
    public void seDeplacer(ArrayList<Case> libres, Personnage p) {
        int prochainX = this.x;
        int prochainY = this.y;
        double distanceAct = Math.sqrt((p.getX()-this.x)*(p.getX()-this.x) + (p.getY()-this.y)*(p.getY()-this.y));
        for (Case c : libres) {
            double dist = Math.sqrt((p.getX()-c.getX())*(p.getX()-c.getX()) + (p.getY()-c.getY())*(p.getY()-c.getY()));
            if (dist<distanceAct) {
                prochainX = c.getX();
                prochainY = c.getY();
                libres.remove(c);
                break;
            }
        }
        this.x = prochainX;
        this.y = prochainY;
    }
    
    /**
     * retourne la vitesse
     * @return vitesse
     */
    public int getVitesse() {
    	return this.vitesse;
    }

    public void dessiner(Graphics2D g) {}
}
