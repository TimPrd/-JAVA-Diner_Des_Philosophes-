package Semaphore;

import org.omg.IOP.TAG_JAVA_CODEBASE;

/**
 * Created by pt150881 on 06/02/17.
 */
public class Equipe extends Thread
{
    int id;
    Telephone t1,t2;

    public Equipe(int id, Telephone t1, Telephone t2) {
        this.id = id;
        this.t1 = t1;
        this.t2 = t2;
    }
    public void run()
    {
        while (true)
        {
            try {
                String msg;
                msg = t1.telephoner(id);
                Thread.sleep((int)(Math.random())*200);
                msg = msg+t2.telephoner(id);
                System.out.println(msg);
                Thread.sleep((int)(Math.random())*200);
                t1.raccrocherTelephone(id);
                t2.raccrocherTelephone(id);
            }
            catch (InterruptedException ie){}
        }
    }
}
