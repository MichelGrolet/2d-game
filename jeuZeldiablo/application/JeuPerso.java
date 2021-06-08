package application;

import moteurJeu.moteur.*;
import java.util.ArrayList;

public class JeuPerso implements moteurJeu.moteur.Jeu{
	/**
	* Personnage principal 
	*/
	Personnage perso;

	/**
	* Le terrain dans lequel evolue les entites
	*/
	Labyrinthe lab;

	/**
	* Une liste des monstres
	*/
	ArrayList<Monstre> monstres;

	/**
	 * Constructeur du personnage
	 */
	public JeuPerso() {
		this.perso = new Personnage();
		this.lab = new Labyrinthe();
		this.monstres = new ArrayList<>();
	}

	/**
	 * genere un certains nombres de Monstres
	 * @param x le nombre de monstre a generer
	 */
	public void genererMonstres(int x) {
		if(x > 0) {
			if (x > this.getCasesLibres().size()) {
				x = this.getCasesLibres().size();
			}
			for (int i = 0; i < x; i++) {
				ArrayList<Case> casesLibres = this.getCasesLibres();		
				Case spawnMonstre = casesLibres.get((int)Math.floor(Math.random()*casesLibres.size()));
				monstres.add(new Monstre(spawnMonstre.getX(),spawnMonstre.getY()));
		
			}
		}
		
	}

	/**
	 * permet de connaitre les cases libres du jeu, c est a dire les cases sans joueur, monstres ou murs
	 * @return la liste de cases libres
	 */
	public ArrayList<Case> getCasesLibres(){
		ArrayList<Case> casesLibres = this.lab.getCasesLibres();
		Case casePerso = new Case(this.perso.getX(),this.perso.getY());
		ArrayList<Case> casesMonstres = new ArrayList<>();
		for (Monstre monstre : this.monstres) {
			casesMonstres.add(new Case(monstre.getX(), monstre.getY()));
		}
		casesLibres.remove(casePerso);
		casesLibres.removeAll(casesMonstres);
		return(casesLibres);
	}
	
	/**
	 * retourne la liste des monstres
	 * @return liste de monstre
	 */
	public ArrayList<Monstre> getMonstres(){
		return(this.monstres);
	}
	
	/**
	 * retourne le personnage
	 * @return le personnage
	 */
	public Personnage getPersonnage() {
		return(this.perso);
	}

	/**
	 * retourne le labyrinthe associe
	 * @return labyrinthe associe
	 */
	public Labyrinthe getLabyrinthe() {
		return this.lab;
	}

	/**
	 * retourne la position du personnage
	 * @return un string qui indique la poition du personnage
	 */
	public String toString() {
		return this.perso.toString()+"\n";
	}

	@Override
	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void evoluer(Commande commandeUser) {
		this.getPersonnage().deplacer(commandeUser);
	}
}
