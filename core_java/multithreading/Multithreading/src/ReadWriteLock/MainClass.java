package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public void test() {
        ShareResource resource = new ShareResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread th1 = new Thread(() -> {
            resource.producer(lock);
        });
        Thread th2 = new Thread(() -> {
            resource.producer(lock);
        });

        Thread th3 = new Thread(() -> {
            resource.consumer(lock);
        });
        th1.start();
        th2.start();
        th3.start();
    }


}
