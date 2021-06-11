package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* Classe abstraite representant une case speciale(piege,boost,etc...)
*/
public class CaseForce extends CaseSpeciale{
    private static final int BOOST=2;

    /**
    * Constructeur heritant de celui de CaseSpeciale
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public CaseForce(int x,int y){
        super(x,y);
    }

    /**
    * Permet de declencher l'effet et passe la case en inactivable
    * @param joueur le joueur qui subit l'effet
    */   
    public void declencherEffet(Personnage joueur){
        //Si elle n'est active, on active l'effet de la classe et on desactive la case
        if(!active){
            effet(joueur);
            this.active=true;
        }
    }

    /**
    * Reduit les points de vie du joueur s'il marche dessus
    * @param joueur le joueur qui subit l'effet
    */
    public void effet(Personnage joueur){
        joueur.setPuissance(joueur.getPuissance()+BOOST);
    }

    /**
    * Dessine la case
    * @param g Graphics2D
    */
    public void dessiner(Graphics2D g) {
        if(!this.getActive()){
        	try {
        		//on recupere l'image dans les fichiers
        		BufferedImage im = ImageIO.read(new File("./sprites/floor.png"));
        		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
        	}catch(FileNotFoundException e){
        		e.getStackTrace();
        	}catch(IOException f) {
        		f.getStackTrace();
        	}
        }
        else{
            try {
                BufferedImage im = ImageIO.read(new File("./sprites/force.png"));
                g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
            }catch(FileNotFoundException e){
                e.getStackTrace();
            }catch(IOException f) {
                f.getStackTrace();
            }
        }
    }
}