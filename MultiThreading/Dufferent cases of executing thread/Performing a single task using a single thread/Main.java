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
        // Create a thread with a single task
        MyThread thread = new MyThread();
        thread.start(); // Start the thread and execute the task
    }
}
