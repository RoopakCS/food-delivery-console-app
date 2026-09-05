package payments;

public class UPIPayment extends Payment {
    @Override 
    public void pay() {
        System.out.println("Paid using UPI Payment");
    }
}
