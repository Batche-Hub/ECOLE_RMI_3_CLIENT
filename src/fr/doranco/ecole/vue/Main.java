/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.vue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Boule
 */
public class Main {
    public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
                             
				FenetreEcoleClient fenetre = new FenetreEcoleClient();
				fenetre.setVisible(true);
			}
		});
	}
}
