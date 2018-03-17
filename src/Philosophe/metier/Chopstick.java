package Philosophe.metier;
import java.util.concurrent.Semaphore;

/**
 * @author Timothé Pardieu - INFO2 - A1
 */


public class Chopstick
{
    int id;
    //Au début on laisse la disponibilité à 1
    private Semaphore available = new Semaphore(1, true);

    /**
     * Classe baguette chinoise
     * @param id permet de reconnaitre la baguette
     */
    public Chopstick(int id)
    {
        this.id=id;
    }

    /**
     * @return si la baguette demandée est disponible
     */
    int isAvailable()
    {
        return this.available.availablePermits();
    }

    /**
     * permet de demander à prendre une baguette
     * @param idP id du philosophe
     * @return un message le notifiant
     * @throws InterruptedException
     */
    public String takeChopstick(int idP) throws InterruptedException {
        System.out.println("Philosophe " + idP + " essaie de prendre la baguette" + id);
        //on décremente de 1 la disponibilité
        available.acquire();
        return catchChopstick(idP);
    }

    /**
     * @param idP id du philosophe
     * @return attraper et de confirmer
     */
    private synchronized String catchChopstick(int idP) {
        return new String("Philosophe " + idP + " a attrapé la baguette : " + id + "\n");
    }


    /**
     * permet de déposer la baguette
     * @param idP id du philosophe
     */
    synchronized void dropChopstick(int idP)
    {
        System.out.println("Philosophe " + idP + " repose la baguette" + id);
        //disponibilité +1
        available.release();
    }

}