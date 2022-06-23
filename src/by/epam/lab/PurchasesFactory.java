package by.epam.lab;

import java.util.Scanner;

public class PurchasesFactory {

    private static enum PurchaseKind {
        GENERAL_PURCHASE, PURCHASE_WITH_A_DISCOUNT, PURCHASE_WITH_A_DISCOUNT_DEPENDING_ON_THE_QUANTITY;
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case PURCHASE_WITH_A_DISCOUNT:
                return new PurchaseWithADiscount(sc);
            case PURCHASE_WITH_A_DISCOUNT_DEPENDING_ON_THE_QUANTITY:
                return new PurchaseWithADiscountDependingOnTheQuantity(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}
