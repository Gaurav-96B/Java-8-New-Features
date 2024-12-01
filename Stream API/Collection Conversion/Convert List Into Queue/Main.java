import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // List to Queue
        List<String> list = Arrays.asList("A", "B", "C");

        // 1. Using LinkedList Constructor
        Queue<String> queue1 = new PriorityQueue<>(list);
        System.out.println("Queue (LinkedList): " + queue1);

        // 2. Using Collectors.toCollection()
        Queue<String> queue2 = list.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Queue (Stream + Collectors.toCollection): " + queue2);

        // 3. Using For Loop
        Queue<String> queue3 = new LinkedList<>();
        for (String item : list) {
            queue4.add(item);
        }
        System.out.println("Queue (For Loop): " + queue3);
    }
}
