package src;

import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract{
	
	//creation du personnage
	Personnage perso;
	
	public Jeu() {
		this.perso = new Personnage(0,0);
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
}