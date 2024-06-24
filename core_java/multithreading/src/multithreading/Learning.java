package multithreading;

public class Learning implements Runnable{
    @Override
    public void run() {
        System.out.println("Learning thread started..."+Thread.currentThread().getName());
    }
}
