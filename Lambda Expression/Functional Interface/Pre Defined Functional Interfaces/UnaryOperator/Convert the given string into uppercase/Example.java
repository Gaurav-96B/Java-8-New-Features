import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        UnaryOperator < String > upperCaseString = str - > str.toUpperCase();
        String result = upperCaseString.apply("saurabh");
        System.out.println(result);
    }
}
