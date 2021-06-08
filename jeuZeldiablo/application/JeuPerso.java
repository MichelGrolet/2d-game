package application;

import moteurJeu.moteur.*;
import java.util.ArrayList;

public class JeuPerso implements moteurJeu.moteur.Jeu{
	/**
	* Personnage principal 
	*/
	private Personnage perso;

	/**
	* Le terrain dans lequel evolue les entites
	*/
	private Labyrinthe lab;

	/**
	* Une liste des monstres
	*/
	private ArrayList<Monstre> monstres;

	/**
	 * permet d'identifier quand on appelle deplacerMonstres
	 */
	private int timer;

	/**
	 * Constructeur du personnage
	 */
<<<<<<< HEAD
	public JeuPerso() {
		this.perso = new Personnage(1,1);
=======
	public JeuPerso() throws InterruptedException {
		this.perso = new Personnage(0,0);
>>>>>>> af5bd3d375e15fb8948da9f8c354f93c1088a508
		this.lab = new Labyrinthe();
		this.lab.genererMur(2);
		this.monstres = new ArrayList<>();
		this.genererMonstres(3);
		this.timer = 0;
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
				this.monstres.add(new Monstre(spawnMonstre.getX(),spawnMonstre.getY()));
			}
		}
	}
	
	/**
	 * permet de faire apparaitre un monstre
	 * @param m, monstre a faire apparaitre
	 * @return true si et seulement si le monstre est apparu
	 */
	public boolean faireApparaitre(Monstre m) {
		ArrayList<Case> casesLibres = this.getCasesLibres();
		Case c = new Case(m.getX(),m.getY());
		boolean res = false;
		int i = 0;
		while(!res) {
			if(casesLibres.get(i).equals(c)) {
				this.monstres.add(m);
				res = true;
			}
		}
		return res;
	}
	
	/**
	 * permet au jeu de deplacer les monstres
	 */
	public void deplacerMonstres() {
		for(Monstre m : monstres) {
			m.seDeplacer(m.deplacementAutour(this.getCasesLibres()),this.perso);
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
		this.getPersonnage().seDeplacer(commandeUser);
		timer++;
		if (this.timer == 20) {
			this.deplacerMonstres();
			this.timer = 0;
		}
		if(commandeUser.attaque) {
			for(int i=0; i<this.monstres.size(); i++) {
				this.getPersonnage().attaquer(this.monstres.get(i));
			}
		}
	}
}
