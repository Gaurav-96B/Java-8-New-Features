interface PaymentService {

    // public static final constant
    double MIN_AMOUNT = 1.0;


    // Abstract method
    void pay(double amount);


    // Default method
    default void logTransaction(double amount) {

        validateForLogging(amount);

        System.out.println("Logging payment of: " + amount);
    }


    // Static method
    static boolean isValidAmount(double amount) {

        printValidationMessage();

        return amount >= MIN_AMOUNT;
    }


    // Private method
    private void validateForLogging(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }


    // Private static method
    private static void printValidationMessage() {

        System.out.println("Validating payment amount");
    }
}
