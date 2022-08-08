package by.epam.lab;

public class TransportExpenseWithPurchase extends AbstractPurchase {
    private Byn transportExpense;

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.add(transportExpense);
    }

    public TransportExpenseWithPurchase() {
        transportExpense = new Byn();
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
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpense;
    }

}
