public class Product {
    int ID;
    String Product;
    double Price;



    public Product(int ID, String Product, double Price) {
        this.ID = ID;
        this.Product = Product;
        this.Price = Price;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
