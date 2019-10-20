import java.util.ArrayList;
import java.util.Collections;

public class Customer {

    private String name;
    private int purchaseCount;
    private ArrayList<IPurchasing> shoppingBasket;
    private double totalBasketPrice;

    public Customer(String name){
        this.name = name;
        this.purchaseCount = 0;
        this.shoppingBasket = new ArrayList<IPurchasing>();
        this.totalBasketPrice = 0;
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
        this.totalBasketPrice += product.getPrice();
    }

    public void emptyBasket() {
        this.shoppingBasket.clear();
        this.totalBasketPrice = 0;
    }

    public void removeFromBasket(IPurchasing product) {
        this.shoppingBasket.remove(product);
        this.totalBasketPrice -= product.getPrice();
    }

    private ArrayList<Double> getPricesArrayList(){

        ArrayList<Double> prices = new ArrayList<Double>();

        for (IPurchasing product : shoppingBasket) {
            prices.add(product.getPrice());
        }

        return prices;
    }

    public double getTotalBasketPrice(){
        return this.totalBasketPrice;
    }

    public double totalPriceAfterBuyOneGetOne() {

        int numberOfProductsToGetItsPrices = (shoppingBasket.size() % 2 == 0) ? shoppingBasket.size() / 2 : (shoppingBasket.size() + 1) / 2;

        ArrayList<Double> prices = getPricesArrayList();
        Collections.sort(prices);

        double pricesAfterDiscountToPay = 0;

        if (numberOfProductsToGetItsPrices % 2 == 0){

            for (int i = prices.size() - 1 ; i > numberOfProductsToGetItsPrices - 1 ; i--){
                pricesAfterDiscountToPay += prices.get(i);
            }

        } else {

            for (int i = prices.size() - 1 ; i >= numberOfProductsToGetItsPrices - 1 ; i--){
                pricesAfterDiscountToPay += prices.get(i);
            }
        }

        return pricesAfterDiscountToPay;
    }

    public void applyTenPercentDiscount() {
        if (totalBasketPrice > 20){
             totalBasketPrice *= 0.9;
        }
    }

    public void completePurchase() {
        this.purchaseCount += 1;
    }

    public void applyLoyalityDiscount() {
        if (this.purchaseCount >= 2){
            totalBasketPrice *= 0.98;
        }
    }

    public void applyAllDiscounts() {
        this.totalBasketPrice = totalPriceAfterBuyOneGetOne();
        applyTenPercentDiscount();
        applyLoyalityDiscount();
    }
}
