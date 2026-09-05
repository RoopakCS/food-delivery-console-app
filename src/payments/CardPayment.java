package payments;

public class CardPayment extends Payment{
    @Override 
    public void pay() {
        System.out.println("Paid using Card Payment");
    }
}
