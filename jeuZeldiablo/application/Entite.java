package application;

public abstract class Entite {
   /**
	* Coordonnee x de l'entite
	*/
	protected int x;
	
	/**
	* Coordonnee y de l'entite
	*/
	protected int y;
	
	/**
	* Constructeur qui prend des coordonnees x,y en parametres
	* @param x entier pour la coordonnee x
	* @param y entier pour la coordonnee y
	*/
	public Entite(int x, int y){
	    this.x = x;
	    this.y = y;
	}
	
   /**
    * Retourne la coordonnee x de l'entite
    * @return un entier
    */
    public int getX(){
        return this.x;
    }

    /**
    * Retourne la coordonnee y de l'entite
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
     
     public abstract String toString();
}
