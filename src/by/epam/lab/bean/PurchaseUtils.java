package by.epam.lab.bean;

public class PurchaseUtils {
    private final Purchase purchase;

    public PurchaseUtils() {
        this(null);
    }

    public PurchaseUtils(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {

        System.out.println(purchase.getCost());
    }

    public void printCostDiff(Purchase p) {
        System.out.println("xxx diff = " + this.purchase.getCost().sub(p.getCost()) + " BYN");
    }

    public void printEqual(Purchase[] p) {
        for (Purchase purchase : p) {
            if (this.purchase.getCost().equals(purchase.getCost())) {
                System.out.println("Cost equal");
            } else System.out.println("Cost not equal");

        }

    }


}
