package application;

public class Gobelin extends Monstre {

    private static int vitesse = 2;
    private static int puissance = 1;
    private int pv;

    /**
     * construit un monstre aux coordonnees donnees en parametre
     *
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Gobelin(int x, int y) {
        super(x, y);

        this.pv = 5;
    }
}
