package moteurJeu.moteur;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * cree une interface graphique avec son controleur et son afficheur.
 * <p>
 * Cette classe est en charge de reunir et de mettre en relation les differents
 * composants.
 * 
 * @author vthomas
 */
public class InterfaceGraphique {

	/**
	 * le Panel lie a la JFrame
	 */
	private PanelDessin panel;

	/**
	 * le controleur lie a la JFrame
	 */
	private Controleur controleur;

	/**
	 * la construction de l'interface grpahique - construit la JFrame -
	 * construit les Attributs
	 * 
	 * @param afficheurUtil
	 *            l'afficheur a utiliser dans le moteur
	 * 
	 */
	public InterfaceGraphique(DessinJeu afficheurUtil, int x, int y) {
		// creation JFrame
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// creation panel
		this.panel = new PanelDessin(x, y, afficheurUtil);
		f.setContentPane(this.panel);

		// ajout du controleur
		Controleur controlleurGraph = new Controleur();
		this.controleur = controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);

		// recuperation du focus
		f.pack();
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();

		f.setVisible(true);

	}

	/**
	 * retourne le controleur de l'affichage construit
	 * 
	 * @return
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/**
	 * demande la mise a jour du dessin
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public void dessiner() throws FileNotFoundException, ClassNotFoundException, IOException {
		this.panel.dessinerJeu();
	}

}
