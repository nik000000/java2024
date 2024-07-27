package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable = false;
    StampedLock stampedLock = new StampedLock();

    public void produce(){
        long stamp = stampedLock.writeLock();
        try{
            System.out.println("read lock acquired by "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            stampedLock.unlockRead(stamp);
            System.out.println("read lock released by "+ Thread.currentThread().getName());
        }
    }

    public void consume(){
        long stamp = stampedLock.writeLock();
        try{
            System.out.println("write lock acquired by "+ Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("write lock released by "+ Thread.currentThread().getName());
        }
    }
}
