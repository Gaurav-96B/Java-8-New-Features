import java.util.function.*;
public class Example {
    public static void main(String[] args) {
        Consumer < String > printString = name - > System.out.println("This is my name ->  " + name);
        printString.accept("saurabh");
    }
}
