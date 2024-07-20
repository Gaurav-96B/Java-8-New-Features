import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        BiConsumer < Integer, Integer > printSum = (a, b) - > System.out.println("Sum Of Two Number" + " " + a + b);
        printSum.accept(4, 6);
    }
}
