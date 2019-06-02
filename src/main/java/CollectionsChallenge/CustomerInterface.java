package CollectionsChallenge;

import java.util.Map;

public class CustomerInterface {
    private StockList stockList;

    public CustomerInterface() {
        this.stockList = new StockList();
        stockList.addStock(new StockItem("Bread", 1.00, 50));
        stockList.addStock(new StockItem("Chicken", 3.00, 20));
        stockList.addStock(new StockItem("Twix", 1.50, 10));
        stockList.addStock(new StockItem("Coffee", 4.00, 5));
        stockList.addStock(new StockItem("Fish", 4.00, 100));
        stockList.addStock(new StockItem("RarePepe", 100, 1));
    }

    public int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public void checkout(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.getItems().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
            basket.clearBasket();
        }
    }
}
