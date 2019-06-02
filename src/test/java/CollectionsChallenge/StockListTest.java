package CollectionsChallenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockListTest {

    private StockList testStockList = new StockList();

    @Test
    void addStock() {
        // When adding new StockItems should return quantity in stock.
        assertEquals(4, testStockList.addStock(new StockItem("Ham", 3.50, 4)));
        // When adding stock to existing StockItems should return new quantity in stock.
        assertEquals(5, testStockList.addStock(new StockItem("Ham", 3.50, 1)));
    }

}