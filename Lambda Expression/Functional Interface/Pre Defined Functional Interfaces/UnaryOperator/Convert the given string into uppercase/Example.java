import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        UnaryOperator < String > lengthOfString = str - > str.toUpperCase();
        String result = lengthOfString.apply("saurabh");
        System.out.println(result);
    }
}
