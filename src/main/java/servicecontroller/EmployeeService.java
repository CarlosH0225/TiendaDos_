package servicecontroller;

import daocontroller.EmployeeDao;
import model.Employee;
import java.util.Scanner;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    public void registerEmployee(Employee employee) {

        System.out.println("Ingrese la informacion del empleado:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        employee.setId(id);
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        employee.setName(name);
        sc.nextLine();
        System.out.print("Apellido: ");
        String lastName = sc.nextLine();
        employee.setLast_name(lastName);
        sc.nextLine();
        System.out.print("Celular: ");
        String cellphone = sc.nextLine();
        employee.setPhone(cellphone);
        sc.nextLine();
        System.out.print("Correo electronico: ");
        String email = sc.nextLine();
        employee.setMail(email);
        sc.nextLine();
        System.out.print("Contraseña: ");
        String passwd = sc.nextLine();
        employee.setPasswd(passwd);
        sc.nextLine();
        System.out.print("Cargo: ");
        String position = sc.nextLine();
        employee.setPosition(position);

        EmployeeDao.createEmployee(employee);

    }
}
