package application;

import java.awt.*;
import java.util.ArrayList;

import moteurJeu.moteur.Commande;

/**
 * Classe qui represente un personnage
 *
 */
public class Personnage extends Entite{

	private int puissance;

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

    public void dessiner(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillOval(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE,
				DessinPerso.TAILLE_CASE);
		g.setColor(Color.black);
		g.drawString(""+this.getPv(), x* DessinPerso.TAILLE_CASE+(DessinPerso.TAILLE_CASE/2), y* DessinPerso.TAILLE_CASE+(DessinPerso.TAILLE_CASE/2));
	}

    /**
     *  permet au personnage de se deplacer
     * @param c, commande jouer par l'ultilisateur
     */
	public void seDeplacer(Commande c, JeuPerso j) {
		ArrayList<Case> caseValide = this.deplacementAutour(j);
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
