import java.io.*;
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Optional, helps in version control
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("John", 30);

        // Serialize the object to a file
        try (
          FileOutputStream fos=new FileOutputStream("person.ser");
          ObjectOutputStream oos = new ObjectOutputStream(fos); {
          oos.writeObject(person);
          System.out.println("Serialization successful: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
