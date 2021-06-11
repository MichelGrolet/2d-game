package application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import moteurJeu.moteur.Commande;

/**
 * Classe qui represente un personnage
 *
 */
public class Personnage extends Entite{

	private ArrayList<Objet> inventaire;

   
	
	public final static int CASE_INVENTAIRE1 = (Labyrinthe.TAILLE+1)* DessinPerso.TAILLE_CASE;
	public final static int CASE_INVENTAIRE2 = (Labyrinthe.TAILLE+2)* DessinPerso.TAILLE_CASE;
	public final static int CASE_INVENTAIRE3 = (Labyrinthe.TAILLE+3)* DessinPerso.TAILLE_CASE;
	
	/**
	    * Constructeur qui prend des coordonnees x,y en parametres
	    * @param x entier pour la coordonnee x
	    * @param y entier pour la coordonnee y
	    */
    public Personnage(int x, int y){
    	super(x, y);
    	this.puissance = 2;
    	this.inventaire = new ArrayList<Objet>();
    }

    public String toString() {
    	return("Le personage est en "+this.getX()+", "+this.getY());
    }
    
    /**
     * permet de dessiner le personnage vivant
     * @param g, ou on dessine
     */
    public void dessiner(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/perso.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}
    
    /**
     * permet de dessiner le personnage mort
     * @param g, ou on dessine
     */
    public void dessinerMort(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/persodead.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}
    
    /**
     * permet de dessiner le personnage quand il attaque
     * @param g, ou on dessine
     */
    public void dessinerAttaque(Graphics2D g) {
    	try {
    		BufferedImage im = ImageIO.read(new File("./sprites/perso2fight.png"));
    		g.drawImage(im,x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE,null);
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
    	}
	}
    
    /**
     * permet de dessiner l'inventaire du personnage
     * @param g, ou on dessine
     */
    public void dessinerInventaire(Graphics2D g) {
    	try {
    		//dessine les pv
    		g.drawRect(CASE_INVENTAIRE1-5, Labyrinthe.TAILLE+3*(DessinPerso.TAILLE_CASE)-5,DessinPerso.TAILLE_CASE*3+15, DessinPerso.TAILLE_CASE-30);
    		g.setColor(Color.RED);
    		g.fillRect(CASE_INVENTAIRE1-4, Labyrinthe.TAILLE+3*(DessinPerso.TAILLE_CASE)-4,(int)((DessinPerso.TAILLE_CASE*3+14)*(((double)this.pv)/10)), DessinPerso.TAILLE_CASE-31);
    		
    		//dessine le perso
    		g.setColor(Color.BLACK);
    		BufferedImage im = ImageIO.read(new File("./sprites/perso2.png"));
			g.drawImage(im,(Labyrinthe.TAILLE+2) * DessinPerso.TAILLE_CASE, Labyrinthe.TAILLE+4*(DessinPerso.TAILLE_CASE),null);
			
			//dessine les cases d'inventaire
			g.drawRect(CASE_INVENTAIRE1-5, Labyrinthe.TAILLE+6*(DessinPerso.TAILLE_CASE)-5, DessinPerso.TAILLE_CASE+5, DessinPerso.TAILLE_CASE+5);
			g.drawRect(CASE_INVENTAIRE2, Labyrinthe.TAILLE+6*(DessinPerso.TAILLE_CASE)-5, DessinPerso.TAILLE_CASE+5, DessinPerso.TAILLE_CASE+5);
			g.drawRect(CASE_INVENTAIRE3+5, Labyrinthe.TAILLE+6*(DessinPerso.TAILLE_CASE)-5, DessinPerso.TAILLE_CASE+5, DessinPerso.TAILLE_CASE+5);  
			
			//dessine les objets dans l'inventaire
			for (int i = 0; i<this.inventaire.size();i++) {
				this.inventaire.get(i).dessinerInventaire(g,i);
			}
    	}catch(FileNotFoundException e){
    		e.getStackTrace();
    	}catch(IOException f) {
    		f.getStackTrace();
	}
}
    
    /**
     * permet de rammasser un objet
     * @param o, objet a ramasser
     */
    public void ramasserObjet(Objet o) {
        	o.setPersonnage(this);
        	this.inventaire.add(o);
    }
    
    /**
     * permet de recuperer l'inventaire
     * @return l'inventaire
     */
    public ArrayList<Objet> getInventaire(){
    	return this.inventaire;
    }

    /**
     *  permet au personnage de se deplacer
     * @param c, commande jouer par l'ultilisateur
     * @param j, jeu en cours
     */
	public void seDeplacer(Commande c, ArrayList<Case> libres) {
		if (c.gauche)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x-1 && cas.getY() == this.y) {
					this.x--;
					if (this.x < 0) {
						this.x = 0;
					}
					break;
				}
			}
			
		}

		if (c.droite)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x+1 && cas.getY() == this.y) {
					this.x++;
					if (this.x >100) {
						this.x = 100;
					}
					break;
				}
			}
		}

		if (c.haut)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x && cas.getY() == this.y-1) {
					this.y--;
					if (this.y < 0) {
						this.x = 0;
					}
					break;
				}
			}
		}

		if (c.bas)
		{
			for(Case cas : libres) {
				if(cas.getX() == this.x && cas.getY() == this.y+1) {
					this.y++;
					if (this.x >100) {
						this.x = 100;
					}
					break;
				}
			}	
		}

	}
}
