package servicecontroller;

import model.Client;
import model.Employee;

import java.util.Scanner;

public class ServiceTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
        Category category = new Category();
        CategoryService cs = new CategoryService();

        cs.createCategory(category);

        cs.selectCategory();

        System.out.println("Ingrese el item de la categoria a eliminar");
        int idCategoria = scanner.nextInt();
        cs.deleteCategory(idCategoria);
        */

        /*
        Product product = new Product();
        ProductService prodServ = new ProductService();

        //prodServ.createProduct(product);
        //prodServ.viewProduct();

        System.out.print("Ingrese el item del producto que desea eliminar: ");
        int item = scanner.nextInt();
        prodServ.deleteProduct(item);
        */

        System.out.println("Eliga el tipo de usuario: \n 1 - Cliente \n 2 - Empleado ");
        int opc = scanner.nextInt();

        if (opc == 1) {

            Client customer = new Client();
            ClientService cs = new ClientService();

            //cs.registerClient(customer);

            cs.showClient();

            System.out.print("Digite por favor el item del cliente a eliminar: " );
            int id = scanner.nextInt();
            cs.deleteClient(id);

        } else if (opc == 2) {

            Employee employee = new Employee();
            EmployeeService es = new EmployeeService();
            es.registerEmployee(employee);

            System.out.println("Escogio la opcion 2");

        }

    }
}
