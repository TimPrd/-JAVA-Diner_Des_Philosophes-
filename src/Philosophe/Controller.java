package Philosophe;

import Philosophe.metier.Chopstick;
import Philosophe.metier.Philosopher;
import Philosophe.vue.MainWindow;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Timothé Pardieu - INFO2 - A1
 * Afin de respecter les principes vu en MPA le code est en anglais
 */

/**
 * Controller
 * Si vous voulez essayer avec plus de 5 philosophes (ex 15)
 *  décommentez les //, changer les NB_PHILO à 15 et changer le c1 de p5 en c6
 * Cet façon de faire n'est que pour le test. En effet il serait préférable d'afficher
 * un dialogue en demandant le nombre voulu
 */
public class Controller
{
    public static final int NB_PHILO = 5;
    ArrayList<Philosopher> alPhilo   = new ArrayList<Philosopher>();

    public Controller() throws IOException
    {
        //déclaration des baguettes
        Chopstick c1 = new Chopstick(1);
        Chopstick c2 = new Chopstick(2);
        Chopstick c3 = new Chopstick(3);
        Chopstick c4 = new Chopstick(4);
        Chopstick c5 = new Chopstick(5);
        //Chopstick c6 = new Chopstick(6);
        //Chopstick c7 = new Chopstick(7);
        //Chopstick c8 = new Chopstick(8);
        //Chopstick c9 = new Chopstick(9);
        //Chopstick c10 = new Chopstick(10);
        //Chopstick c11 = new Chopstick(11);
        //Chopstick c12 = new Chopstick(12);
        //Chopstick c13 = new Chopstick(13);
        //Chopstick c14 = new Chopstick(14);
        //Chopstick c15 = new Chopstick(15);

        //déclarations des philosophes
        Philosopher p1 = new Philosopher(1, c1, c2, "Yan Yan");
        Philosopher p2 = new Philosopher(2, c2, c3, "Duanmu Ci");
        Philosopher p3 = new Philosopher(3, c3, c4, "Fu Buji");
        Philosopher p4 = new Philosopher(4, c4, c5, "Gongxi Ai");
        //change c1 to c6 if 15 philosophers
        Philosopher p5 = new Philosopher(5, c5, c1, "Zeng Dian");
        //Philosopher p6 = new Philosopher(6, c6, c7, "Zeng Dian");
        //Philosopher p7 = new Philosopher(7, c7, c8, "Zeng Dian");
        //Philosopher p8 = new Philosopher(8, c8, c9, "Yan Yan");
        //Philosopher p9 = new Philosopher(9, c9, c10, "Duanmu Ci");
        //Philosopher p10 = new Philosopher(10, c10, c11, "Fu Buji");
        //Philosopher p11 = new Philosopher(11, c11, c12, "Gongxi Ai");
        //Philosopher p12 = new Philosopher(12, c12, c13, "Zeng Dian");
        //Philosopher p13 = new Philosopher(13, c13, c14, "Zeng Dian");
        //Philosopher p14 = new Philosopher(14, c14, c15, "Zeng Dian");
        //Philosopher p15 = new Philosopher(15, c15, c1, "Zeng Dian");

        //on les ajoute a une arraylist
        alPhilo.add(p1);
        alPhilo.add(p2);
        alPhilo.add(p3);
        alPhilo.add(p4);
        alPhilo.add(p5);
        // alPhilo.add(p6);
        //alPhilo.add(p7);
        //alPhilo.add(p8);
        //alPhilo.add(p9);
        //alPhilo.add(p10);
        //alPhilo.add(p11);
        //alPhilo.add(p12);
        //alPhilo.add(p13);
        //alPhilo.add(p14);
        //alPhilo.add(p15);

        //gère la partie graphique
        new MainWindow(alPhilo);
        //on lance les threads
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
       // p8.start();
       // p9.start();
       // p10.start();
       // p11.start();
       // p12.start();
       // p13.start();
       // p14.start();
       // p15.start();
    }

    public static void main(String[] args) throws IOException
    {
        new Controller();
    }
}
