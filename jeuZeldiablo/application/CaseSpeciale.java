package application;

import java.awt.*;

/**
* Classe abstraite representant une case speciale(piege,boost,etc...)
*/
public abstract class CaseSpeciale extends Sol{
    /**
    * Constructeur heritant de celui de Sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public CaseSpeciale(int x,int y){
        super(x,y); 
    }

    /**
    * Permet de declencher l'effet et passe la case en inactivable
    * @param joueur le joueur qui subit l'effet
    */   
    public void declencherEffet(Personnage joueur){
        //Si la case est activable, on active l'effet de la classe et on desactive la case
        if(active){
            effet(joueur);
            this.active=true;
        }
    }

    /**
    * Methode abstraite, defini l'effet de la case sur le joueur
    * @param joueur le joueur qui subit l'effet
    */
    public abstract void effet(Personnage joueur);

    /**
    * Dessine la case
    * @param g Graphics2D
    */
    public void dessiner(Graphics2D g) {}
}