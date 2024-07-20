import java.util.*;
import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        Supplier < Integer > generateRandomNumber = () - > new Random().nextInt(100);
        Integer result = generateRandomNumber.get();
        System.out.println(result);
    }
}
