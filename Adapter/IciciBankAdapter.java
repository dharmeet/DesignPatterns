package DesignPatterns.Adapter;

// Adapter - makes ICICI's API compatible with UpiPaymentProcessor
public class IciciBankAdapter implements UpiPaymentProcessor {
    
    private IciciBankApi iciciBankApi;
    
    public IciciBankAdapter() {
        this.iciciBankApi = new IciciBankApi();
    }
    
    @Override
    public boolean processPayment(String sourceAccountId, String targetAccountId, double amount) {
        // Adapt PhonePe's expected interface to work with ICICI's interface
        String transactionId = iciciBankApi.transferMoney(sourceAccountId, targetAccountId, amount, "UPI");
        // Consider transaction successful if we get a transaction ID
        return transactionId != null && !transactionId.isEmpty();
    }
    
    @Override
    public boolean verifyAccount(String accountId) {
        // Adapt PhonePe's expected verification method to ICICI's method
        String status = iciciBankApi.checkUserAccountStatus(accountId);
        return "ACTIVE".equals(status);
    }
    
    @Override
    public double getBalance(String accountId) {
        // This method signature matches what PhonePe expects
        return iciciBankApi.fetchAccountBalance(accountId);
    }
}