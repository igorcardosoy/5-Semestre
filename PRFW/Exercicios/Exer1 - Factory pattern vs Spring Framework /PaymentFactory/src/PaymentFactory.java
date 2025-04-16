import model.*;

public class PaymentFactory {

    public static PaymentProcessor getPaymentProcessor(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case PaymentMethod.PAYPAL -> new PayPalPayment();
            case PaymentMethod.PIX -> new PixPayment();
            case PaymentMethod.CREDIT_CARD -> new CreditCard();
            case null -> throw new IllegalStateException("Unexpected value");
        };
    }
}
