package application;

import java.util.ArrayList;

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

    /**
     *  permet au personnage de se deplacer
     * @param c, commande jouer par l'ultilisateur
     * @param libres, liste de cases accesibles
     */
	public void seDeplacer(Commande c, ArrayList<Case> libres) {
		ArrayList<Case> caseValide = this.deplacementAutour(libres);
		if (c.gauche)
		{
			for(Case cas : caseValide) {
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
			for(Case cas : caseValide) {
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
			for(Case cas : caseValide) {
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
			for(Case cas : caseValide) {
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
