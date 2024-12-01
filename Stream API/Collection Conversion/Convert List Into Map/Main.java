import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // List to Map
        List<String> list = Arrays.asList("A", "B", "C");

        // 1. Using Collectors.toMap()
        Map<String, Integer> map1 = list.stream().collect(Collectors.toMap(item -> item, item -> item.length()));
        System.out.println("Map1: " + map1);

        // 2. Using For loop
        Map<String, Integer> map4 = new HashMap<>();
        for (String item : list) {
            map4.put(item, item.length());
        }
        System.out.println("Map4: " + map4);
    }
}
