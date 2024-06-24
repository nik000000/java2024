package producer_consumer;

public class ProducerConsumer {
    public void test(){
        ShareResource sharedBuffer = new ShareResource(3);
        Thread producerThread = new Thread(()->{
            try{
                for(int i = 0;i < 10;i++){
                    sharedBuffer.produce(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(()->{
            try{
                for(int i = 0;i < 10;i++){
                    sharedBuffer.consume();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
