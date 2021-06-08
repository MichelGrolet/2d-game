package application;

/**
* Classe abstraite representant une case speciale(piege,boost,etc...)
*/
public abstract class CasePiege extends CaseSpeciale{
    private static final int DEGATS=4;

    /**
    * Constructeur heritant de celui de CaseSpeciale
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public CasePiege(int x,int y){
        super(x,y);
    }

    /**
    * Permet de declencher l'effet et passe la case en inactivable
    * @param joueur le joueur qui subit l'effet
    */   
    public void declencherEffet(Personnage joueur){
        //Si la case est activable, on active l'effet de la classe et on desactive la case
        if(active){
            effet(joueur);
            this.active=true;
        }
    }

    /**
    * Reduit les points de vie du joueur s'il marche dessus
    * @param joueur le joueur qui subit l'effet
    */
    public void effet(Personnage joueur){
        joueur.subirDegats(DEGATS);
    }

    /**
    * Dessine la case
    * @param g Graphics2D
    */
    public void dessiner(Graphics2D g) {
        if(this.getActive()){
            g.setColor(Color.WHITE);
            g.fillRect(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE);
        }
        else{
            g.setColor(Color.GRAY);
            g.fillRect(x * DessinPerso.TAILLE_CASE, y * DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE, DessinPerso.TAILLE_CASE);
        }
    }
}