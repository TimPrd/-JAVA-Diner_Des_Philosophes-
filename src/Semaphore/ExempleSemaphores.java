package Semaphore;

/**
 * Created by pt150881 on 06/02/17.
 */
public class ExempleSemaphores {

    public ExempleSemaphores() {
        Telephone t1 = new Telephone(1);
        Telephone t2 = new Telephone(2);
        Equipe    eq1= new Equipe(1,t1,t2);
        Equipe    eq2= new Equipe(2,t1,t2);
        eq1.start();
        eq2.start();
    }

    public static void main(String[] args) {
        new ExempleSemaphores();
    }
}
