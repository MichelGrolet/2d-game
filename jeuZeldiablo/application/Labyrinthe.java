package application;

import java.util.ArrayList;

public class Labyrinthe {
	/**
	* Constante qui determine la taille de la grille
	* qui est un carre
	*/
	public static int TAILLE = 15;

	/**
	* Tableau de Case a deux dimensions
	*/
	private Case[][] cases;
	
	/**
	 * Creation d'un labyrinthe avec uniquement des cases de types sol
	 */
	public Labyrinthe() {
		//Creer un tableau carre de 21x21
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

		//Si le parametre est mauvais, on choisi aleatoirement
		int alea;
		if(choix<0 || choix>3){
			alea=((int)Math.floor(Math.random()*4));
		}
		else{
			alea=choix;
		}

		switch(alea){
			//Schema horizontal
			case 0:
				for(int j=2;j<TAILLE-2;j+=2){
					for(int i=2;i<TAILLE-2;i++){
						this.cases[i][j]=new Mur(i,j);
					}
				}
				this.cases[3][1]=new CasePiege(3, 1);
				break;

			//Schema vertical
			case 1:
				for(int i=2;i<TAILLE-2;i+=2){
					for(int j=2;j<TAILLE-2;j++){
						this.cases[i][j]=new Mur(i,j);
					}
				}
				break;

			//Schema point
			case 2:
				for(int i=2;i<TAILLE-2;i+=2){
					for(int j=2;j<TAILLE-2;j+=2){
						this.cases[i][j]=new Mur(i,j);
					}
				}
				break;
			
			//schema elabore
			case 3 :
				char[][] pattern=           {
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'},
											{'m','s','f','s','m','s','s','s','s','m','m','s','p','s','m'},
											{'m','p','s','s','s','s','s','m','s','s','m','s','m','s','m'},
											{'m','m','m','m','m','s','m','m','m','s','p','s','m','s','m'},
											{'m','m','s','s','s','s','s','m','m','s','s','s','m','s','m'},
											{'m','s','s','s','m','m','s','s','m','m','s','m','m','s','m'},
											{'m','s','m','m','m','s','s','s','s','m','s','p','m','s','m'},
											{'m','s','s','m','m','f','m','m','s','s','s','m','m','s','m'},
											{'m','m','s','s','m','s','m','s','s','m','m','m','s','s','m'},
											{'m','s','s','m','m','s','s','s','s','m','m','s','s','f','m'},
											{'m','s','m','m','m','m','s','s','m','m','m','s','m','m','m'},
											{'m','s','s','m','m','s','s','m','m','f','m','s','m','m','m'},
											{'m','p','s','s','m','s','s','m','m','s','s','s','m','m','m'},
											{'m','s','m','s','s','s','m','m','m','m','s','s','m','m','m'},
											{'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'}
											};
				for(int j=0;j<TAILLE;j++){
					for(int i=0;i<TAILLE;i++){
						switch(pattern[j][i]){
							case 'm':
								this.cases[i][j]=new Mur(i,j);
								break;

							case 's':
								this.cases[i][j]=new Sol(i,j);
								break;

							case 'f':
								this.cases[i][j]=new CaseForce(i,j);
								break;

							case 'p':
								this.cases[i][j]=new CasePiege(i,j);
								break;
						}
					}
				}
				break;

			/*case 4 :
				char[][] pattern=            {
											 {'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'},
											 {'m','s','f','s','m','s','s','s','s','m','m','s','s','s','m','m','m','m','s','s','m'},
											 {'m','p','s','s','s','s','s','m','s','s','m','s','m','s','s','m','m','m','s','m','m'},
											 {'m','m','m','m','m','s','m','m','m','s','p','s','m','s','m','s','m','m','s','m','m'},
											 {'m','m','s','s','s','s','s','m','m','s','s','s','m','s','m','s','s','m','s','m','m'},
											 {'m','s','s','s','m','m','s','s','m','m','s','m','m','s','m','m','s','s','s','s','m'},
											 {'m','s','m','m','m','s','s','s','s','m','s','p','m','s','m','s','s','s','m','m','m'},
											 {'m','s','s','m','m','f','m','m','s','s','s','m','m','s','s','s','m','s','m','s','m'},
											 {'m','m','s','s','m','s','m','s','s','m','m','m','s','s','s','m','m','s','m','s','m'},
											 {'m','s','s','m','m','s','s','s','s','m','m','s','s','f','m','m','s','s','s','s','m'},
											 {'m','s','m','m','m','m','s','s','m','m','m','s','m','m','m','s','s','m','m','s','m'},
											 {'m','s','s','m','m','s','s','m','m','p','m','s','m','m','s','s','p','m','s','s','m'},
											 {'m','s','s','s','m','s','s','m','m','s','s','s','m','m','s','s','m','m','s','m','m'},
											 {'m','s','m','s','s','s','m','m','m','m','s','s','m','m','m','s','m','s','s','m','m'},
											 {'m','s','m','m','s','s','s','m','m','s','s','m','m','s','s','s','m','m','s','s','m'},
											 {'m','s','s','m','m','f','m','m','m','s','m','m','m','m','p','s','m','m','m','s','m'},
											 {'m','m','s','m','m','s','s','m','s','s','s','m','m','s','s','m','m','s','m','m','m'},
											 {'m','s','s','s','m','s','m','m','m','s','s','m','s','s','m','m','m','s','s','m','m'},
											 {'m','s','m','m','m','s','m','m','s','s','m','m','s','m','m','s','s','s','m','m','m'},
											 {'m','s','s','s','s','s','f','m','m','s','s','s','s','s','s','s','m','s','s','f','m'},
											 {'m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m','m'}
											 };
				for(int j=0;j<TAILLE;j++){
					for(int i=0;i<TAILLE;i++){
						switch (pattern[i][j]) {
							case 'm' -> this.cases[i][j] = new Mur(i, j);
							case 's' -> this.cases[i][j] = new Sol(i, j);
							case 'f' -> this.cases[i][j] = new CaseForce(i, j);
							case 'p' -> this.cases[i][j] = new CasePiege(i, j);
						}
					}
				}
				break;*/
		}
	}
}
