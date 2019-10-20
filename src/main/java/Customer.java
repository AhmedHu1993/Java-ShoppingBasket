import java.util.ArrayList;

public class Customer {

    private String name;
    private int purchaseCount;
    private ArrayList<IPurchasing> shoppingBasket;

    public Customer(String name){
        this.name = name;
        this.purchaseCount = 0;
        this.shoppingBasket = new ArrayList<IPurchasing>();
    }

    public String getName() {
        return name;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public ArrayList<IPurchasing> getShoppingBasket() {
        return shoppingBasket;
    }


    public void addToBasket(IPurchasing product) {
        this.shoppingBasket.add(product);
    }

    public void emptyBasket() {
        this.shoppingBasket.clear();
    }

    public void removeFromBasket(IPurchasing product) {
        this.shoppingBasket.remove(product);
    }

    public double totalBasketPrice() {
        ArrayList<Double> prices = new ArrayList<Double>();

        for (IPurchasing product : shoppingBasket) {
            prices.add(product.getPrice());
        }

        double totalPrice = 0;

        for (double price : prices){
            totalPrice += price;
        }

        return totalPrice;
    }
}
