/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doranco.ecole.vue;

import fr.doranco.ecole.vue.swingPerso.ArrowIcon;
import fr.doranco.ecole.vue.swingPerso.RoundedCornerBorder;
import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Boule
 */
public class FenetreEcoleClient extends JFrame {

    private static final long serialVersionUID = 592122383425979710L;

    private JTextField fieldNom;
    private JTextField fieldPrenom;
    private JTextField fieldAge;
    private JTextField fieldTel;
    private JTextField fieldRue;
    private JTextField fieldVille;
    private JTextField fieldCP;

    JButton boutonAjouter;
    JButton boutonFermer;

    public FenetreEcoleClient() {
        super();
        build();
        buildContentPane();

    }

    private void build() {
        // On initialise notre fenêtre
        setTitle("Creation d'un étudiant ou un enseignant"); // On donne un titre à l'application
        setSize(1500, 700); // On donne une taille à notre fenêtre
        setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
        setResizable(true); // On autorise le redimensionnement de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix
        //setBounds(100, 100, 700, 300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultLookAndFeelDecorated(true);
        setLocationRelativeTo(null);
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.orange);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        //Spécialités
        final JLabel labelSpe = new JLabel("Specialité :");
        labelSpe.setBounds(160, 18, 66, 16);
        contentPane.add(labelSpe);

        Object[] itemsSpecialite = new Object[]{"Informatique", "Physique", "Histoire", "Sociologie"};
        JComboBox<String> comboBoxSpe = new JComboBox(itemsSpecialite);
        comboBoxSpe.setBounds(160, 38, 110, 28);
        comboBoxSpe.setSelectedIndex(0);
        comboBoxSpe.setVisible(true);
        comboBoxSpe.setRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 6648696811787552105L;

            @Override
            public void paint(Graphics g) {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });
        contentPane.add(comboBoxSpe);
        comboBoxSpe.setBorder(new RoundedCornerBorder(20));
        comboBoxSpe.setBackground(Color.WHITE);
        comboBoxSpe.setUI(new WindowsComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton(new ArrowIcon(Color.BLACK, Color.BLUE));
                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                b.setBorder(BorderFactory.createEmptyBorder());
                return b;
            }
        });

        //Groupe quand professeur
        Object[] itemsPoste = new Object[]{"Maître.sse de conférence", "Ingénieur.e", "Docteur.e", "Professeur.e"};
        JComboBox<String> comboBoxPoste = new JComboBox(itemsPoste);
        comboBoxPoste.setBounds(160, 38, 200, 28);
        comboBoxPoste.setSelectedIndex(0);
        comboBoxPoste.setVisible(false);
        contentPane.add(comboBoxPoste);
        comboBoxPoste.setBackground(Color.WHITE);
        comboBoxPoste.setRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 6648696811787552105L;

            @Override
            public void paint(Graphics g) {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });
        comboBoxPoste.setBorder(new RoundedCornerBorder(20));
        comboBoxPoste.setUI(new WindowsComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton(new ArrowIcon(Color.BLACK, Color.BLUE));
                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                b.setBorder(BorderFactory.createEmptyBorder());
                return b;
            }
        });

        //Catégories
        JLabel labelCategorie = new JLabel("Catégorie :");
        labelCategorie.setBounds(24, 18, 66, 16);
        contentPane.add(labelCategorie);

        String[] itemsCat = {"Etudiant", "Enseignant"};
        JComboBox<String> comboBoxCategorie = new JComboBox(itemsCat);
        comboBoxCategorie.setBounds(24, 38, 119, 28);
        comboBoxCategorie.setSelectedIndex(0);
        comboBoxCategorie.setBackground(Color.WHITE);
        comboBoxCategorie.setRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 6648696811787552105L;

            @Override
            public void paint(Graphics g) {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });
        comboBoxCategorie.setBorder(new RoundedCornerBorder(20));
        comboBoxCategorie.setUI(new WindowsComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton(new ArrowIcon(Color.BLACK, Color.BLUE));
                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                b.setBorder(BorderFactory.createEmptyBorder());
                return b;
            }
        });
        contentPane.add(comboBoxCategorie);

        //Sections
        final JLabel labelSection = new JLabel("Section :");
        labelSection.setBounds(286, 18, 66, 16);
        contentPane.add(labelSection);

        Object[] itemsSection = new Object[]{"Master", "Doctorat"};
        JComboBox<String> comboBoxSection = new JComboBox(itemsSection);
        comboBoxSection.setBounds(286, 38, 80, 28);
        comboBoxSection.setSelectedIndex(0);
        comboBoxSection.setBackground(Color.WHITE);
        comboBoxSection.setRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 6648696811787552105L;

            @Override
            public void paint(Graphics g) {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });
        contentPane.add(comboBoxSection);
        comboBoxSection.setBorder(new RoundedCornerBorder(20));
        comboBoxSection.setUI(new WindowsComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton(new ArrowIcon(Color.BLACK, Color.BLUE));
                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                b.setBorder(BorderFactory.createEmptyBorder());
                return b;
            }
        });

        //Groupes
        final JLabel labelGroupe = new JLabel("Groupe :");
        labelGroupe.setBounds(386, 18, 66, 16);
        contentPane.add(labelGroupe);

        Object[] itemsGroupe = new Object[]{"Groupe A", "Groupe B", "Groupe C", "Groupe D"};
        JComboBox<String> comboBoxGroupe = new JComboBox(itemsGroupe);
        comboBoxGroupe.setBounds(386, 38, 119, 28);
        comboBoxGroupe.setSelectedIndex(0);
        comboBoxGroupe.setBackground(Color.WHITE);
        comboBoxGroupe.setRenderer(new DefaultListCellRenderer() {
            private static final long serialVersionUID = 6648696811787552105L;

            @Override
            public void paint(Graphics g) {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                super.paint(g);
            }
        });

        contentPane.add(comboBoxGroupe);
        comboBoxGroupe.setBorder(new RoundedCornerBorder(20));
        comboBoxGroupe.setUI(new WindowsComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = new JButton(new ArrowIcon(Color.BLACK, Color.BLUE));
                b.setContentAreaFilled(false);
                b.setFocusPainted(false);
                b.setBorder(BorderFactory.createEmptyBorder());
                return b;
            }
        });

        ActionListener cbActionListener = (ActionEvent e) -> {
            JComboBox<String> comboBoxCategorie1 = (JComboBox) e.getSource();
            int choix = comboBoxCategorie1.getSelectedIndex();
            switch (choix) {
                case 0:
                    labelSpe.setText("Spécialité");
                    comboBoxPoste.setVisible(false);
                    comboBoxSpe.setVisible(true);
                    comboBoxGroupe.setVisible(true);
                    comboBoxSection.setVisible(true);
                    labelSection.setVisible(true);
                    labelGroupe.setVisible(true);
                    break;

                case 1:
                    labelSpe.setText("Poste :");
                    comboBoxPoste.setVisible(true);
                    comboBoxSpe.setVisible(false);
                    comboBoxGroupe.setVisible(false);
                    comboBoxSection.setVisible(false);
                    labelSection.setVisible(false);
                    labelGroupe.setVisible(false);
                    break;
            }
        };
        comboBoxCategorie.addActionListener(cbActionListener);

        //Mes fields pour remplir tout
        //Nom
        JLabel labelNom = new JLabel("Nom :");
        labelNom.setBounds(20, 80, 66, 16);
        contentPane.add(labelNom);

        fieldNom = new JTextField();
        fieldNom.setColumns(4);
        fieldNom.setBorder(new RoundedCornerBorder(20));
        //setBounds(x,y,largeur,hauteur)
        fieldNom.setBounds(20, 100, 100, 28);
        fieldNom.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldNom);

        //Prénom
        JLabel labelPrenom = new JLabel("Prénom :");
        labelPrenom.setBounds(135, 80, 66, 16);
        contentPane.add(labelPrenom);

        fieldPrenom = new JTextField();
        fieldPrenom.setColumns(4);
        fieldPrenom.setBorder(new RoundedCornerBorder(20));
        fieldPrenom.setBounds(135, 100, 100, 28);
        fieldPrenom.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldPrenom);

        //Âge
        JLabel labelAge = new JLabel("Âge :");
        labelAge.setBounds(250, 80, 66, 16);
        contentPane.add(labelAge);

        fieldAge = new JTextField();
        fieldAge.setColumns(4);
        fieldAge.setBorder(new RoundedCornerBorder(20));
        fieldAge.setBounds(250, 100, 30, 28);
        fieldAge.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldAge);

        //Téléphone
        JLabel labelTelephone = new JLabel("Téléphone :");
        labelTelephone.setBounds(300, 80, 66, 16);
        contentPane.add(labelTelephone);

        fieldTel = new JTextField();
        fieldTel.setColumns(4);
        fieldTel.setBorder(new RoundedCornerBorder(20));
        fieldTel.setBounds(300, 100, 100, 28);
        fieldTel.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldTel);

        //Adresse rue
        JLabel labelrue = new JLabel("Adresse :");
        labelrue.setBounds(20, 132, 66, 16);
        contentPane.add(labelrue);

        fieldRue = new JTextField();
        fieldRue.setColumns(4);
        fieldRue.setBorder(new RoundedCornerBorder(20));
        fieldRue.setBounds(20, 152, 170, 28);
        fieldRue.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldRue);

        //Ville
        JLabel labelVille = new JLabel("Ville :");
        labelVille.setBounds(205, 132, 66, 16);
        contentPane.add(labelVille);

        fieldVille = new JTextField();
        fieldVille.setColumns(4);
        fieldVille.setBorder(new RoundedCornerBorder(20));
        fieldVille.setBounds(205, 152, 120, 28);
        fieldVille.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldVille);

        //Code Postal
        JLabel labelCP = new JLabel("Code Postal :");
        labelCP.setBounds(340, 132, 86, 16);
        contentPane.add(labelCP);

        fieldCP = new JTextField();
        fieldCP.setColumns(4);
        fieldCP.setBorder(new RoundedCornerBorder(20));
        fieldCP.setBounds(340, 152, 120, 28);
        fieldCP.setFont(new Font("Calibri", Font.LAYOUT_RIGHT_TO_LEFT, 15));
        contentPane.add(fieldCP);

        //Bouton ajouter (add étudiant/enseignant)
        boutonAjouter = new JButton("Ajouter");
        boutonAjouter.setBounds(20, 200, 170, 28);
        boutonAjouter.setBorder(new RoundedCornerBorder(20));
        contentPane.add(boutonAjouter);

        boutonFermer = new JButton("Fermer l'application");
        boutonFermer.setBounds(1320, 18, 150, 28);
        boutonFermer.setBorder(new RoundedCornerBorder(20));
        boutonFermer.setForeground(Color.red);
        boutonFermer.addActionListener((ActionEvent e) -> {
            //call another method in the same class which will close this Jframe
            int result = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr.e de vouloir quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                closeFrame();
            }
        });
        contentPane.add(boutonFermer);

        return contentPane;
    }

    public void closeFrame() {
        super.dispose();
    }

    public JTextField getFieldNom() {
        return fieldNom;
    }

    public void setFieldNom(JTextField fieldNom) {
        this.fieldNom = fieldNom;
    }

    public JTextField getFieldPrenom() {
        return fieldPrenom;
    }

    public void setFieldPrenom(JTextField fieldPrenom) {
        this.fieldPrenom = fieldPrenom;
    }

    public JTextField getFieldAge() {
        return fieldAge;
    }

    public void setFieldAge(JTextField fieldAge) {
        this.fieldAge = fieldAge;
    }

    public JTextField getFieldTel() {
        return fieldTel;
    }

    public void setFieldTel(JTextField fieldTel) {
        this.fieldTel = fieldTel;
    }

    public JTextField getFieldRue() {
        return fieldRue;
    }

    public void setFieldRue(JTextField fieldRue) {
        this.fieldRue = fieldRue;
    }

    public JTextField getFieldVille() {
        return fieldVille;
    }

    public void setFieldVille(JTextField fieldVille) {
        this.fieldVille = fieldVille;
    }

    public JTextField getFieldCP() {
        return fieldCP;
    }

    public void setFieldCP(JTextField fieldCP) {
        this.fieldCP = fieldCP;
    }

    public JButton getBoutonAjouter() {
        return boutonAjouter;
    }

    public void setBoutonAjouter(JButton boutonAjouter) {
        this.boutonAjouter = boutonAjouter;
    }

}
