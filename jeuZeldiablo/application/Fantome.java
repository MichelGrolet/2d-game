package application;

import java.awt.*;
import java.util.ArrayList;

public class Fantome extends Monstre {

    private final static int vitesse = 1;
    private final static int puissance = 1;
    private int pv;

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
        // Gestion des cases a gauche et a droite du fantome
        if (this.getX()==1) casesAutour.add(j.getLabyrinthe().getCase(this.getX()+1, this.getY()));
        else if (this.getX()==Labyrinthe.TAILLE-2) casesAutour.add(j.getLabyrinthe().getCase(this.getX()-1, this.getY()));
        else {
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()+1, this.getY()));
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()-1, this.getY()));
        }
        // Gestion des cases au dessus et en dessous du fantome
        if (this.getY()==1) casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()-1));
        else if (this.getY()==Labyrinthe.TAILLE-2) casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()+1));
        else {
            casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()+1));
            casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()-1));
        }
        System.out.println(this.getX()+" "+this.getY()+"dknnjnnnnnnnnnnnnnnnnnnnnn"+casesAutour.size());
        return casesAutour;
    }

    public void dessiner(Graphics2D g) {
        g.setColor(Color.decode("#847363"));
        g.fillArc(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, 0, 360);
    }
}
