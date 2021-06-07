package application;

import moteurJeu.moteur.Commande;

/**
 * Classe qui represente un personnage
 *
 */
public class Personnage {
    /**
    * Coordonnee x du personnage
    */
    private int x;

    /**
    * Coordonnee y du personnage
    */
    private int y;

    /**
    * Constructeur qui prend des coordonnees x,y en parametres
    * @param x entier pour la coordonnee x
    * @param y entier pour la coordonnee y
    */
    public Personnage(){
        this.x = 0;
        this.y = 0;
    }

    /**
    * Retourne la coordonnee x du personnage
    * @return un entier
    */
    public int getX(){
        return this.x;
    }

    /**
    * Retourne la coordonnee y du personnage
    * @return un entier
    */
    public int getY(){
        return this.y;
    }

    /**
    * Permet de modifier la coordonnee x du personnage
    * @param x la nouvelle coordonnee x pour le personnage
    */
    public void setX(int x){
        //Si le parametre est negatif, on ne change pas l'attribut
        if(x>=0){
            this.x=x;
        }
    }

    /**
    * Permet de modifier la coordonnee y du personnage
    * @param y la nouvelle coordonnee y pour le personnage
    */
    public void setY(int y){
        //Si le parametre est negatif, on ne change pas l'attribut
        if(y>=0){
            this.y=y;
        }
    }

    public String toString() {
    	return("Le personage est en "+this.getX()+", "+this.getY());
    }

	public void deplacer(Commande c) {
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
