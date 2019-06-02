package CollectionsChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket testBasket = new Basket("testBasket");
    private final StockItem testStockItem = new StockItem("firstStockItem", 1.00, 10);
    private final StockItem testStockItemTwo = new StockItem("secondStockItem", 1.00, 10);

    @Test
    void addToBasket() {
        assertEquals("{}", this.testBasket.getItems().toString());
        testBasket.addToBasket(testStockItem, 1);
        testBasket.addToBasket(testStockItemTwo, 2);
        assertEquals("[firstStockItem, secondStockItem]", this.testBasket.getItems().keySet().toString());
    }
}