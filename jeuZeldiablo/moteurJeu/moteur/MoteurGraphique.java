package moteurJeu.moteur;


import java.io.*;


/**
 * classe MoteurGraphique represente un moteur de jeu generique. On lui passe un
 * jeu et un afficheur et il permet d'executer un jeu.
 * <p>
 * Cette classe contient la boucle de jeu qui fait des appels reguliers
 * <ul>
 * <li>evoluer de jeu en charge de mettre a jour les donnees du jeu
 * <li>dessiner de dessinjeu en charge de dessiner l'etat du jeu
 * </ul>
 * 
 * @author vthomas
 */
public class MoteurGraphique {

	/**
	 * le jeu a executer
	 */
	private Jeu jeu;

	/**
	 * l'interface graphique
	 */
	private InterfaceGraphique gui;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private DessinJeu dessin;

	/**
	 * construit un moteur
	 * 
	 * @param pJeu
	 *            jeu a lancer
	 * @param pAffiche
	 *            afficheur a utiliser
	 */
	public MoteurGraphique(Jeu pJeu, DessinJeu pAffiche) {
		// creation du jeu
		this.jeu = pJeu;
		this.dessin = pAffiche;
	}

	/**
	 * permet de lancer le jeu
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */

	public void lancerJeu(int width, int height) throws InterruptedException, FileNotFoundException, ClassNotFoundException, IOException {


		// creation de l'interface graphique
		this.gui = new InterfaceGraphique(this.dessin, width, height);
		Controleur controle = this.gui.getControleur();

		// boucle de jeu
		while (!this.jeu.etreFini()) {
			// demande controle utilisateur
			Commande c = controle.getCommande();
			// fait evoluer le jeu
			this.jeu.evoluer(c);
			// affiche le jeu
			this.gui.dessiner();
			// met en attente
			Thread.sleep(100);
		}
	}

}
