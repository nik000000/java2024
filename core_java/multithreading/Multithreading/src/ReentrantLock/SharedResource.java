package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void producer(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("Lock acquired by thread: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
            System.out.println("lock released by thread: " + Thread.currentThread().getName());
        }
    }
}
