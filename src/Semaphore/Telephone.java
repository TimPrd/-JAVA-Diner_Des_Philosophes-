package Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by pt150881 on 06/02/17.
 */
public class Telephone {
    int id;
    private Semaphore disponible = new Semaphore(1, true);

    public Telephone(int id)
    {
        this.id=id;
    }

    public String telephoner(int ideq) throws InterruptedException
    {
        System.out.println("Equipe :  " + ideq + " tente  de décrocher le tél");
        disponible.acquire();
        return attrapeTelephone(ideq);
    }

    public synchronized String attrapeTelephone(int ideq) {
        return new String("Equipe " + ideq + " a décroché le tél" + id + "\n");
    }

    public synchronized void raccrocherTelephone(int ideq)
    {
        System.out.println("Equipe " + ideq + " a raccroché le tél" + id);
        disponible.release();
    }

}
