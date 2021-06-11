package application;

import java.io.*;
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
	* Numero du niveau courant
	*/
	private static int niveau=0;
	
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

		//On instancie a 0 le niveau
		this.niveau=0;
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
	public void genererMur() throws FileNotFoundException,IOException,ClassNotFoundException{
		//On passe au niveau suivant
		//On s'assure de ne pas depasser le niveau 3
		if(this.niveau<3){
			this.niveau++;
		}

		//Variable de chargement du bon fichier
		String nomFichier;

		//On recupere le bon niveau le bon niveau
		switch(this.niveau){
			case 1 :
				nomFichier="p1.txt";
				break;

			case 2 :
				nomFichier="p2.txt";
				break;

			case 3 :
				nomFichier="p3.txt";
				break;

			//Si il y a un probleme, on charge le dernier niveau
			default :
				nomFichier="p3.txt";
		}

		//On le charge
		ObjectInputStream fich=new ObjectInputStream(new FileInputStream(nomFichier));
		char[][] pattern=(char[][])(fich.readObject());
		fich.close();
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
				System.out.print(pattern[i][j]);
			}
			System.out.println();
		}
	}

	/**
	* Renvoie le numero du niveau courant
	* @return un entier
	*/
	public int getNiveau(){
		return this.niveau;
	}
}
