
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // List to Set
        List<String> list = Arrays.asList("A", "B", "C", "A");

        // 1. Using HashSet
        Set<String> hashSet = new HashSet<>(list);
        System.out.println("HashSet: " + hashSet);

        // 2. Using Collectors.toSet()
        Set<String> setFromStream = list.stream().collect(Collectors.toSet());
        System.out.println("Set from Stream: " + setFromStream);

        // 3. Using Collectors.toCollection()
        Set<String> linkedHashSet = list.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("LinkedHashSet: " + linkedHashSet);

    }
}
