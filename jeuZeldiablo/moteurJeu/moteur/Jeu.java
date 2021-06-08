package moteurJeu.moteur;

/**
 * interface qui permet de representer un jeu :
 * <li>un jeu est caracterise par la methode evoluer a redefinir.
 * 
 * @author vthomas
 *
 */
public interface Jeu {

	/**
	 * methode qui contient l'evolution du jeu en fonction de la commande
	 * 
	 * @param commandeUser
	 *            commande utilisateur
	 */
	void evoluer(Commande commandeUser) throws InterruptedException;

	/**
	 * @return true si et seulement si le jeu est fini
	 */
	boolean etreFini();
}
