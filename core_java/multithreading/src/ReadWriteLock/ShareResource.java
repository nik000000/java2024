package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class ShareResource {
    boolean isAvailable;
    public void producer(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("read lock acquired by: "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.readLock().unlock();
            System.out.println("read lock released by: "+Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("write lock acquired by: "+Thread.currentThread().getName());
            isAvailable = false;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.writeLock().unlock();
            System.out.println("write lock released by: "+Thread.currentThread().getName());
        }
    }
}
