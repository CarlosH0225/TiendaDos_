package utilities;

public class CalculateTotalSale {

    private int quantity;
    private double price;
    private double totalSale;

    public CalculateTotalSale() {
    }

    public CalculateTotalSale(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
        this.totalSale = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double calculateTotalSale(int qty, double price) {

        return qty * price;
    }

}
