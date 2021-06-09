package application;

import moteurJeu.moteur.*;
import java.util.ArrayList;

public class JeuPerso implements moteurJeu.moteur.Jeu{
	/**
	* Personnage principal
	*/
	private final Personnage perso;

	/**
	* Le terrain dans lequel evolue les entites
	*/
	private final Labyrinthe lab;

	/**
	* Une liste des monstres
	*/
	private final ArrayList<Monstre> monstres;

	/**
	 * permet d'identifier quand on appelle deplacerMonstres
	 */
	private int timer;
	
	/**
	 * une liste des objets
	 */
	private ArrayList<Objet> objets;

	/**
	 * Constructeur du personnage
	 */
	public JeuPerso(int niveau) {
		this.perso = new Personnage(1,1);
		this.lab = new Labyrinthe();
		this.lab.genererMur(niveau);
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
				int typeM = (int) Math.floor(Math.random()*3);
				System.out.println(typeM);
				ArrayList<Case> casesLibres = this.getCasesLibres();
				Case spawnMonstre = casesLibres.get((int)Math.floor(Math.random()*casesLibres.size()));
				switch (typeM) {
				case 0 ->{
					this.monstres.add(new Gobelin(spawnMonstre.getX(),spawnMonstre.getY()));
					}
				case 1 ->{
					this.monstres.add(new Orc(spawnMonstre.getX(),spawnMonstre.getY()));
					}
				case 2 ->{
					this.monstres.add(new Fantome(spawnMonstre.getX(),spawnMonstre.getY()));
					}
				}
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
			if(m.getX()==this.perso.getX()+1 || m.getX()==this.perso.getX()-1
					|| m.getY()==this.perso.getY()+1 || m.getY()==this.perso.getY()-1) {
				m.attaquer(this.perso);
			}else {
				for (int i = 0; i < m.getVitesse(); i++) {
					m.seDeplacer(m.deplacementAutour(this), this.perso);
				}
			}
		}
	}
	/**
	 * permet de recuperer les cases occupees par les entites
	 * @return les cases occupes par les entites
	 */
	public ArrayList<Case> getCasesEntites(){
		Case casePerso = new Case(this.perso.getX(),this.perso.getY());
		ArrayList<Case> casesEntites = new ArrayList<>();
		for (Monstre monstre : this.monstres) {
			casesEntites.add(new Case(monstre.getX(), monstre.getY()));
		}
		casesEntites.add(casePerso);
		return(casesEntites);
	}
	
	/**
	 * permet de connaitre les cases libres du jeu, c est a dire les cases sans joueur, monstres ou murs
	 * @return la liste de cases libres
	 */
	public ArrayList<Case> getCasesLibres(){
		ArrayList<Case> casesLibres = this.lab.getCasesLibres();
		ArrayList<Case> casesOccupes = this.getCasesEntites();
		
		for (int i = 0; i< casesLibres.size();i++) {
			for(int j = 0; j < casesOccupes.size(); j++) {
					if(casesLibres.get(i).getX() == casesOccupes.get(j).getX() && casesLibres.get(i).getY()==casesOccupes.get(j).getY()) {
						casesLibres.remove(i);
					}
				}
			}
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
		if(!this.perso.etreMort()) {
			this.getPersonnage().seDeplacer(commandeUser, this.getPersonnage().deplacementAutour(this));
			Sol s = (Sol) this.lab.getCase(this.getPersonnage().getX(), this.getPersonnage().getY());
			s.declencherEffet(this.getPersonnage());
			timer++;
			if (this.timer == 10) {
				this.deplacerMonstres();
				this.timer = 0;
			}
			if(commandeUser.attaque) {
				for(int i=0; i<this.monstres.size(); i++) {
					this.getPersonnage().attaquer(this.monstres.get(i));
					if(this.monstres.get(i).etreMort()) {
						this.monstres.remove(this.monstres.get(i));
					}
				}
			}
			if(commandeUser.ramasser) {
				for(int i=0; i<this.objets.size(); i++) {
					this.getPersonnage().ramasserObjet(this.objets.get(i));
					this.objets.remove(this.objets.get(i));
				}
			}
		}
	}
}
