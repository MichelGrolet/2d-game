package moteurJeu.moteur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeEnCours;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private  Commande commandeARetourner;
	
	/**
	 * pour savoir si le joueur est en train d'attaquer
	 */
	private boolean attaque;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {
		if(!attaque) {
		switch (e.getKeyChar()) {
		// si on appuie sur 'q',commande joueur est gauche
		case 'q':
			this.commandeEnCours.gauche = true;
			this.commandeARetourner.gauche = true;
			break;
		// si on appuie sur 'd',commande joueur est droite
		case 'd':
			this.commandeEnCours.droite = true;
			this.commandeARetourner.droite = true;
			break;
		// si on appuie sur 'z',commande joueur est haut
		case 'z':
			this.commandeEnCours.haut = true;
			this.commandeARetourner.haut = true;
			break;
		// si on appuie sur 's',commande joueur est bas
		case 's':
			this.commandeEnCours.bas = true;
			this.commandeARetourner.bas = true;
			break;
		}
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'q':
			this.commandeEnCours.gauche = false;
			break;
		case 'd':
			this.commandeEnCours.droite = false;
			break;
		case 'z':
			this.commandeEnCours.haut = false;
			break;
		case 's':
			this.commandeEnCours.bas = false;
			break;
		}

	}

	@Override
	/**
	 * permet d'attaquer
	 */
	public void keyTyped(KeyEvent e) {
		if(Character.isSpaceChar(e.getKeyChar())) {
			if(!this.attaque) {
			this.attaque = true;
			Timer t = new Timer();
			TimerTask tt1 = new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Controleur.this.commandeEnCours.attaque = true;
					Controleur.this.commandeARetourner.attaque = true;
				}
			};
			TimerTask tt = new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Controleur.this.commandeEnCours.attaque = false;
					Controleur.this.commandeARetourner.attaque = false;
					Controleur.this.attaque = false;
				}
			};
			t.schedule(tt1, 500);
			t.schedule(tt, 600);
			}
		}
		if(e.getKeyChar()=='e') {
			this.commandeEnCours.ramasser = true;
			this.commandeARetourner.ramasser = true;
			Timer nt = new Timer();
			TimerTask ntt = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Controleur.this.commandeEnCours.ramasser = false;
					Controleur.this.commandeARetourner.ramasser = false;
				}
				
			};
			nt.schedule(ntt, 100);
		}
		
	}

}
