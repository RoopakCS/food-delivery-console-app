package payments;

public class CashPayment extends Payment {
    @Override 
    public void pay() {
        System.out.println("Paid using Cash Payment");
    }
}
