public class Product {

    private String name;
    private String description;
    private double price;
    private int rating;

    public Product(String name, String description, double price, int rating){
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}
