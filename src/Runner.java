import by.epam.lab.bean.*;

public class Runner {
    public static void main(String[] args) {
        Purchase p1 = new Purchase(new Product("Milk", new Byn(170)), 20);
        PurchaseUtils pu1 = new PurchaseUtils(p1);
        pu1.printPurchase();
        pu1.printCost();
        Purchase p2 = new Purchase(new Product("Sugar", new Byn(300)), 12.5);
        PurchaseUtils pu2 = new PurchaseUtils(p2);
        pu2.printPurchase();
        pu2.printCost();
        System.out.println(pu2.printCostDiff(pu1.getPurchase()));
        Purchase p3 = new Purchase(new DiscountProduct("Sugar", new Byn(280), new Byn(10)), 60);
        PurchaseUtils pu4 = new PurchaseUtils(new Purchase(new Service("Gym", new Byn(7560), 5), 2.25));
        Purchase p4 = pu4.getPurchase();
        pu4.printPurchase();
        pu4.printCost();
        Purchase[] purchases = {p1, p3, p4};
        pu2.printEqual(purchases);
    }
}
