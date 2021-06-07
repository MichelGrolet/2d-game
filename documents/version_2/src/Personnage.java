
/**
 * Classe qui représente un personnage
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
    public Personnage(int x,int y){
        //Si le parametre est negatif, on instancie a zero
        if(x<0){
            this.x=0;
        }
        else{
            this.x=x;
        }

        //Si le parametre est negatif, on instancie a zero
        if(x<0){
            this.y=0;
        }
        else{
            this.y=y;
        }
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
}