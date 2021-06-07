package application;

import java.awt.*;
import java.util.*;

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

        //Couleur du sol : noir
        this.couleur = Color.BLACK;
    }

    /**
    * Retourne la couleur du mur
    * @return une couleur
    */
    public Color getColor(){
        return this.couleur;
    }
}