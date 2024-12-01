import java.util.*;
final class Student{
    private final int id;
    private final String name;
    private final List<String>hobbies;
    
    public Student(int id, String name,List<String>hobbies){
        this.id=id;
        this.name=name;
        this.hobbies=new ArrayList<>(hobbies);
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
       return name; 
    }
    
    public List<String> getHobbies(){
        return new ArrayList<>(hobbies);
    }
    
    public String toString(){
        return this.id+" "+this.name+" "+this.hobbies;
    }
    
}
class Main {
    public static void main(String[] args) {
        List<String>hobbies=Arrays.asList("Swimming","Tennis");
        Student student=new Student(1,"yash",hobbies);
        System.out.println(student);
  
    }
}
