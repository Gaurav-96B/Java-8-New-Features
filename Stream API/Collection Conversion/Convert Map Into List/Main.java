import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
      
        // Map to List
        Map<String, Integer> map = Map.of("A", 1, "B", 2);

        // 1. Convert keys to List
        List<String> keys = new ArrayList<>(map.keySet());
        System.out.println("Keys: " + keys);

        // 2. Convert values to List
        List<Integer> values = new ArrayList<>(map.values());
        System.out.println("Values: " + values);

        // 3. Convert entries to List
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        System.out.println("Entries: " + entries);

        // 4. Stream to convert keys
        List<String> keysFromStream = map.keySet().stream().collect(Collectors.toList());
        System.out.println("Keys from Stream: " + keysFromStream);

        // 5. Stream to convert values
        List<Integer> valuesFromStream = map.values().stream().collect(Collectors.toList());
        System.out.println("Values from Stream: " + valuesFromStream);

        // 6. Stream to create key-value pair strings
        List<String> keyValuePairs = map.entrySet()
                                        .stream()
                                        .map(entry -> entry.getKey() + "=" + entry.getValue())
                                        .collect(Collectors.toList());
        System.out.println("Key-Value Pairs: " + keyValuePairs);
    }
}
