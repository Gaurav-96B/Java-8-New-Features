class CardPayment implements PaymentService {

    @Override
    public void pay(double amount) {

        if (!PaymentService.isValidAmount(amount)) {
            System.out.println("Payment amount is invalid");
            return;
        }

        System.out.println("Processing card payment: " + amount);

        logTransaction(amount);
    }
}

