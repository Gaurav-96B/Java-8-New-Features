import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        BiFunction < Integer, Integer, Integer > addition = (a, b) - > a + b;
        int result = addition.apply(20, 40);
        System.out.println(result);
    }
}
