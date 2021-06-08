package application;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import moteurJeu.moteur.*;

/**
 * un afficheur graphique associe au JeuTest fourni
 *
 * @author vthomas
 */
public class DessinPerso implements DessinJeu {

	/**
	 * constante pour gerer la taille des cases
	 */
	public static final int TAILLE_CASE = 50;

	/**
	 * lien vers le jeu a afficher
	 */
	private final JeuPerso jeu;

	/**
	 * appelle constructeur parent
	 *
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinPerso(JeuPerso j) {
		this.jeu = j;
	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		// Dessine les murs
		Case[][] cases = jeu.getLabyrinthe().getTabCase();
		for (Case[] ligne : cases) {
			for(Case c : ligne) {
				c.dessiner(crayon);
			}
		}

		// Dessine les monstres
		ArrayList<Monstre> monstres = jeu.getMonstres();
		for (Monstre m : monstres) {
			m.dessiner(crayon);
		}

		// Dessine le personnage
		jeu.getPersonnage().dessiner(crayon);

		// Dessine les cases speciales

	}
}
