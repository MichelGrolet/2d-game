package application;

import java.awt.*;

public class Gobelin extends Monstre {

    private int pv;

    /**
     * construit un monstre aux coordonnees donnees en parametre
     *
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Gobelin(int x, int y) {
        super(x, y);
        this.vitesse = 2;
        this.pv = 5;
    }

    public void dessiner(Graphics2D g) {
        g.setColor(Color.decode("#397000"));
        g.fillArc(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, 0, 360);
    }
}
