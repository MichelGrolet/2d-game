package application;

import java.awt.*;

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

    public void dessiner(Graphics2D g) {
        g.setColor(Color.decode("#592b00"));
        g.fillArc(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, 0, 360);
    }
}
