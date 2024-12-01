import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
      
        // Queue to List
        Queue<String> queue = new LinkedList<>(Arrays.asList("X", "Y", "Z"));

        // 1. Using ArrayList Constructor
        List<String> list1 = new ArrayList<>(queue);
        System.out.println("List (ArrayList): " + list1);
      
        // 2. Using Streams
        List<String> list3 = queue.stream().collect(Collectors.toList());
        System.out.println("List (Stream): " + list3);

        // 3. Using Iteration
        List<String> list4 = new ArrayList<>();
        for (String item : queue) {
            list4.add(item);
        }
        System.out.println("List (For Loop): " + list4);

        // 4. Using Collectors.toCollection()
        List<String> list5 = queue.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("List (Collectors.toCollection): " + list5);
    }
}
