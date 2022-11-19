import by.epam.lab.bean.*;

public class Runner {
    public static void main(String[] args) {
        PurchaseUtils p1 = new PurchaseUtils(new Purchase(new Product("Milk", new Byn(1.7)), 20));
        p1.printPurchase();
        p1.printCost();
        PurchaseUtils p2 = new PurchaseUtils(new Purchase(new Product("Sugar", new Byn(3)), 12.5));
        p2.printPurchase();
        p2.printCost();
        p2.printCostDiff(p1.getPurchase());
        PurchaseUtils p3 = new PurchaseUtils(new Purchase(new DiscountProduct("Sugar", new Byn(2.8), new Byn(0.1)), 60));
        PurchaseUtils p4 = new PurchaseUtils(new Purchase(new Service("Gym", new Byn(7560), 5), 2.25));
        p4.printPurchase();
        p4.printCost();
        Purchase[] purchases = {p1.getPurchase(), p3.getPurchase(), p4.getPurchase()};
        p2.printEqual(purchases);
    }
}
