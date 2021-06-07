package application;

import java.util.ArrayList;

public class Labyrinthe {
	/**
	* Constante qui determine la taille de la grille
	* qui est un carre
	*/
	private static int taille = 10;

	/**
	* Tableau de Case a deux dimensions
	*/
	private Case[][] cases;
	
	/**
	 * Creation d'un labyrinthe avec uniquement des cases de types sol
	 */
	public Labyrinthe() {
		this.cases = new Case[10][10];
		for(int i=0; i<taille; i++) {
			for(int j=0; j<taille; j++) {
				cases[i][j] = new Sol(i, j);
			}
		}
	}
	
	/**
	 * retourne la case demande
	 * @param i position en x
	 * @param j position en y
	 * @return la case
	 */
	public Case getCase(int i, int j){
		return this.cases[i][j];
	}
	
	/**
	* Retourne le tableau de case
	* @return un tableau de case
	*/
	public Case[][] getTabCase(){
		return this.cases;
	}
	
	/**
	* Retourne une liste contenant les cases libres
	* @return une liste de cases
	*/
	public ArrayList<Case> getCasesLibres() {
		ArrayList<Case> lc = new ArrayList<Case>();
		for(int i=0; i<taille; i++) {
			for(int j=0; j<taille; j++) {
				if (this.cases[i][j].getLibre()) {
					lc.add(this.cases[i][j]);
				}
			}
		}
		return(lc);
	}
}
