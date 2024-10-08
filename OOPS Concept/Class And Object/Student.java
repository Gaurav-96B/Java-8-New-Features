Method-1:Initialization through reference
----------------
class Student {
    int id;
    String name;
    static String college = "ITS";
}
public class Main {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "Sonoo";
        Student.college = "BBDIT";
        System.out.println(s1.id + " " + s1.name + " " + s1.college);
    }
}
Method-2:Initialization through method
-------------

  class Student {
    int rollno;
    String name;
    static String college = "ITS";
    void insertRecord(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
    void displayInformation() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
public class Main {
    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.insertRecord(111, "Karan");
        Student.college = "BBDIT";
        s1.displayInformation();
    }
}

Method-3:Initialization through a constructor
--------------
  class Student {
    int id;
    String name;
    static String college = "ITS";
    Student(int id, String name) {
        this.id = id;
        this.name = name;

    }
    void display() {
        System.out.println(id + " " + name + " " + college);
    }
}


public class Main {

    public static void main(String args[]) {
        Student s1 = new Student(111, "Karan");
        Student.college = "BBDIT";
        s1.display();
    }
}






