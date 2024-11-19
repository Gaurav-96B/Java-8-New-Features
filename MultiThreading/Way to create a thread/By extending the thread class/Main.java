class MyThread extends Thread{
    public void run(){
        System.out.println("Thread 1 is running using Thread class.");
    }
}

class Main {
    public static void main(String[] args) {
      MyThread thread1=new MyThread();
      thread1.start(); //Started thread and execute run
    }
}
