class Task1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Task1: Printing number: " + i);
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted!");
            }
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Task2: Printing Hello");
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted!");
            }
        }
    }
}

class Task3 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Task3: Printing square of " + i + ": " + (i * i));
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create threads for multiple tasks
        Thread thread1 = new Thread(new Task1(), "Thread-1");
        Thread thread2 = new Thread(new Task2(), "Thread-2");
        Thread thread3 = new Thread(new Task3(), "Thread-3");

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

