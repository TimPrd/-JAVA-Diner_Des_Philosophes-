package Philosophe.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import static Philosophe.Controller.NB_PHILO;

/**
 * @author Timothé Pardieu - INFO2 - A1
 */

/**
 * Fenetre qui permet l'affichage
 */
public class MainWindow extends JFrame {

    private double width, height;
    private JLabel label = new JLabel("Les logs sont dans votre invite de commande");

    public MainWindow(ArrayList alPhilo) throws IOException
    {

        super("Philosophers");

        //On définit les tailles pour pouvoir préciser une taille
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //largeur
        this.width = screenSize.getWidth();
        //hauteur
        this.height = screenSize.getHeight();

        //permet de quitter le programme
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };

        //On crée l'objet cercle avec le nombre de philosophes, le nb de couverts etc
        //il permettra de dessiner la table, les philosophes et les baguettes (+ les textes)
        Circle circle = new Circle(alPhilo,NB_PHILO+NB_PHILO, NB_PHILO);

        //Permet de positionner au milieu le text
        label.setHorizontalAlignment(JLabel.CENTER);

        //On ajoute le layout
        this.setLayout(new BorderLayout());
        //Notre cercle se retrouve au milieu
        this.getContentPane().add(circle, BorderLayout.CENTER);
        //le texte en dessous
        this.getContentPane().add(label, BorderLayout.SOUTH);

        //fermeture
        addWindowListener(l);
        //non redimensionnable pour éviter les problèmes d'affichages
        setResizable(false);
        //On met alors la taille à la taille de l'écran (plein écran)
        setSize((int)width,(int)height);


        setVisible(true);
    }



}