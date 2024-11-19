class MyThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Yash");
        System.out.println(Thread.currentThread().getName());
        System.out.println("User thread is providing service to main thread");
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(7);
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().isAlive());
    }
}
class Main {
    public static void main(String[] args)  {
        
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
        
    }
}
