package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import moteurJeu.moteur.Commande;

/**
 * Classe qui represente un personnage
 *
 */
public class Personnage extends Entite{



   /**
    * Constructeur qui prend des coordonnees x,y en parametres
    * @param x entier pour la coordonnee x
    * @param y entier pour la coordonnee y
    */
    public Personnage(int x, int y){
    	super(x, y);
    	this.puissance = 2;
    }

    public String toString() {
    	return("Le personage est en "+this.getX()+", "+this.getY());
    }

    public void dessiner(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/perso.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}

    /**
     *  permet au personnage de se deplacer
     * @param c, commande jouer par l'ultilisateur
     * @param j, jeu en cours
     */
	public void seDeplacer(Commande c, ArrayList<Case> libres) {
		if (c.gauche)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x-1 && cas.getY() == this.y) {
					this.x--;
					if (this.x < 0) {
						this.x = 0;
					}
					break;
				}
			}
			
		}

		if (c.droite)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x+1 && cas.getY() == this.y) {
					this.x++;
					if (this.x >100) {
						this.x = 100;
					}
					break;
				}
			}
		}

		if (c.haut)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x && cas.getY() == this.y-1) {
					this.y--;
					if (this.y < 0) {
						this.x = 0;
					}
					break;
				}
			}
		}

		if (c.bas)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x && cas.getY() == this.y+1) {
					this.y++;
					if (this.x >100) {
						this.x = 100;
					}
					break;
				}
			}	
		}

	}
}
