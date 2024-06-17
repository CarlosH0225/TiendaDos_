package model;

public class Client extends User {

    private String type;

    public Client() {
        super();
    }

    public Client(int id, String name, String last_name, String phone, String mail, String passwd, String type) {
        super(id, name, last_name, phone, mail, passwd);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
