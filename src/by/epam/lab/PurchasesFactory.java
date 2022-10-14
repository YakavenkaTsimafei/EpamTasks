package by.epam.lab;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(String[] strings) {
                return new Purchase(strings);
            }
        },

        PRICE_DISCOUNT_PURCHASE {
            Purchase getPurchase(String[] strings) {
                return new PriceDiscountPurchase(strings);
            }
        };

        abstract Purchase getPurchase(String[] strings);
    }

    public static Purchase getPurchaseFromFactory(String strings) {
        String[] value = strings.split(Constants.SEPARATOR);
        PurchaseKind kind = (value.length == Constants.FOUR_NUMBER) ? PurchaseKind.PRICE_DISCOUNT_PURCHASE : PurchaseKind.GENERAL_PURCHASE;
        return kind.getPurchase(value);
    }
}
