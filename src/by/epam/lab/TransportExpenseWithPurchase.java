package by.epam.lab;

public class TransportExpenseWithPurchase extends AbstractPurchase {
    private Byn transportExpense;

    public TransportExpenseWithPurchase() {
        this(new Product(null, new Byn(0)),0,new Byn(0));
    }
    public TransportExpenseWithPurchase(Byn transportExpense) {
        this.transportExpense = transportExpense;
    }

    public TransportExpenseWithPurchase(Product product, int number, Byn transportExpense) {
        super(product, number);
        this.transportExpense = transportExpense;
    }

    public Byn getTransportExpense() {

        return transportExpense;
    }

    public void setTransportExpense(Byn transportExpense) {
        this.transportExpense = transportExpense;
    }

    @Override
    public Byn getCost() {
        return getProduct().getPrice().mul(getNumber()).add(transportExpense);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpense;
    }

}
