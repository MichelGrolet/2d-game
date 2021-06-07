package application;

public class Monstre {
    private int x,y;

    /**
     * construit un monstre aux coordonnees donnees en parametre
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
