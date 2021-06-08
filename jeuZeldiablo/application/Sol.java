package application;

import java.awt.*;

/**
* Classe representant du sol
* herite de Case
*/
public class Sol extends Case{
    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Sol(int x,int y){
        super(x,y);
        
        //Instancie a libre
        this.libre=true;
    }

    public void dessiner(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE);
    }
}