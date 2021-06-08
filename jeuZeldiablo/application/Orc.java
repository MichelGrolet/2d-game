package application;

public class Orc extends Monstre {

    private static int vitesse = 1;
    private static int puissance = 2;
    private int pv;

    /**
     * construit un monstre aux coordonnees donnees en parametre
     *
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Orc(int x, int y) {
        super(x, y);

        this.pv = 10;
    }
}
