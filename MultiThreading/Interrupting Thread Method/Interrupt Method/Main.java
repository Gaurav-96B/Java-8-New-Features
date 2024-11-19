class MyThread extends Thread{
    public void run() {
       for(int i=0;i<10;i++){
           try{
           System.out.println(i);
           Thread.sleep(1000);
           }
           catch(InterruptedException interruptedException){
               System.out.println(interruptedException);
           }
       }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        
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
        
        //Interrupt the execution of user thread
        thread1.interrupt();
    }
}
