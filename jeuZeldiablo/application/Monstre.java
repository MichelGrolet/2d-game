package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Monstre extends Entite {
    private int x,y;

    /**
     * construit un monstre aux coordonnees donnees en parametre
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Monstre(int x, int y) {
        super(x,y);
    }

    /**
     * permet le deplacement du monstre en se rapprochant du personnage
     * @param libres cases libres autour du monstre
     * @param p personnage que le monstre veut attaquer
     */
    public void seDeplacer(ArrayList<Case> libres, Personnage p) {
        int prochainX = this.x;
        int prochainY = this.y;
        double meilleureDistance = 20;

        for (Case c : libres) {
            double dist = Math.sqrt((p.getX()-this.x)*(p.getX()-this.x) + (p.getY()-this.y)*(p.getY()-this.y));
            if (dist<meilleureDistance) {
                prochainX = c.getX();
                prochainY = c.getY();
                meilleureDistance = dist;
            }
        }

        this.x = prochainX;
        this.y = prochainY;
    }
}
