package application;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Objet {
    protected int x, y;
    protected Personnage p;

    public Objet(int x, int y) {
        this.x = x;
        this.y = y;
        this.p = null;
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

    public void dessiner(Graphics2D g) {

    }
}
