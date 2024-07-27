package semaphore;

public class SemaphoreMain {
    SharedResource sharedResource = new SharedResource();
    public void test(){
        Thread th1 = new Thread(()->{
            sharedResource.produce();
        });

        Thread th2 = new Thread(()->{
            sharedResource.produce();
        });

        Thread th3 = new Thread(()->{
            sharedResource.produce();
        });

        Thread th4 = new Thread(()->{
            sharedResource.produce();
        });

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
