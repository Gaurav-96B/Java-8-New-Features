class SharedResource{
    int counter=0;
    
    public synchronized void increment(){
        counter++;
    }
    
    public int getCounter(){
        return counter;
    }
}
class Main {
    public static void main(String[] args) {
      SharedResource sharedResource=new SharedResource();
      
      Thread thread1=new Thread(()->{
         for(int i=0;i<10000;i++){
          sharedResource.increment();
      }  
      });
      
      Thread thread2=new Thread(()->{
         for(int i=0;i<10000;i++){
          sharedResource.increment();
      }  
      });
      
      thread1.start();
      thread2.start();
      
      try{
      thread1.join();
      thread2.join();
      }
      catch(Exception e){
        
      }
      
      System.out.println(sharedResource.getCounter());
      
    }
}
