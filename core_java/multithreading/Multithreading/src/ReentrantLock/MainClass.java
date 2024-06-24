package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    SharedResource resource1 = new SharedResource();
    SharedResource resource2 = new SharedResource();
    ReentrantLock lock = new ReentrantLock();
    public void test(){
        Thread th1 = new Thread(() -> {
            resource1.producer(lock);
        });

        Thread th2 = new Thread(() -> {
            resource2.producer(lock);
        });

        th1.start();
        th2.start();
    }
}
