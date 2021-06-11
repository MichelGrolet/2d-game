package entite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import application.*;
import labyrinthe.*;

public class Orc extends Monstre {

	/**
     * construit un monstre aux coordonnees donnees en parametre
     *
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Orc(int x, int y) {
        super(x, y);
        this.puissance = 2;
        this.pv = 10;
    }

    public void dessiner(Graphics2D g) {
        try {
            BufferedImage im = ImageIO.read(new File("./sprites/orc.png"));
            g.drawImage(im,this.x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
        }catch(FileNotFoundException e){
            e.getStackTrace();
        }catch(IOException f) {
            f.getStackTrace();
        }
    }
}
