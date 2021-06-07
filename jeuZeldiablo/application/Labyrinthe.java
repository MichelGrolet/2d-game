package application;

import java.util.ArrayList;

public class Labyrinthe {
	private static int taille = 10;
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
	
	public ArrayList<Case> getCasesLibres() {
		ArrayList<Case> lc = new ArrayList<Case>();
		for(int i=0; i<taille; i++) {
			for(int j=0; j<taille; j++) {
				if (this.cases[i][j].libre) {
					lc.add(this.cases[i][j]);
				}
			}
		}
		return(lc);
	}
}
