package multithreading;

public class LearningClass extends Thread{
    @Override
    public void run() {
        System.out.println("Learning Class..."+ Thread.currentThread().getName());
    }
}
