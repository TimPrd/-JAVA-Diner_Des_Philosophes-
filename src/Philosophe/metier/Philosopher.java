package Philosophe.metier;

import java.util.Random;

/**
 * @author Timothé Pardieu - INFO2 - A1
 */
public class Philosopher extends Thread
{

    //Temps max et min pour manger
    private static final int MIN_EATING_TIME = 200;
    private static final int MAX_EATING_TIME = 400;

    private Chopstick leftChopstick     ;
    private Chopstick rightChopstick    ;

    private String    name              ;
    private Random    random            ;

    private boolean    isEating         ;
    private int        id               ;

    /**
     * Classe philosophe
     * @param id permet de reconnaitre le philosophe en fonction de son id
     * @param rightChopstick désigne la baguette de droite du philosophe
     * @param leftChopstick  désigne la baguette de gauche du philosophe
     * @param name           désigne son nom (inspiré des vrai disciples !)
     */
    public Philosopher(int id, Chopstick rightChopstick , Chopstick leftChopstick, String name)
    {
        this.id               = id;
        this.rightChopstick   = rightChopstick;
        this.leftChopstick    = leftChopstick;
        this.name             = name;
        //On déclare qu'au début aucun ne mange
        this.isEating         = false;
        //Permet d'avoir un nombre au hasard
        this.random           = new Random(System.currentTimeMillis());

    }

    /**
     * @return si le philosophe mange ou non
     */
    public boolean isEating() {return this.isEating;}

    /**
     * @return le nom du philosophe
     */
    public String getIdentity() {
        return name;
    }

    /**
     * Run pour le thread
     */
    public void run() {
        //Boucle infinie
        while (true)
        {
                try
                {
                    synchronized (this) {
                        //Si les deux baguettes sont disponibles...
                        if (this.leftChopstick.isAvailable() != 0 && this.rightChopstick.isAvailable() != 0)
                        {
                            System.out.println("BAGUETTE GAUCHE DE " + this.getIdentity() + this.leftChopstick.isAvailable());
                            System.out.println("BAGUETTE DROITE DE " + this.getIdentity() + this.rightChopstick.isAvailable());

                            String msg;
                            msg = leftChopstick.takeChopstick(this.id);
                            msg = msg+rightChopstick.takeChopstick(this.id);
                            //On affiche dans la console la baguette de droite et gauche avec l'id du philosophe
                            System.out.println(msg);

                            //On passe alors le boolean a vrai car il mange
                            isEating=true;
                            //On le notifie
                            System.out.println(this.getIdentity() + " mange");
                            //On attend un nombre au hasard de secondes
                            Thread.sleep(random.nextInt(MAX_EATING_TIME - MIN_EATING_TIME) + MIN_EATING_TIME);

                            System.out.println(this.getIdentity() + " a fini");
                            //On dépose les les baguettes
                            this.rightChopstick.dropChopstick(this.id);
                            this.leftChopstick.dropChopstick(this.id);
                            //il ne mange plus
                            this.isEating = false;

                        }
                    }
                }


                catch (InterruptedException ie){}


        }

    }



}

