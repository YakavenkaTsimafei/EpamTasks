package by.epam.lab;

import by.epam.lab.bean.PriceDiscountPurchase;
import by.epam.lab.bean.Purchase;
import by.epam.lab.exception.CsvLineException;

import static by.epam.lab.Constants.PURCHASE_FIELDS_NUMBER;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            public Purchase getPurchase(String[] fields) {
                return new Purchase(fields);
            }
        },

        PRICE_DISCOUNT_PURCHASE {
            public Purchase getPurchase(String[] fields) {
                return new PriceDiscountPurchase(fields);
            }
        };

        protected abstract Purchase getPurchase(String[] csvLine);
    }

    private static PurchaseKind getPurchaseKind(int length) {
        return PurchaseKind.values()[length - PURCHASE_FIELDS_NUMBER];
    }

    public static Purchase getPurchase(String fields) throws CsvLineException {
        String[] value = fields.split(Constants.SEPARATOR);
        try {

            return getPurchaseKind(value.length).getPurchase(value);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            throw new CsvLineException(fields, e);

        }
    }
}
