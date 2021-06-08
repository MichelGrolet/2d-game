package application;

/**
* Classe representant du sol
* herite de Case
*/
public class Sol extends Case{
    protected boolean active;

    /**
    * Constructeur d'une case de sol
    * @param x coordonnee x de la case
    * @param y coordonnee y de la case
    */
    public Sol(int x,int y){
        super(x,y);
        
        //Instancie a libre
        this.libre=true;

        //Instancie a non activable
        this.active=false;
    }

    /**
    * Permet de declencher l'effet et passe la case en inactivable
    * @param joueur le joueur qui subit l'effet
    */   
    public void declencherEffet(Personnage joueur){
        //Aucun effet
    }

    /**
    * Retourne si la case est activable ou non
    * @return un booleen
    */
    public boolean getActive(){
        return this.active;
    }
}