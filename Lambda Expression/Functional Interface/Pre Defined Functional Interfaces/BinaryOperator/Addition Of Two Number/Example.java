import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        BinaryOperator < Integer > addition = (a, b) - > a + b;
        int result = addition.apply(4, 6);
        System.out.println(result);
    }
}
