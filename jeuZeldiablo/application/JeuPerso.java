package application;

import moteurJeu.moteur.*;

import java.awt.image.BufferedImage;

public class JeuPerso implements moteurJeu.moteur.Jeu{

	//creation du personnage
	Personnage perso;

	public JeuPerso() {
		this.perso = new Personnage();
	}

	/**
	 * permet le déplacement du personnage
	 * @param direction, correpond a la direction voulu
	 */
	public void deplacer(String direction) {
		//on regarde dans quelle direction veut se deplacer le personnage
		if (direction.equals("gauche")) {
			this.perso.setX(-1);
		}else if(direction.equals("droite")) {
			this.perso.setX(1);
		}else if(direction.equals("haut")) {
			this.perso.setY(-1);
		}else if(direction.equals("bas")) {
			this.perso.setY(1);
		}
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
