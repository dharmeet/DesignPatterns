package DesignPatterns.Adapter;

public class PhonePeDemo {
    public static void main(String[] args) {
        // Initially, PhonePe was using YesBank's UPI processor
        UpiPaymentProcessor yesBankProcessor = new YesBankUpiProcessor();
        PhonePe phonePe = new PhonePe(yesBankProcessor);
        
        System.out.println("--- Using YesBank Payment Processor ---");
        phonePe.makePayment("user1@ybl", "merchant@ybl", 1000.00);
        
        System.out.println("\n--- RBI Restrictions on YesBank! ---");
        System.out.println("PhonePe needs to switch to a different bank!\n");
        
        // After RBI restrictions, PhonePe switches to ICICI Bank
        // But ICICI has a different API, so we use an adapter
        UpiPaymentProcessor iciciBankAdapter = new IciciBankAdapter();
        phonePe.switchPaymentProcessor(iciciBankAdapter);
        
        System.out.println("--- Using ICICI Bank Payment Processor ---");
        phonePe.makePayment("user1@icici", "merchant@icici", 1000.00);
    }
}