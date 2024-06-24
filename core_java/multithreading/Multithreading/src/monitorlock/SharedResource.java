package monitorlock;

public class SharedResource {
    boolean itemAvailable = false;
    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println(Thread.currentThread().getName() + ": Adding new item");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("consume item method invoked: ");
        while(!itemAvailable){
            try{
                System.out.println(Thread.currentThread().getName() + ": Waiting for item to be consumed");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
