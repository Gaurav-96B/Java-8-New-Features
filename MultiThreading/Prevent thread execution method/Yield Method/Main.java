class MyThread extends Thread{
    public void run() {
       for(int i=0;i<10;i++){
           System.out.println(i);
       }
    }
}

class Main {
    public static void main(String[] args) {
        
        //Main Thread
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Saurav");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Main thread is running");
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().isAlive());
        
        // User Thread
        MyThread thread1=new MyThread();
        thread1.start();
        
        //Stop the execution of main thread and execute the user thread
        Thread.yield();
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
        
    }
}
