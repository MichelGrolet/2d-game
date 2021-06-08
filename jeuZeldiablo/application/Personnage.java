package application;

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
    }

    public String toString() {
    	return("Le personage est en "+this.getX()+", "+this.getY());
    }

	public void seDeplacer(Commande c) {
		if (c.gauche)
		{
			this.x--;
			if (this.x < 0)
				this.x = 0;
		}

		if (c.droite)
		{
			this.x++;
			if (this.x >100) {
				this.x = 100;
			}

		}

		if (c.haut)
		{
			this.y--;
			if (this.y < 0) {
				this.x = 0;
			}

		}

		if (c.bas)
		{
			this.y++;
			if (this.x >100) {
				this.x = 100;
			}

		}

	}
}
