package model;

public class User {

    private int id;
    private String name;
    private String last_name;
    private String phone;
    private String mail;
    private String passwd;

    public User() {
    }

    public User(int id, String name, String last_name, String phone, String mail, String passwd) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.mail = mail;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
