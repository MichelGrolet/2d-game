package application;

import java.awt.*;

/**
* Classe representant un mur
* herite de Case
*/
public class Mur extends Case{
    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Mur(int x,int y){
        super(x,y);
        
        //Instancie a non libre
        this.libre=false;
    }
    
    public void dessiner(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE);
    }
}