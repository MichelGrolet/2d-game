package application;

import moteurJeu.moteur.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JeuPerso implements moteurJeu.moteur.Jeu{

	//creation du personnage
	Personnage perso;
	Labyrinthe lab;
	ArrayList<Monstre> monstres;

	public JeuPerso() {
		this.perso = new Personnage();
		this.lab = new Labyrinthe();
		this.monstres = new ArrayList<Monstre>();
		genererMonstres(2);
	}

	public void genererMonstres(int x) {
		for (int i = 0; i <= x; i++) {
			ArrayList<Case> casesLibres = this.lab.getCasesLibres();
			Case spawnMonstre = casesLibres.get((int)Math.floor(Math.random()*casesLibres.size()));
			Monstre nMonstre = new Monstre(spawnMonstre.getX(),spawnMonstre.getY());
		}
	}
	
	public ArrayList<Monstre> getMonstres(){
		return(this.monstres);
	}
	
	public Personnage getPersonnage() {
		return(this.perso);
	}

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
