package multithreading;

public class MonitoLock{
  public synchronized void task1(){
      try{
          System.out.println(Thread.currentThread().getName()+" inside task 1");
          Thread.sleep(10000);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }

  public void task2(){
      System.out.println(Thread.currentThread().getName()+" inside task 2, before synchronized block");
      synchronized (this){
          System.out.println(Thread.currentThread().getName()+" inside task 2, in synchronized block");
      }
  }

  public void task3(){
      System.out.println(Thread.currentThread().getName()+" inside task 3");
  }
}
