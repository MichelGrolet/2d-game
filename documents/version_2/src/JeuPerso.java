package jeuPerso;

import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class JeuPerso implements Jeu {

	/**
	 * le personnage du jeu
	 */
	private Personnage perso;

	/**
	 * constructeur de jeu avec un Personnage
	 */
	public JeuPerso() {
		this.perso=new Personnage();
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		this.getPerso().deplacer(commande);

	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Personnage getPerso() {
		return perso;
	}

}