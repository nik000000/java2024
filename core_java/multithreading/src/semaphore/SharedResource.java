package semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = false;
    Semaphore semaphore = new Semaphore(2);
    public void produce() {
        try{
            semaphore.acquire();
            System.out.println("lock acquired by thread " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("lock released by thread " + Thread.currentThread().getName());
            semaphore.release();
        }
    }


}
