import model.CreditCard;
import model.PaymentMethod;
import service.PaymentService;

//public class Main {
//    public static void main(String[] args) {
//
//        PaymentService paymentService = new PaymentService(PaymentFactory.getPaymentProcessor(PaymentMethod.PIX));
//        paymentService.pay(100);
//
//        paymentService = new PaymentService(PaymentFactory.getPaymentProcessor(PaymentMethod.CREDIT_CARD));
//        paymentService.pay(100);
//
//        paymentService = new PaymentService(PaymentFactory.getPaymentProcessor(PaymentMethod.PAYPAL));
//        paymentService.pay(100);
//    }
//}

public class Main {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(PaymentFactory.getPaymentProcessor(PaymentMethod.CREDIT_CARD));
        paymentService.pay(100);
    }

}