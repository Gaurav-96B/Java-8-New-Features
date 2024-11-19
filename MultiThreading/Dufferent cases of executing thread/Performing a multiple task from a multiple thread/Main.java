class MultipleTasks {
    public void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task1: Printing number: " + i);
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("Task1 interrupted!");
            }
        }
    }

    public void printGreetings() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task2: Printing Hello");
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("Task2 interrupted!");
            }
        }
    }

    public void printSquares() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task3: Square of " + i + " is: " + (i * i));
            try {
                Thread.sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("Task3 interrupted!");
            }
        }
    }
}

public class SingleThreadMultipleTasks {
    public static void main(String[] args) {
        MultipleTasks tasks = new MultipleTasks();

        // Single thread performing all tasks sequentially
        Thread thread = new Thread(() -> {
            tasks.printNumbers();   // Perform Task 1
            tasks.printGreetings(); // Perform Task 2
            tasks.printSquares();   // Perform Task 3
        });

        thread.start();
    }
}

