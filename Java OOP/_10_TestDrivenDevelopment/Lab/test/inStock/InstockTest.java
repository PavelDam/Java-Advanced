package lab.inStock;

import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private ProductStock instock;
    private Product product;

    @Before
    public void setUp() {
        this.instock = new Instock();
        this.product = new Product("product", 10.00, 1);
    }

    @Test
    public void testAddInStockShouldContainThatProduct() {
        instock.add(product);
        assertTrue(instock.contains(product));
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsMissing() {
        assertFalse(instock.contains(product));
    }

    @Test
    public void testCountShouldReturnCorrectNumberOfProducts() {
        assertEquals(0, instock.getCount());
        instock.add(product);
        assertEquals(1, instock.getCount());
    }

    @Test
    public void testFindShouldReturnTheCorrectNthProduct() {
        List<Product> products = addMultipleProducts();

        int productIndex = 3;
        Product expected = products.get(productIndex);
        Product actual = instock.find(productIndex);
        assertNotNull(actual);
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithIndexOutOfRangeShouldThrow() {
        List<Product> products = addMultipleProducts();
        instock.find(products.size());
    }

    @Test
    public void testQuantityShouldUpdateTheProductQuantity() {
        instock.add(product);
        int expectedQuantity = product.getQuantity() + 5;
        instock.changeQuantity(product.getLabel(), expectedQuantity);
        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailIfProductWithLabelIsMissing() {
        instock.changeQuantity("missing", 10);
    }

    @Test
    public void testFindByLabelShouldReturnTheProductWithTheSameLabel() {
        addMultipleProducts();
        instock.add(product);

        Product actual = instock.findByLabel(product.getLabel());

        assertNotNull(actual);
        assertEquals(product.getLabel(), actual.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowWhenProductWithLabelIsMissing() {
        instock.findByLabel("missing");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectCountOfProducts() {
        int count = 4;
        addMultipleProducts();
        List<Product> actual = iterableToList(instock.findFirstByAlphabeticalOrder(count));
        assertEquals(count, actual.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheProductsOrderedByLabel() {

        List<Product> products = addMultipleProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());


        int count = 5;

        List<Product> actual = iterableToList(instock.findFirstByAlphabeticalOrder(count));

        for (int i = 0; i < count; i++) {
            String expectedLabel = products.get(i).getLabel();
            String actualLabel = actual.get(i).getLabel();
            assertEquals(expectedLabel, actualLabel);
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenNotEnoughProducts() {
        int size = addMultipleProducts().size();

        List<Product> products = iterableToList(instock.findFirstByAlphabeticalOrder(size + 1));
        assertEquals(0, products.size());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnAllProductsInTheRange() {
        double lowerBand = 35.00;
        double upperBand = 64.00;

        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getPrice() > lowerBand && p.getPrice() <= upperBand)
                .toList();

        List<Product> actual = iterableToList(instock.findAllInRange(lowerBand, upperBand));

        assertEquals(expected.size(), actual.size());

        boolean hasNotOutOfRangePrices = actual.stream().map(Product::getPrice)
                .noneMatch(p -> p <= lowerBand || p > upperBand);
        assertTrue(hasNotOutOfRangePrices);
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnAllProductsInTheRangeSortedInDescendingOrder() {
        double lowerBand = 35.00;
        double upperBand = 64.00;

        List<Product> expected = addMultipleProducts().stream()
                .filter(p -> p.getPrice() > lowerBand && p.getPrice() <= upperBand)
                .sorted(Comparator.comparing(Product::getPrice).reversed()).toList();

        List<Product> actual = iterableToList(instock.findAllInRange(lowerBand, upperBand));

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            double expectedPrice = expected.get(i).getPrice();
            double actualPrice = actual.get(i).getPrice();
            assertEquals(expectedPrice, actualPrice, 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnAllProductsWithGivenPrice() {
        double givenPrice = 35.00;

        List<Product> actual = iterableToList(instock.findAllByPrice(givenPrice));

        for (Product p : actual) {
            assertEquals(givenPrice, p.getPrice(), 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionsWhenNonOfThePriceMatches() {
        addMultipleProducts();
        List<Product> actual = iterableToList(instock.findAllByPrice(-10));
        assertEquals(0, actual.size());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnProductsWithHighestPrice() {
        int numberOfProducts = 4;
        List<Product> expected = addMultipleProducts().stream().limit(numberOfProducts)
                .sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());

        List<Product> actual = iterableToList(instock.findFirstMostExpensiveProducts(numberOfProducts));

        assertEquals(expected.size(), actual.size());

//        assertEquals(expected, actual); ЗА ДА ИЗПОЛЗВАМЕ ТОЗИ МЕТОД ТРЯБВА ИНИЦИАЛИЗИРАМЕ EQUALS МЕТОД

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getLabel(), actual.get(i).getLabel());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowWhenProductsAreLessThanNeeded() {
        int numberOfProducts = addMultipleProducts().size();

        instock.findFirstMostExpensiveProducts(numberOfProducts + 1);
    }

    @Test
    public void testFindAllByQuantityShouldReturnProductsWithGivenQuantity() {
        addMultipleProducts();

        int quantity = 11;
        List<Product> actual = iterableToList(instock.findAllByQuantity(quantity));

        for (Product p : actual) {
            assertEquals(quantity, p.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenThereIsNoProductWithGivenQuantity() {
        addMultipleProducts();

        int quantity = 100;
        List<Product> actual = iterableToList(instock.findAllByQuantity(quantity));

        assertEquals(0, actual.size());
    }

    @Test
    public void testGetIterableShouldReturnAllProductsFromTheStock() {
        List<Product> expected = addMultipleProducts();

        Iterator<Product> iterator = instock.iterator();

        List<Product> actual = new ArrayList<>();

        iterator.forEachRemaining(actual::add);

        assertEquals(expected, actual);
    }


    private List<Product> iterableToList(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private List<Product> addMultipleProducts() {
        List<Product> products = List.of(
                new Product("product_1", 1.00, 1),
                new Product("product_2", 52.00, 4),
                new Product("product_3", 35.00, 12),
                new Product("product_4", 64.00, 14),
                new Product("product_5", 2.00, 18),
                new Product("product_6", 35.00, 11),
                new Product("product_7", 64.00, 11),
                new Product("product_8", 4.00, 14),
                new Product("product_9", 11.00, 111)
        );
        products.forEach(instock::add);
        return products;
    }


}