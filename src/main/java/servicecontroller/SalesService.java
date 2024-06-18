package servicecontroller;

import daocontroller.SalesDao;
import model.Sales;
import utilities.CalculateTotalSale;
import java.util.Scanner;

public class SalesService {

    Scanner sc = new Scanner(System.in);
    CalculateTotalSale calculateTotalSale = null;

    public void registerSales(Sales sales) {

        System.out.print("Ingrese los datos para registrar la venta: \n");
        System.out.print("Fecha en el formato YYYY-MM-DD: ");
        String date = sc.next();
        sales.setSaleDate(date);
        System.out.print("ID Cliente: ");
        int idClient = sc.nextInt();
        sales.setIdCustomer(idClient);
        System.out.print("ID Producto: ");
        int idProduct = sc.nextInt();
        sales.setIdProduct(idProduct);
        System.out.print("Cantidad: ");
        int qty = sc.nextInt();
        sales.setQuantity(qty);
        System.out.print("Precio: ");
        double price = sc.nextDouble();
        sales.setPrice(price);
        System.out.print("Total venta: ");
        calculateTotalSale = new CalculateTotalSale();
        System.out.println(calculateTotalSale.calculateTotalSale(qty, price));
        double totalSale = calculateTotalSale.calculateTotalSale(qty, price);
        sales.setTotalSale(totalSale);
        System.out.print("ID Empleado: ");
        int idEmployee = sc.nextInt();
        sales.setIdEmployee(idEmployee);

        SalesDao.registerSales(sales);

    }


}
