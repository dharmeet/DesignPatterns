package DesignPatterns.Adapter;

// Adaptee - ICICI's API with a different interface
public class IciciBankApi {
    
    // Different method signatures from what PhonePe expects
    public String checkUserAccountStatus(String iciciAccountNumber) {
        System.out.println("ICICI: Checking status for account " + iciciAccountNumber);
        return "ACTIVE";
    }
    
    public double fetchAccountBalance(String iciciAccountNumber) {
        System.out.println("ICICI: Retrieving balance for account " + iciciAccountNumber);
        return 5000.00;
    }
    
    public String transferMoney(String sourceIciciAccount, String destinationAccount, 
                               double amountInRupees, String transferMode) {
        System.out.println("ICICI: Transferring ₹" + amountInRupees + 
                " from " + sourceIciciAccount + " to " + destinationAccount + 
                " via " + transferMode);
        return "TXN123456789"; // Transaction ID
    }
}