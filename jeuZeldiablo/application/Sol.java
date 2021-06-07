/**
* Classe representant du sol
* implemente Case
*/
public class Sol implements Case{

    /**
    * Coordonnee x de la case
    */
    private int x;

    /**
    * Coordonnee y de la case
    */
    private int y;

    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Sol(int x,int y){
        //Instancie a zero si le parametre est negatif
        if(x<0){
            this.x=0;
        }
        else{
            this.x=x;
        }

        //Instancie a zero si le parametre est negati
        if(y<0){
            this.y=0;
        }
        else{
            this.y=y;
        }
    }
}