import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        BiPredicate < Integer, Integer > isEven = (a, b) - > a % 2 == 0 && b % 2 == 0;
        boolean result = isEven.test(4, 6);
        System.out.println(result);
    }
}
