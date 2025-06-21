package entity;

public class ContactNode {
    private String name;
    private String phone;
    public ContactNode next;

    public ContactNode(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Teléfono: " + phone;
    }
}
