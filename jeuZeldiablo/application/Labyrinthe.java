package application;

import java.util.ArrayList;

public class Labyrinthe {
	/**
	* Constante qui determine la taille de la grille
	* qui est un carre
	*/
	private static int TAILLE = 21;

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
		for(int i=0; i<TAILLE; i++) {
			for(int j=0; j<TAILLE; j++) {
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
		//Contour haut du labyrinthe
		for(int i=0;i<TAILLE;i++){
			this.cases[i][0]=new Mur(i,0);
		}

		//Contour bas du labyrinthe
		for(int i=0;i<TAILLE;i++){
			this.cases[i][TAILLE-1]=new Mur(i,TAILLE-1);
		}

		//Contour gauche du labyrinthe
		for(int j=0;j<TAILLE;j++){
			this.cases[0][j]=new Mur(0,j);
		}

		//Contour droite du labyrinthe
		for(int j=0;j<TAILLE;j++){
			this.cases[TAILLE-1][j]=new Mur(TAILLE-1,j);
		}

		switch(choix){
			//Schema horizontal
			case 0:
				for(int j=2;j<TAILLE-2;j++){
					for(int i=2;i<TAILLE-2;i++){
						this.cases[i][j]=new Mur(i,j);
					}
				}
				break;

			//Schema vertical
			case 1:
				for(int i=2;i<TAILLE-2;i+=2){
					for(int j=2;j<TAILLE-2;j+=2){
						this.cases[i][j]=new Mur(i,j);
					}
				}
				break;

			//Schema point
			case 2:
				for(int i=2;i<TAILLE-2;i++){
					for(int j=2;j<TAILLE-2;j++){
						this.cases[i][j]=new Mur(i,j);
					}
				}
				break;
		}
	}
}
