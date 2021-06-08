package application;

import java.util.ArrayList;

public class Fantome extends Monstre {

    private static int vitesse = 1;
    private static int puissance = 1;
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

    public ArrayList<Case> DeplacementAutour(ArrayList<Case> libres) {
        ArrayList<Case> bonneCase = new ArrayList<Case>();
        for(int i =0; i<j.getCasesLibres().size(); i++) {
            //si le x d'une case libre + ou - 1 est egal a x XOR le y d'une case + ou - 1 est egal a y (on recupere les cases a gauche, droite, haut, bas sans les diagonales)
            if(((j.getCasesLibres().get(i).getX()+1 == this.x ||
                    j.getCasesLibres().get(i).getX()-1 == this.x)
                    && j.getCasesLibres().get(i).getY() == this.y)||
                    (( j.getCasesLibres().get(i).getY()+1 == this.y ||
                            j.getCasesLibres().get(i).getY()-1 == this.y ) &&
                            j.getCasesLibres().get(i).getX() == this.x)) {

                bonneCase.add(j.getCasesLibres().get(i));
            }
        }
        return bonneCase;
    }
}
