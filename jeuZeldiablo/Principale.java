import java.util.Scanner;

import application.*;
import moteurJeu.moteur.MoteurGraphique;

public class Principale {
	public static void main(String[] args) throws InterruptedException {
		// creation du jeu particulier et de son afficheur
		JeuPerso jeu = new JeuPerso();
		DessinPerso aff = new DessinPerso(jeu);

		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		// lance la boucle de jeu qui tourne jusque la fin du jeu
		moteur.lancerJeu(525, 525);

		// lorsque le jeu est fini
		System.out.println("Fin du Jeu - appuyer sur entree");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.exit(1);
	}
}