package application;

public class Labyrinthe {
	private static int taille = 10;
	private Case[][] cases;
	
	
	/**
	 * Creation d'un labyrinthe avec uniquement des cases de types sol
	 */
	public Labyrinthe() {
		for(int i=0; i<taille; i++) {
			for(int j=0; j<taille; j++) {
				cases[i][j] = new Sol(i, j);
			}
		}
	}
	
	
	/**
	 * retourne la case demandé
	 * @param i position en x
	 * @param j position en y
	 * @return la case
	 */
	public Case getCase(int i, int j){
		return this.cases[i][j];
	}
}
