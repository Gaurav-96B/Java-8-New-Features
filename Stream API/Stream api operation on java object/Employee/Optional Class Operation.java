import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> optionalName = Optional.of("Gaurav");
        Optional<String> emptyName = Optional.empty();

        // 1. ifPresent
        optionalName.ifPresent(System.out::println);

        // 2. isPresent
        if (optionalName.isPresent()) {
            System.out.println("Value exists");
        }

        // isEmpty
        if (emptyName.isEmpty()) {
            System.out.println("Value does not exist");
        }

        // 3. get
        String value = optionalName.get();
        System.out.println(value);

        // 4. orElse
        String value1 = emptyName.orElse("Default Name");
        System.out.println(value1);

        // 5. orElseGet
        String value2 = emptyName.orElseGet(() -> "Generated Default Name");
        System.out.println(value2);

        // 6. orElseThrow
        String value3 = optionalName.orElseThrow(
                () -> new RuntimeException("Name not found")
        );

        System.out.println(value3);
    }
}
