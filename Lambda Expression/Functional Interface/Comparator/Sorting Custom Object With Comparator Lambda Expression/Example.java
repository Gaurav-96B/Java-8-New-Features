import java.util.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class Example {
    public static void main(String[] args) {
        List < Person > people = new ArrayList < > ();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        //Sorting based on the age
        Comparator < Person > ageComparator = (p1, p2) - > p1.getAge() - p2.getAge();
        Collections.sort(people, ageComparator);
        //OR
        // Collections.sort(people,(p1, p2) -> p1.getAge()-p2.getAge());       


        //Sorting based on the name
        Comparator < Person > nameComparator = (p1, p2) - > p1.getName().compareTo(p2.getName());
        Collections.sort(people, nameComparator);
        // OR
        // Collections.sort(people,(p1, p2) -> p1.getName().compareTo(p2.getName()));

        for (Person person: people) {
            System.out.println(person);
        }
    }
}
