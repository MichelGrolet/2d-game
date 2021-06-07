package application;

public class Labyrinthe {
	private static int taille = 10;
	private Liste<Case> cases;
	
	public Labyrinthe() {
		for(int i=0; i<taille; i++) {
			cases.add(new Sol());
		}
	}
}
