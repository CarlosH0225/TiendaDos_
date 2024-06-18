package model;

public class Sales {

    private String saleDate;
    private int idCustomer;
    private int idProduct;
    private int quantity;
    private double price;
    private double totalSale;
    private int idEmployee;

    public Sales() {
    }

    public Sales(String saleDate, int idCustomer, int idProduct, int quantity, double price, double totalSale, int idEmployee) {
        this.saleDate = saleDate;
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
        this.totalSale = totalSale;
        this.idEmployee = idEmployee;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
}
