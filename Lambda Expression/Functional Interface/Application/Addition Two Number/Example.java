@FunctionalInterface
interface Addition {
    int add(int a, int b);
}

public class Example {
    public static void main(String[] args) {

        Addition addition = (a, b) - > (a + b);
        int result = addition.add(10, 20);
        System.out.println(result);

    }
}
