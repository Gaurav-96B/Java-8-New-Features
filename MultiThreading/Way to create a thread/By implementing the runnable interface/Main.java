import java.lang.*;
class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Thread 2 is running using Runnable interface.");
    }
}

class Main {
    public static void main(String[] args) {
      Thread thread2=new Thread(new MyRunnable());
      thread2.start();
    }
}
