public class Labyrinthe {
	private static int taille = 10;
	private Case[][] cases;
	
	public Labyrinthe() {
		for(int i=0; i<taille; i++) {
			for(int j=0; j<taille; j++) {
				cases[i][j] = new Sol();
			}
		}
	}
}
