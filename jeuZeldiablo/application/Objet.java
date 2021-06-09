package application;

import java.awt.image.BufferedImage;

public class Objet {
    private int x, y;
    private Personnage p;

    public Objet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPersonnage(Personnage p) {
        this.p = p;
    }

    public void dessiner(BufferedImage im) {

    }
}
