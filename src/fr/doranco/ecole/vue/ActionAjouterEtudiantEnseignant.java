/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.vue;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Boule
 */
public class ActionAjouterEtudiantEnseignant extends AbstractAction {

    private static final long serialVersionUID = -5059837395447703394L;

    private FenetreEcoleClient fenetre;

    public ActionAjouterEtudiantEnseignant(FenetreEcoleClient fenetre, String texte) {
        super(texte);
        this.fenetre = fenetre;        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
