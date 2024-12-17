import java.util.*;
class Student implements Comparable<Student>{
    String name;
    int age;
    int salary;
    
    public Student(String name,int age,int salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setSalary(){
        this.salary=salary;
    }
    
    public int getSalary(){
        return salary;
    }
    
    public String toString(){
        return this.name+" "+this.age+" "+this.salary;
    }
    
    public int compareTo(Student s1){
        return this.getAge()-s1.getAge();
    }
}

class Main {
    public static void main(String[] args) {
         List<Student>listOfStudent=Arrays.asList(
          new Student("Saurav",24,10),
      new Student("Yash",26,9),
      new Student("Anurag",27,6));
      
      //Sort the list using Comparable's natural order
      Collections.sort(listOfStudent);
      listOfStudent.forEach(System.out::println);
    }
}
