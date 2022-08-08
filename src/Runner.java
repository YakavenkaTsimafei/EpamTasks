import by.epam.lab.*;

import java.util.Arrays;


public class Runner {
    public static void main(String[] args) {
        Byn cost = new Byn(100);
        final Product PRODUCT = new Product("milk", cost);
        AbstractPurchase[] purchases = {new PriceDiscountPurchase(PRODUCT, 6, new Byn(100)),
                new PriceDiscountPurchase(PRODUCT, 4, new Byn(15)),
                new PercentDiscountPurchase(PRODUCT, 6, 15.5),
                new PercentDiscountPurchase(PRODUCT, 4, 15.5),
                new TransportExpenseWithPurchase(PRODUCT, 5, new Byn(150)),
                new TransportExpenseWithPurchase(PRODUCT, 10, new Byn(20)),
        };
        dataOutput(purchases);
        Arrays.sort(purchases);
        System.out.println();
        dataOutput(purchases);
        System.out.println();
        System.out.println("Purchase with min cost :" + purchases[purchases.length - 1].getCost());
        int index = search(purchases, new Byn(500));
        if (index >= 0) {
            System.out.println("Purchase index with a cost of 5 : " + index);
        } else {
            System.out.println("The desired index is not in the array");
        }
    }

    public static int search(AbstractPurchase[] purchases, Byn cost) {
        return Arrays.binarySearch(purchases, new PercentDiscountPurchase(new Product("", cost), 1, 0));
    }

    private static void dataOutput(AbstractPurchase[] purchases) {
        for (AbstractPurchase p : purchases) {
            System.out.println(p);
        }
    }
}
