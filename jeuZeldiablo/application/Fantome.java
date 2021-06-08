package application;

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

    public ArrayList<Case> DeplacementAutour(JeuPerso j) {
        // CasesAutour va contenir les 4 cases autour du fantome.
        ArrayList<Case> casesAutour = new ArrayList<Case>();
        ArrayList<Case> casesEntites = j.getCasesEntites();
        if (this.getX()==0) {
            casesAutour.add(j.getLabyrinthe().getCase(this.getX()+1, this.getY()+1));
            if (this.getY()==0) {
                casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()));
            } else if (this.getY()==Labyrinthe.TAILLE-1) casesAutour.add(j.getLabyrinthe().getCase(this.getX(), this.getY()-1));
        } else if (this.getY()==Labyrinthe.TAILLE-1) casesAutour.add(j.getLabyrinthe().getCase(this.getX()-1, this.getY()));

        // On enleve de casesAutour les cases contenant des entites
        for (int i = 0; i< casesAutour.size();i++) {
            for(int k = 0; i < casesEntites.size(); i++) {
                if(casesAutour.get(i).getX() == casesEntites.get(k).getX() && casesAutour.get(i).getY()==casesEntites.get(k).getY()) {
                    casesAutour.remove(i);
                }
            }
        }
        return casesAutour;
    }
}
