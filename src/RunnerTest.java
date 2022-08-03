import by.epam.lab.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RunnerTest {
    @Test
    public void TestToStringPriceDiscountPurchase() {
        Byn cost = new Byn(100);
        Byn priceDiscount = new Byn(50);
        Product product = new Product("milk", cost);
        AbstractPurchase purchase = new PriceDiscountPurchase(product, 4, priceDiscount);
        AbstractPurchase purchase1 = new PriceDiscountPurchase();
        assertEquals("PriceDiscountPurchase;milk;1.00;4;0.50;2.00", purchase.toString());
        assertEquals("PriceDiscountPurchase;null;0.00;0;0.00;0.00", purchase1.toString());
    }

    @Test
    public void TestToStringPercentDiscountPurchase() {
        Byn cost = new Byn(100);
        Product product = new Product("milk", cost);
        AbstractPurchase purchase = new PercentDiscountPurchase(product, 8, 15.5);
        AbstractPurchase purchase1 = new PercentDiscountPurchase();
        assertEquals("PercentDiscountPurchase;milk;1.00;8;15.5;6.00", purchase.toString());
        assertEquals("PercentDiscountPurchase;null;0.00;0;0.0;0.00", purchase1.toString());
    }

    @Test
    public void TestToStringTransportExpenseWithPurchase() {
        Byn cost = new Byn(100);
        Product product = new Product("milk", cost);
        Byn transportExpense = new Byn(150);
        AbstractPurchase purchase = new TransportExpenseWithPurchase(product, 5, transportExpense);
        AbstractPurchase purchase1 = new TransportExpenseWithPurchase();
        assertEquals("TransportExpenseWithPurchase;milk;1.00;5;1.50;6.00", purchase.toString());
        assertEquals("TransportExpenseWithPurchase;null;0.00;0;0.00;0.00", purchase1.toString());

    }

    @Test
    public void testToStringByn() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(1, 23);
        Byn byn2 = new Byn();
        Byn byn3 = new Byn(1234567);
        Byn byn4 = new Byn(123, 45);
        assertEquals("1.23", byn.toString());
        assertEquals("1.23", byn1.toString());
        assertEquals("0.00", byn2.toString());
        assertEquals("12345.67", byn3.toString());
        assertEquals("123.45", byn4.toString());
    }

    @Test
    public void testToStringProduct() {
        Byn byn = new Byn(123);
        Product product = new Product("Milk", byn);
        Product product1 = new Product();
        assertEquals("Milk;1.23", product.toString());
        assertEquals("null;0.00", product1.toString());
    }

    @Test
    public void testCompareTo() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(122);
        Byn byn2 = new Byn(100);
        assertEquals(1, byn.compareTo(byn1));
        assertNotEquals(12, byn2.compareTo(byn));
        assertNotEquals(12, byn2.compareTo(byn1));
    }

    @Test
    public void testGetCostPriceDiscountPurchase() {
        Byn cost = new Byn(100);
        Byn priceDiscount = new Byn(15);
        Byn toCheck = new Byn(300);
        Product product = new Product("milk", cost);
        AbstractPurchase purchase = new PriceDiscountPurchase(product, 4, priceDiscount);
        assertEquals(toCheck, purchase.getCost());
        assertNotEquals(cost, purchase.getCost());
    }

    @Test
    public void testGetCostPercentDiscountPurchase() {
        Byn cost = new Byn(100);
        Product product = new Product("milk", cost);
        Byn toCheck = new Byn(600);
        Byn toCheck1 = new Byn(400);
        AbstractPurchase purchase = new PercentDiscountPurchase(product, 8, 15.5);
        AbstractPurchase purchase1 = new PercentDiscountPurchase(product, 4, 15.5);
        assertEquals(toCheck, purchase.getCost());
        assertEquals(toCheck1, purchase1.getCost());
        assertNotEquals(toCheck1, purchase.getCost());
    }

    @Test
    public void TestTGetCostTransportExpenseWithPurchase() {
        Byn cost = new Byn(100);
        Product product = new Product("milk", cost);
        Byn transportExpense = new Byn(150);
        Byn toCheck = new Byn(600);
        AbstractPurchase purchase = new TransportExpenseWithPurchase(product, 5, transportExpense);
        assertEquals(toCheck, purchase.getCost());
        assertNotEquals(cost, purchase.getCost());
    }

    @Test
    public void TestBynCompareTo() {
        Byn byn = new Byn(100);
        Byn byn1 = new Byn(150);
        assertEquals(50, byn1.compareTo(byn));
        assertNotEquals(-50, byn1.compareTo(byn));
    }

    @Test
    public void TestAdd() {
        Byn byn = new Byn(100);
        Byn byn1 = new Byn(150);
        Byn toCheck = new Byn(250);
        assertEquals(toCheck, byn.add(byn1));
        assertNotEquals(byn, toCheck.add(byn1));
    }

    @Test
    public void TestMul() {
        Byn byn = new Byn(100);
        Byn toCheck = new Byn(500);
        assertEquals(toCheck, byn.mul(5));
        assertNotEquals(toCheck, byn.mul(4));
    }

    @Test
    public void TestMulDouble() {
        Byn byn = new Byn(100);
        Byn toCheck = new Byn(80);
        Byn toCheck1 = new Byn(84);
        assertEquals(toCheck, byn.mul((100 - 15.5) / 100, RoundMethod.FLOOR, 1));
        assertNotEquals(toCheck1, byn.mul((100 - 15.5) / 100, RoundMethod.FLOOR, 1));
    }

    @Test
    public void TestSub() {
        Byn byn = new Byn(100);
        Byn byn1 = new Byn(50);
        Byn toCheck = new Byn(50);
        assertEquals(toCheck, byn.sub(byn1));
        assertNotEquals(toCheck, byn.sub(byn));
    }

    @Test
    public void testEqualsByn() {
        Byn byn = new Byn(123);
        Byn byn1 = new Byn(123);
        Byn byn2 = new Byn(3);
        assertEquals(byn, byn1);
        assertNotEquals(byn2, byn);
        assertNotEquals(byn2, byn1);
    }

    @Test
    public void TestBinarySearch() {
        Byn cost = new Byn(100);
        Product product = new Product("milk", cost);
        AbstractPurchase[] purchases = {new PriceDiscountPurchase(product, 6, new Byn(15)),
                new PriceDiscountPurchase(product, 4, new Byn(50)),
                new PercentDiscountPurchase(product, 6, 15.5),
                new PercentDiscountPurchase(product, 4, 15.5),
                new TransportExpenseWithPurchase(product, 5, new Byn(150)),
                new TransportExpenseWithPurchase(product, 10, new Byn((250))),
        };
        Arrays.sort(purchases);
        for (AbstractPurchase p : purchases) {
            System.out.println(p);
        }
        assertEquals(0, search(purchases, new Byn(1200)));
        assertEquals(5, search(purchases, new Byn(200)));
        assertNotEquals(2, search(purchases, new Byn(400)));

    }

    private static int search(AbstractPurchase[] purchases, Byn cost) {
        return Arrays.binarySearch(purchases, new PercentDiscountPurchase(new Product("", cost), 1, 0));
    }
}