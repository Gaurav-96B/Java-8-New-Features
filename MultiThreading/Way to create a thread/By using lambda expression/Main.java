class Main {
    public static void main(String[] args) {
      Thread thread3=new Thread(()->{
          System.out.println("Thread 3 is running using Lambda Expression.");
      });
      thread3.start();
    }
}
