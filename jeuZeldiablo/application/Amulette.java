package application;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Amulette extends Objet {

    public Amulette(int x, int y) {
        super(x, y);
    }

    public void dessiner(Graphics2D g) {
        g.setColor(Color.pink);
        g.fillArc(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, 0, 360);
    }
}
