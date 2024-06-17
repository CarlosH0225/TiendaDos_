package servicecontroller;

import daocontroller.ClientDao;
import model.Client;
import java.util.Scanner;

public class ClientService {

    Scanner sc = new Scanner(System.in);

    public void registerClient(Client client) {

        System.out.print("Ingrese los datos del cliente: \n");
        System.out.print("ID: ");
        int id = sc.nextInt();
        client.setId(id);
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        client.setName(name);
        System.out.println(name);
        sc.nextLine();
        System.out.print("Apellido: ");
        String lastName = sc.nextLine();
        client.setLast_name(lastName);
        sc.nextLine();
        System.out.print("Celular: ");
        String phone = sc.nextLine();
        client.setPhone(phone);
        sc.nextLine();
        System.out.print("Correo Electronico: ");
        String mail = sc.nextLine();
        client.setMail(mail);
        sc.nextLine();
        System.out.print("Contraseña (debe contener 8 caracteres): ");
        String passwd = sc.nextLine();
        client.setPasswd(passwd);
        sc.nextLine();
        System.out.print("Tipo: ");
        String type = sc.nextLine();
        client.setType(type);

        ClientDao.createClient(client);

    }

    public void showClient() {

        ClientDao.showClient();

    }

    public void deleteClient(int idClient) {

        ClientDao.deleteClient(idClient);

    }

}
