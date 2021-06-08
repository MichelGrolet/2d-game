package application;

import java.util.ArrayList;

public class Entite {
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
	 * point de puissance
	 */
	protected int puissance;
	
	/**
	* Constructeur qui prend des coordonnees x,y en parametres
	* @param x entier pour la coordonnee x
	* @param y entier pour la coordonnee y
	*/
	public Entite(int x, int y){
	    this.x = x;
	    this.y = y;
	    this.pv = 10;
	    this.puissance = 1;
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
     * retourne les pv de l'entite
     * @return un entier
     */
    public int getPv() {
    	return this.pv;
    }
    
    /**
     * retourne la puissance de l'entite
     * @return un entier
     */
    public int getPuissance() {
    	return this.puissance;
    }
    
    /**
     * Permet de modifier la coordonnee x de l'entite
     * @param x la nouvelle coordonnee x pour l'entite
     */
     public void setX(int x){
         //Si le parametre est negatif, on ne change pas l'attribut
         if(x>=0){
             this.x=x;
         }
     }

     /**
     * Permet de modifier la coordonnee y de l'entite
     * @param y la nouvelle coordonnee y pour l'entite
     */
     public void setY(int y){
         //Si le parametre est negatif, on ne change pas l'attribut
         if(y>=0){
             this.y=y;
         }
     }
     
     /**
      * permet de modifier la puissanece de l'entite
      * @param p la nouvelle puissance
      */
     public void setPuissance(int p) {
    	 this.puissance = p;
     }
     
     /**
      * fait subir des degats a l'entite si ses pv sont superieur a 0
      * @param d les degats subit par l'entite
      */
     public void subirDegats(int d) {
    	 if((pv-d)<0) {
        	 this.pv = 0; 
    	 }else {
    		 this.pv = this.pv-d;
    	 }
    	 System.out.println(this.pv);
     }
     
     /**
      * attaque une entite et lui fait subir des degats
      * @param e l'entite vise
      */
     public void attaquer(Entite e) {
    	 if((e.getX()==this.getX()-1 && e.getY()==this.getY())|| 
    			 (e.getX()==this.getX()+1 && e.getY()==this.getY())
    			 || (e.getY()==this.getY()+1 && e.getX()==this.getX()) || 
    			 (e.getY()==this.getY()-1 && e.getX()==this.getX())) {
        	 e.subirDegats(this.puissance);
    	 }
     }
     
     /**
      * recupere les cases autour de l'entite ou elle peut se deplacer
      * @param libres, cases libres du labyrinthe
      * @return les cases libres autour de l'entite
      */
     public ArrayList<Case> deplacementAutour(JeuPerso j){
		ArrayList<Case> bonneCase = new ArrayList<Case>();
		for(int i =0; i<j.getCasesLibres().size(); i++) {
			//si le x d'une case libre + ou - 1 est egal a x ETS le y d'une case + ou - 1 est egal a y (on recupere les cases a gauche, droite, haut, bas sans les diagonales)  
			if(((j.getCasesLibres().get(i).getX()+1 == this.x ||
					j.getCasesLibres().get(i).getX()-1 == this.x)
					&& j.getCasesLibres().get(i).getY() == this.y)|| 
			(( j.getCasesLibres().get(i).getY()+1 == this.y || 
			j.getCasesLibres().get(i).getY()-1 == this.y ) && 
					j.getCasesLibres().get(i).getX() == this.x)) {
						
				bonneCase.add(j.getCasesLibres().get(i));
			}	
		}
    	 return bonneCase;
     }
     
     /**
      * verifie si l'entite est mort
      * @return true si et seulement si l'entite est morte
      */
     public boolean etreMort() {
    	 boolean res = false;
    	 if(pv<=0) {
    		 res = true;
    	 }
    	 return res;
     }
}
