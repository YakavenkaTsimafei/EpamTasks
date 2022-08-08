import by.epam.lab.*;

import java.util.Arrays;


public class Runner {
    public static void main(String[] args) {
        Byn cost = new Byn(100);
        final Product PRODUCT = new Product("milk", cost);
        Byn priceDiscount = new Byn(100);
        Byn priceDiscount1 = new Byn(15);
        Byn transportExpense = new Byn(150);
        Byn transportExpense1 = new Byn(20);
        AbstractPurchase[] purchases = {new PriceDiscountPurchase(PRODUCT, 6, priceDiscount),
                new PriceDiscountPurchase(PRODUCT, 4, priceDiscount1),
                new PercentDiscountPurchase(PRODUCT, 6, 15.5),
                new PercentDiscountPurchase(PRODUCT, 4, 15.5),
                new TransportExpenseWithPurchase(PRODUCT, 5, transportExpense),
                new TransportExpenseWithPurchase(PRODUCT, 10, transportExpense1),
        };
        dataOutput(purchases);
        Arrays.sort(purchases);
        System.out.println();
        dataOutput(purchases);
        System.out.println();
        System.out.println("Purchase with min cost :" + purchases[purchases.length - 1].getCost());
        search(purchases, new Byn(500));

    }

    private static void search(AbstractPurchase[] purchases, Byn cost) {
        int index = Arrays.binarySearch(purchases, new PercentDiscountPurchase(new Product("", cost), 1, 0));
        if (index >= 0) {
            System.out.println("Purchase with a cost of 5: " + purchases[index]);
        } else {
            System.out.println("The desired element is not in the array");
        }
    }

    private static void dataOutput(AbstractPurchase[] purchases) {
        for (AbstractPurchase p : purchases) {
            System.out.println(p);
        }
    }
}
