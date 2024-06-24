package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ShareResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public ShareResource(int bufferSize) {
        this.bufferSize = bufferSize;
        this.sharedBuffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        // If the buffer is full, wait for consumer to consume items.
        while(sharedBuffer.size() == bufferSize){
            System.out.println(Thread.currentThread().getName()+" buffer is full, producer is waiting for consumer");
            wait();
        }
        this.sharedBuffer.add(item);
        System.out.println("Produced: "+item);
        // notify the consumers that there are resources to consume now.
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while(sharedBuffer.isEmpty()){
            System.out.println(Thread.currentThread().getName()+" buffer is empty, consumer is waiting for Producer");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed: "+item);
        // notify the producer that there is space in the buffer now.
        notify();
        return item;
    }
}
