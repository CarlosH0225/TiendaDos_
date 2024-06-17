package model;

public class Product {

    private String productName;
    private double cost;
    private double price;
    private int quantity;
    private int idCategory;
    private  boolean state;

    public Product() {
    }

    public Product(String productName, double cost, double price, int quantity, int idCategory) {
        this.productName = productName;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
        this.idCategory = idCategory;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
