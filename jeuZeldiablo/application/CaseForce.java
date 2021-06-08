package application;

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
}