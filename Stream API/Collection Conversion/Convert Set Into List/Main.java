import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Set to List
        Set<String> set = new HashSet<>(Arrays.asList("X", "Y", "Z"));

        // 1. Using ArrayList
        List<String> arrayList = new ArrayList<>(set);
        System.out.println("ArrayList: " + arrayList);

        // 2. Using Collectors.toList()
        List<String> listFromStream = set.stream().collect(Collectors.toList());
        System.out.println("List from Stream: " + listFromStream);

       // 3. Using Collectors.toCollection()
        List<String> listFromStream = set.stream().collect(Collectors.toCollection(ArrayList::new));
    }
}
