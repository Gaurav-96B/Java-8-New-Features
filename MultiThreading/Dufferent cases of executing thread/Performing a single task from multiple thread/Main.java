class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Printing number: " + i);
            try {
                Thread.sleep(500); // Simulate a delay of 500ms between prints
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
      
        MyThread thread1 = new MyThread();
        thread1.start(); // Start the thread and execute the task
      
        MyThread thread2=new MyThread();
        thread2.start();
    }
}
