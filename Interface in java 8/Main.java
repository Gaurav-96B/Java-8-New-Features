public class Main {

    public static void main(String[] args) {

        PaymentService service = new CardPayment();

        service.pay(1000);

        service.logTransaction(500);

        boolean valid = PaymentService.isValidAmount(2000);

        System.out.println(valid);

        System.out.println(PaymentService.MIN_AMOUNT);

Output
// Validating payment amount
// Processing card payment: 1000.0
// Logging payment of: 1000.0

// Logging payment of: 500.0

// Validating payment amount
// true

// 1.0
    }
}
