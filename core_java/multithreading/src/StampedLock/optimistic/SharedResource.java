package StampedLock.optimistic;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void produce(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("taken optimistic lock");
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("updated a value successfully");
            }else{
                System.out.println("failed to update a value, rolling back");
                a=10;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void consume(){
        long stamp = lock.writeLock();
        System.out.println("write lock acquired by: " + Thread.currentThread().getName());
        try{
            System.out.println("performing consume...");
            a=9;
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}
