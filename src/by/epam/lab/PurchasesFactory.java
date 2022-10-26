package by.epam.lab;

import by.epam.lab.bean.PriceDiscountPurchase;
import by.epam.lab.bean.Purchase;
import by.epam.lab.exception.CsvLineException;

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

    public static Purchase getPurchase(String fields) throws CsvLineException {
        String[] value = fields.split(Constants.SEPARATOR);
        try {
            PurchaseKind kind = (value.length == Constants.FOUR_NUMBER) ? PurchaseKind.PRICE_DISCOUNT_PURCHASE : PurchaseKind.GENERAL_PURCHASE;
            return kind.getPurchase(value);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            throw new CsvLineException(fields, e);

        }
    }
}
