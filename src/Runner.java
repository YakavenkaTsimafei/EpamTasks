import by.epam.lab.Sale;
import by.epam.lab.bean.*;

public class Runner {
    public static void main(String[] args) {
        Purchase<Sale, Number> p1 = new Purchase<>(new Product("Milk", new Byn(170)), 20);
        PurchaseUtils<Sale, Number> pu1 = new PurchaseUtils<>(p1);
        System.out.println(pu1.printPurchase());
        System.out.println(pu1.printCost());
        Purchase<Sale, Number> p2 = new Purchase<>(new Product("Sugar", new Byn(300)), 12.5);
        PurchaseUtils<Sale, Number> pu2 = new PurchaseUtils<>(p2);
        System.out.println(pu2.printCost());
        pu2.printCostDiff(p1);
        Purchase<Sale, Number> p3 = new Purchase<>(new DiscountProduct("Sugar", new Byn(280), new Byn(10)), 60);
        PurchaseUtils<Service, Double> pu4 = new PurchaseUtils<>(new Purchase<>(new Service("Gym", new Byn(7560), 5), 2.25));
        Purchase<Service, Double> p4 = pu4.getPurchase();
        Service service = pu4.getPurchase().getProduct();
        System.out.println(service);
        System.out.println(pu4.printCost());
        pu2.printEqual(p1, p3, p4);
    }
}
