package monitorlock;

public class ConsumeTask implements Runnable{
    private SharedResource sharedResource;
    public ConsumeTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("consumer Thread: " + Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
