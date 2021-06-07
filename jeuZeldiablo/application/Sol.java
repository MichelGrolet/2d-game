package application;

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
        
        this.libre = true;
        //Couleur du sol : gris
        this.couleur = Color.GRAY;
    }
}