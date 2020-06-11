/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.rmi.client;

import fr.doranco.ecole.entity.Etudiant;
import fr.doranco.ecole.utils.enums.Specialite;
import fr.doranco.rmi.interfaces.IRmiEtudiant;
import java.rmi.Naming;
import java.util.List;

/**
 *
 * @author Boule
 */
public class Etudiant_client {

    public static void main(String[] args) {
        IRmiEtudiant clientEtudiant;
        try {
            clientEtudiant = (IRmiEtudiant) Naming.lookup("//localhost:4050/Etudiant");
            Etudiant etudiantAAjouter = new Etudiant("Zinédine", "Zidane", Specialite.HISTOIRE.getSpecialite());

            Etudiant etudiantAjoute = clientEtudiant.addEtudiant(etudiantAAjouter);
            System.err.println("L'étudiant ajouté est : " + etudiantAjoute);
            clientEtudiant.removeEtudiant(17);
            List<Etudiant> etud = clientEtudiant.getListeEtudiantBySpecialite(Specialite.HISTOIRE.getSpecialite());
        System.out.println("Boucle");
        for (Etudiant etudiant : etud) {
            System.err.println(etudiant);
        }
        } catch (Exception e) {
            System.err.println("Une erreur est survenue !");
        }

    }

}
