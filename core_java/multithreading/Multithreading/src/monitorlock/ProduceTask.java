package monitorlock;

public class ProduceTask implements Runnable{
    SharedResource sharedResource;
    public ProduceTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        System.out.println("Producer thread started: "+Thread.currentThread().getName());
        try{
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.addItem();
    }
}
