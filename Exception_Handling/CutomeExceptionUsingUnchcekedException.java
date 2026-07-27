/*extends RuntimeException
        ↓
Unchecked
        ↓
throw exception
        ↓
catch optional
throws optional*/



class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class UncheckedExceptionExample {

    public static void checkAge(int age) {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
