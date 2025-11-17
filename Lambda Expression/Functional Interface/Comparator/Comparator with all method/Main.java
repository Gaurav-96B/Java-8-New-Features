import java.util.*;
class Student{
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
}

class NameComparator implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}

class AgeComparator implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        if(s1.getAge()>s2.getAge()){
            return 1; //Swap the two object
        }
        else if(s1.getAge()<s2.getAge()){
            return -1; //Do not swap the two object
        }
        else{
            return 0; //Do not swap the two object
        }
    }

        
     //OR
    // @Override
    // public int compare(Student s1,Student s2) {
    //  return  s1.getAge()-s2.getAge();
    }   
        
    //OR
    // @Override
    // public int compare(Student s1,Student s2) {
    //  return Integer.compare(s1.getAge(), s2.getAge());
    //}
}

class Main {
    public static void main(String[] args) {
        List<Student>listOfStudent=Arrays.asList(
          new Student("Saurav",24,10),
      new Student("Yash",26,9),
      new Student("Anurag",27,6));
      
      System.out.println("Sort the student using Method:1");
      listOfStudent.sort(new NameComparator());
      listOfStudent.sort(new AgeComparator());
      listOfStudent.forEach(System.out::println);
      
      System.out.println("Sort the student using Method:2");
      Collections.sort(listOfStudent,new NameComparator());
      Collections.sort(listOfStudent,new AgeComparator());
      listOfStudent.forEach(System.out::println);
      
      
      System.out.println("Sort the student using Method:3");
      Collections.sort(listOfStudent,(s1,s2)->s1.getName().compareTo(s2.getName()));
      Collections.sort(listOfStudent,(s1,s2)->s2.getAge()-s2.getAge());
      listOfStudent.forEach(System.out::println);
      
      System.out.println("Sort the student using Method:4");
      Collections.sort(listOfStudent,Comparator.comparing(student->student.getName()));
      Collections.sort(listOfStudent,Comparator.comparing(student->student.getAge()));
      listOfStudent.forEach(System.out::println);
      
      System.out.println("Sort the student based using Method:5");
      Collections.sort(listOfStudent,Comparator.comparing(Student::getName));
      Collections.sort(listOfStudent,Comparator.comparing(Student::getAge));
      listOfStudent.forEach(System.out::println);
      
      System.out.println("Sort the student using Method:6");
      listOfStudent.stream().sorted(Comparator.comparing(emp->emp.getAge())).forEach(System.out::println);
      listOfStudent.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
      
      
      //thenComparing
      System.out.println("Sort the student based on the name and if name is same then sort it based on the age and if age is same then sort it based on the salary");
      Collections.sort(listOfStudent,Comparator.comparing(Student::getName).thenComparing(Student::getAge).thenComparing(Student::getSalary));
      listOfStudent.forEach(System.out::println);
      
      
      //reversed()
      //Sort by name in reverse order using reversed()
      System.out.println("Sort by name in reverse order ");
      Collections.sort(listOfStudent,Comparator.comparing(Student::getName).reversed());
      listOfStudent.forEach(System.out::println);
      

      //naturalOrder()
      //Sort by name in natural order using naturalOrder()
      System.out.println("Sort by name in naturalOrder ");
      Collections.sort(listOfStudent,Comparator.comparing(Student::getName));
      listOfStudent.forEach(System.out::println);
        
    }
}
