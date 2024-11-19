class MyThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("DaemonThread");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Dameon thread is providing service to main thread");
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
        System.out.println(Thread.currentThread().isAlive());
        
        //Daemon Thread
        MyThread thread1=new MyThread();
        thread1.setDaemon(true);
        System.out.println(thread1.isDaemon());
        thread1.start();
        
        
    }
}
