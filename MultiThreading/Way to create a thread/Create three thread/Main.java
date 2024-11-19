import java.lang.*;
class MyThread extends Thread{
    public void run(){
        System.out.println("Thread 1 is running using Thread class.");
    }
}
class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Thread 2 is running using Runnable Interface.");
    }
}
class Main {
    public static void main(String[] args) {
      MyThread thread1=new MyThread();
      thread1.start(); 
      
      Thread thread2=new Thread(new MyRunnable());
      thread2.start();
      
      Thread thread3=new Thread(()->{
          System.out.println("Thread 3 is running using Lambda Expression.");
      });
      thread3.start();
    }
}
