package application;

/**
* Classe representant une case du labyrinthe,
* pouvant etre un mur ou un sol
*/
public class Case{
    /**
    * Coordonnee x de la case
    */
    protected int x;

    /**
    * Coordonnee y de la case
    */
    protected int y;
    
    /**
     * Place accesible ou non
     */
    protected boolean libre;

    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Case(int x,int y){
        //Instancie a zero si le parametre est negatif
        if(x<0){
            this.x=0;
        }
        else{
            this.x=x;
        }

        //Instancie a zero si le parametre est negatif
        if(y<0){
            this.y=0;
        }
        else{
            this.y=y;
        }
    }
    
    public boolean getLibre() {
    	return(this.libre);
    }

    /**
    * Retourne la coordonnee x de la case
    * @return un int
    */
    public int getX(){
        return this.x;
    }

    /**
    * Retourne la coordonnee y de la case
    * @return un int
    */
    public int getY(){
        return this.y;

    }
}