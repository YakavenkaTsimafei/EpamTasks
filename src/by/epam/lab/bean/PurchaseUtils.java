package by.epam.lab.bean;

import by.epam.lab.RoundMethod;

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
        if (purchase.getProduct() instanceof DiscountProduct) {
            System.out.println("cost = " + (purchase.getProduct().getPrice()).sub(((DiscountProduct) purchase.getProduct()).getPrice()).mul(purchase.getQuantity(), RoundMethod.FLOOR, 0) + " BYN");
        } else {
            System.out.println("cost = " + (purchase.getProduct().getPrice()).mul(purchase.getQuantity(), RoundMethod.FLOOR, 0) + " BYN");
        }
    }

    public void printCostDiff(Purchase p) {
        System.out.println("xxx diff = " + this.purchase.getCost().sub(p.getCost()) + " BYN");
    }

    public void printЕqual(Purchase p) {
        if (this.purchase.getCost().equals(p.getCost())) {
            System.out.println("Cost equal");
        } else System.out.println("Cost not equal");
    }


}
