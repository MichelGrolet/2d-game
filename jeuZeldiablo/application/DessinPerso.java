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
	private static int TAILLE_CASE = 25;

	/**
	 * lien vers le jeu a afficher
	 */
	private JeuPerso jeu;

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
	 * dessiner un objet consiste a dessiner sur l'image suivante methode
	 * redefinie de Afficheur
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case "PJ":
			crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "MUR":
			crayon.setColor(Color.black);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "SOL":
			crayon.setColor(Color.gray);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "MONSTRE":
			crayon.setColor(Color.red);
			crayon.fillArc(x*TAILLE_CASE, y*TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, 0, 360);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {


		// Dessine les murs
		ArrayList<Case> cases = jeu.getLabyrinthe().getCasesLibres();
		for (Case c : cases) {
			if (c.getLibre()) this.dessinerObjet("SOL", c.getX(), c.getY(), im);
			else this.dessinerObjet("MUR", c.getX(), c.getY(), im);
		}

		// Dessine les monstres
		ArrayList<Monstre> monstres = jeu.getMonstres();
		for (Monstre m : monstres) {
			this.dessinerObjet("MONSTRE", m.getX(), m.getY(), im);
		}

		// Dessine le personnage
		Personnage pj = jeu.getPersonnage();
		this.dessinerObjet("PJ", pj.getX(), pj.getY(), im);
	}
}
