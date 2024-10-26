class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}

//Using java 8
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread is running..."));
        thread.start();
    }
}
