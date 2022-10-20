package by.epam.lab;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(String[] fields) {
                return new Purchase(fields);
            }
        },

        PRICE_DISCOUNT_PURCHASE {
            Purchase getPurchase(String[] fields) {
                return new PriceDiscountPurchase(fields);
            }
        };

        abstract Purchase getPurchase(String[] csvLine);
    }

    public static Purchase getPurchaseFromFactory(String fields) {
        String[] value = fields.split(Constants.SEPARATOR);
        PurchaseKind kind = (value.length == Constants.FOUR_NUMBER) ? PurchaseKind.PRICE_DISCOUNT_PURCHASE : PurchaseKind.GENERAL_PURCHASE;
        return kind.getPurchase(value);
    }
}
