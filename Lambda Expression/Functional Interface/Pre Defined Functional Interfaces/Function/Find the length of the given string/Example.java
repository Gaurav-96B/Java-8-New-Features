import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        Function < String, Integer > lengthOfString = str - > str.length();
        int result = lengthOfString.apply("saurabh");
        System.out.println(result);
    }
}
