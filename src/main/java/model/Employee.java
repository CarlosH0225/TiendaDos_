package model;

public class Employee extends User {

    private String position;

    public Employee() {
    }

    public Employee(int id, String name, String last_name, String phone, String mail, String passwd, String position) {
        super(id, name, last_name, phone, mail, passwd);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
