import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        Predicate < Integer > isEven = num - > (num % 2 == 0);
        boolean result = isEven.test(8);
        System.out.println(result);
    }
}
