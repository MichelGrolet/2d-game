package application;

import java.awt.*;
import java.util.ArrayList;

public class Fantome extends Monstre {

    /**
     * construit un monstre aux coordonnees donnees en parametre
     *
     * @param x abscisse du monstre
     * @param y ordonnee du monstre
     */
    public Fantome(int x, int y) {
        super(x, y);
        this.pv = 5;
    }

    public ArrayList<Case> deplacementAutour(JeuPerso j) {
        // CasesAutour va contenir les 4 cases autour du fantome.
        ArrayList<Case> casesAutour = new ArrayList<Case>();
        ArrayList<Case> casesEntites = j.getCasesEntites();
        if (this.getX()==0) {
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()+1, this.getY()));
            if (this.getY()==0) {
                casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()+1));
            }
        } else if (this.getX()==Labyrinthe.TAILLE-1) {
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()-1, this.getY()));
            if ( this.getY()==Labyrinthe.TAILLE-1) {
                casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()-1));
            }
        } else {
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()+1, this.getY()));
            casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()+1));
            casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()-1));
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()-1, this.getY()));
        }
        System.out.println("dknnjnnnnnnnnnnnnnnnnnnnnn"+casesAutour.size());
        return casesAutour;
    }

    public void dessiner(Graphics2D g) {
        g.setColor(Color.decode("#847363"));
        g.fillArc(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, 0, 360);
    }
}
