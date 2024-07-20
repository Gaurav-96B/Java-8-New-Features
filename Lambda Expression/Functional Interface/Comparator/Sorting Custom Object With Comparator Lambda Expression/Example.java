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
        Comparator < Person > ageComparator = (p1, p2) - > p1.getAge() - p2.getAge();
        Collections.sort(people, ageComparator);
                         // Or
        // Collections.sort(people,(p1, p2) -> p1.getAge()-p2.getAge());

        for (Person person: people) {
            System.out.println(person);
        }
    }
}
