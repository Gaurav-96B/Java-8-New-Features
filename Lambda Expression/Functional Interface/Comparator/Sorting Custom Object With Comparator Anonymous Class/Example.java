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

        Comparator < Person > ageComparator = new Comparator < Person > () {

            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getAge() == p2.getAge()) {
                    return 0; //Do not swap the two object
                } else if (p1.getAge() > p2.getAge()) {
                    return 1; //Swap the two object
                } else {
                    return -1; //Do not swap the two object
                }
            }
                            //OR
            // @Override
            // public int compare(Person p1, Person p2) {
            //     return Integer.compare(p1.getAge(), p2.getAge());

            // }

                             //OR
            // @Override
            // public int compare(Person p1, Person p2) {
            //     return  p1.getAge()-p2.getAge();

            // }

        };

        Collections.sort(people, ageComparator);

        for (Person person: people) {
            System.out.println(person);
        }
    }
}
