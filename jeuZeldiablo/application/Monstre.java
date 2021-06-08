package application;

public class Monstre extends Entite {
    private int x,y;

    /**
     * construit un monstre aux coordonnees donnees en parametre
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Monstre(int x, int y) {
        super(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
