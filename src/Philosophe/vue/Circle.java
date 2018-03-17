package Philosophe.vue;

import Philosophe.metier.Philosopher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Timothé Pardieu - INFO2 - A1
 */

public class Circle extends JPanel{
    //variables pour la table
    private static final int SIZE = 256;
    private int a = SIZE / 2;
    private int b = a;
    private int r = 4 * SIZE / 5;

    //variables pour les philosophes
    private int nbElem;
    private int nbPhilo;

    private Image image         = new ImageIcon("images/rsz_confucius.jpg").getImage();
    private Image imageBaguette = new ImageIcon("images/baguette.jpg").getImage();

    private Color colorTable = new Color(167, 103, 38);

    //toutes ces arraylist permettent de stocker en fonction du nombre de philosophes voulu
    ArrayList<JLabel>      alNames = new ArrayList<JLabel>(); //Les noms des philosophes
    ArrayList<JLabel>      alMiam  = new ArrayList<JLabel>(); //Le mot "miam miam"
    ArrayList<JLabel>      alSleep = new ArrayList<JLabel>(); //Le mot "ZzzZzzZ"

    ArrayList<Philosopher> alPhilo   ; //stock les philosophes

    /**
     * Permet de dessiner la table, les philosophes etc
     * @param alPhilo la liste des philosophes
     * @param nbElem  le nombre d'elements à afficher autour de la table (baguette + philosophes)
     * @param nbPhilo le nombre de philosophes
     * @throws IOException
     */
    public Circle(ArrayList<Philosopher> alPhilo,int nbElem, int nbPhilo) throws IOException
    {
        this.nbElem = nbElem;
        this.nbPhilo= nbPhilo;
        this.alPhilo = alPhilo;

        //On parcours autant de fois le nombre de philosophes
        for (int i= 0; i<nbPhilo ; i++)
        {
            //on ajoute dans la liste des noms le nom du philosophe a la position i
            alNames.add(new JLabel(alPhilo.get(i).getIdentity()));
            //on ne l'affiche pas au départ
            alNames.get(i).setVisible(false);

            //de meme pour miam
            alMiam.add(new JLabel("Miam Miam.."));
            alMiam.get(i).setForeground(Color.green);
            alMiam.get(i).setVisible(false);

            //de meme pour zzzzZz
            alSleep.add(new JLabel("zzZzZzZZz"));
            alSleep.get(i).setForeground(Color.red);
            alSleep.get(i).setVisible(false);

            add(alNames.get(i));
            add(alMiam. get(i));
            add(alSleep.get(i));
        }

        revalidate();

    }



    //permet de dessiner la table et les elements autour
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        a = getWidth() / 2;
        b = getHeight() / 2;
        int min = Math.min(a, b);
        r = 4 * min / 5;
        int r2 = Math.abs(min - r) / 2;

        //On dessine la table ( un rond puis on le rempli)
        g2d.setColor(colorTable);
        g2d.drawOval(a - r, b - r, 2 * r, 2 * r);
        g2d.fillOval(a - r, b - r, 2 * r, 2 * r);

        //ensuite on ajoute tout autour

        // Le cpt permet de différencier entre les baguette et les philosophes
        int cpt = 0;
        //On fait cela pour tout les élèments (exemple pour 5 philosophes il y aura 10 objets)
        for (int i = 1; i < nbElem +1; i++)
        {

            //Permet de connaitre les coordonnées
            double t = 2 * Math.PI * i / nbElem;

            int x = (int) Math.round(a + r * Math.cos(t));
            int y = (int) Math.round(b + r * Math.sin(t));

            //Tout les 1/2 on dessine la baguette
            if (i%2==0)
                g2d.drawImage(imageBaguette, x - r2, y - r2, null);

            //Sinon on dessine le philosophe
            else
            {
                //On dessine l'image du philosophe avec son nom apparant
                g2d.drawImage(image, x - r2, y - r2, null);
                alNames.get(cpt).setVisible(true);
                // puis on le place a la distination calculé avant (x,y) avec un décalage
                alNames.get(cpt).setLocation(x-r2,y-(r2-2));

                //Si le philosophe mange
                if( alPhilo.get(cpt).isEating())
                {
                    //alors on enlève le ZzzzZZ et on affiche le "Miam miam" a la bonne position avec un léger décalage vers le haut
                    alSleep.get(cpt).setVisible(false);
                    alMiam.get(cpt).setVisible(true);
                    alMiam.get(cpt).setLocation(x-r2,(y-r2)-30);
                    //On met a jour
                    this.revalidate();

                }

                //Sinon on fait l'inverse on enlève le miam miam et on affiche le ZzzzZZZ
                else
                {
                    alMiam.get(cpt).setVisible(false);
                    alSleep.get(cpt).setVisible(true);
                    alSleep.get(cpt).setLocation(x-r2,(y-r2)-30);
                    //on met a jour
                    this.revalidate();

                }
                //On passe au philosophe suivant
                cpt++;
                //MAJ
                this.revalidate();


            }
        }
        //MAJ
        this.repaint();
    }

}