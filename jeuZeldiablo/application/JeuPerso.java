package application;

import moteurJeu.moteur.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JeuPerso implements moteurJeu.moteur.Jeu{

	
	Personnage perso;
	Labyrinthe lab;
	ArrayList<Monstre> monstres;

	/**
	 * Constructeur du personnage
	 */
	public JeuPerso() {
		this.perso = new Personnage();
		this.lab = new Labyrinthe();
		this.monstres = new ArrayList<Monstre>();
		genererMonstres(2);
	}

	/**
	 * genere un certains nombres de Monstres
	 * @param x le nombre de monstre a generer
	 */
	public void genererMonstres(int x) {
		for (int i = 0; i <= x; i++) {
			ArrayList<Case> casesLibres = this.lab.getCasesLibres();
			Case spawnMonstre = casesLibres.get((int)Math.floor(Math.random()*casesLibres.size()));
			Monstre nMonstre = new Monstre(spawnMonstre.getX(),spawnMonstre.getY());
		}
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
	 * retourne la position du personnage
	 * @return un string qui indique la poition du personnage
	 */
	public String toString() {
		String res = this.perso.toString()+"\n";
		return(res);
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
