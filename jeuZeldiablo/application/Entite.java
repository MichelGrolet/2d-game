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
	 * point de vie de l'entite
	 */
	protected int pv;
	
	/**
	* Constructeur qui prend des coordonnees x,y en parametres
	* @param x entier pour la coordonnee x
	* @param y entier pour la coordonnee y
	*/
	public Entite(int x, int y){
	    this.x = x;
	    this.y = y;
	    this.pv = 10;
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
     * Rtourne les pv de l'entite
     * @return un entier
     */
    public int getPv() {
    	return this.pv;
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
     
     /**
      * fait subir des degats à l'entite si ses pv sont superieur a 0
      */
     public void subirDegats() {
    	 if(pv>0) {
        	 this.pv = this.pv-1; 
    	 }
     }
     
     /**
      * attaque une entite et lui fait subir des degats
      * @param e l'entite vise
      */
     public void attaquer(Entite e) {
    	 e.subirDegats();
     }
}
