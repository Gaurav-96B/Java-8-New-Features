import java.util.*;
import java.util.stream.Collectors;
class Student{
    String name;
    int age;
    int salary;
    public Student(String name,int age, int salary){
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
    
    public void setSalary(int salary){
        this.salary=salary;
    }
    
    public int getSalary(){
        return salary;
    }
    
    public String toString(){
        return this.name+" "+this.age+" "+this.salary;
    }
}

class NameComparator implements Comparator<Student>
{
    public int compare(Student s1,Student s2){
       return s1.getName().compareTo(s2.getName());
        
    }
}

class AgeComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1==s2){
            return 0;
        }
        else if(s1.getAge()>s2.getAge()){
            return 1;
        }
        else{
            return -1;
        }
    }
}



class Main {
    public static void main(String[] args) {
      List<Student>listOfStudent=Arrays.asList(
          new Student("Saurav",24,10),
      new Student("Yash",26,9),
      new Student("Anurag",27,6));
      
      //Method1
       Collections.sort(listOfStudent,new NameComparator());
       
       //Method2
       Collections.sort(listOfStudent,(s1,s2)->s1.getName().compareTo(s2.getName()));
       Collections.sort(listOfStudent,(s1,s2)->s1.getAge()-s2.getAge());
       
       //Method3
       Collections.sort(listOfStudent,Comparator.comparing(emp->emp.getName()));
       Collections.sort(listOfStudent,Comparator.comparing(emp->emp.getAge()));
       
       //Method4
       Collections.sort(listOfStudent,Comparator.comparing(Student::getName));
       Collections.sort(listOfStudent,Comparator.comparing(Student::getAge));
       
       //Method1
      listOfStudent.sort(new NameComparator());
      
      //Method2
      listOfStudent.sort((s1,s2)->s1.getName().compareTo(s2.getName()));
      listOfStudent.sort((s1,s2)->s1.getAge()-s2.getAge());
      
      //Method3
      listOfStudent.sort(Comparator.comparing(emp->emp.getName()));
      listOfStudent.sort(Comparator.comparing(emp->emp.getAge()));
      
      //Method4
      listOfStudent.sort(Comparator.comparing(Student::getName));
      listOfStudent.sort(Comparator.comparing(Student::getAge));
      
      //Using Stream
      listOfStudent.stream().sorted(Comparator.comparing(emp->emp.getAge())).forEach(System.out::println);
      
      //Max and min
     //Print the student  
      listOfStudent.stream().max(Comparator.comparing(s1->s1.getAge())).ifPresent(s1->System.out.println(s1));
      //Or
      Student s4=listOfStudent.stream().max(Comparator.comparing(s1->s1.getAge())).get();
      System.out.println(s4);
      
      //Or
      //Print name of the employee who have max salary
      String name=listOfStudent.stream().max(Comparator.comparing(s1->s1.getAge())).map(name1->name1.getName()).get();
      System.out.println(name);
      
    //   //Calculate the average age of employee
    //   int verage=listOfStudent.stream().mapToInt(age->age.getAge()).average().orElse(0);
      
      System.out.println(listOfStudent);
      
       
     
}
}
