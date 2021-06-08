package application;

import java.util.ArrayList;

public class Labyrinthe {
	/**
	* Constante qui determine la taille de la grille
	* qui est un carre
	*/
	private static int TAILLE = 20;

	/**
	* Tableau de Case a deux dimensions
	*/
	private Case[][] cases;
	
	/**
	 * Creation d'un labyrinthe avec uniquement des cases de types sol
	 */
	public Labyrinthe() {
		//Creer un tableau carre de 20x20
		this.cases = new Case[TAILLE][TAILLE];
		for(int i=0; i<TAILLE; i++) {
			for(int j=0; j<TAILLE; j++) {
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
				//Si la case est libre, on l'ajoute a la liste a retourner
				if (this.cases[i][j].getLibre()) {
					lc.add(this.cases[i][j]);
				}
			}
		}
		return(lc);
	}

	/**
	* Permet de generer les murs du labyrinthe,
	* selon le schema choisi
	* @param choix le pattern choisi
	*/
	public void genererMur(int choix){
		for(int i=0;i<TAILLE;i++){
			
		}
	}
}
