package servicecontroller;

import daocontroller.ProductDao;
import model.Product;

import java.util.Scanner;

public class ProductService {

    Scanner scanner = new Scanner(System.in);

    public void createProduct(Product product) {

        System.out.print("Nombre del producto: ");
        String productName = scanner.nextLine();
        product.setProductName(productName);

        System.out.print("Precio: " );
        double price = scanner.nextDouble();
        product.setPrice(price);

        System.out.print("Cantidad: " );
        int quantity = scanner.nextInt();
        product.setQuantity(quantity);

        System.out.print("Elija categoria: " );
        int idCategor = scanner.nextInt();
        product.setIdCategory(idCategor);

        ProductDao.createProduct(product);

    }

    public void showProduct() {

        ProductDao.showProduct();

    }

    public void deleteProduct(int id) {

        ProductDao.deleteProduct(id);

    }
}
