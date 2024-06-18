package servicecontroller;

import model.Client;
import model.Employee;
import model.Sales;

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
/*
        System.out.println("Eliga el tipo de usuario: \n 1 - Cliente \n 2 - Empleado ");
        int opc = scanner.nextInt();

        switch (opc) {

            case 1:
                Client customer = new Client();
                ClientService cs = new ClientService();
                //cs.registerClient(customer);
                cs.showClient();

                System.out.print("¿Desea eliminar un cliente? Si(S) o no(N) ");

                String option = scanner.next();

                if (option.contains("S") || option.contains("s")) {
                    System.out.print("Ingrese el item del cliente: ");
                    int id = scanner.nextInt();
                    cs.deleteClient(id);
                }
                break;

            case 2:

                Employee employee = new Employee();
                EmployeeService es = new EmployeeService();
                //es.registerEmployee(employee);
                es.showEmployee();

                System.out.print("¿Desea eliminar un empleado? Si(S) o no(N) ");
                String opt = scanner.next();

                if (opt.contains("S") || opt.contains("s")) {
                    System.out.print("Ingrese el item del empleado: ");
                    int id = scanner.nextInt();
                    es.deleteEmployee(id);
                }

                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }
        */

        Sales sales = new Sales();
        SalesService salesService = new SalesService();
        salesService.registerSales(sales);

    }
}
