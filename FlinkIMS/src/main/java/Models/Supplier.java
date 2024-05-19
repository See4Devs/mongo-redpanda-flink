package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Supplier {
    private String supplierId;
    private String name;
    private Contact contact;

    public Supplier() {
    }

    public Supplier(String supplierId, String name, Contact contact) {
        this.supplierId = supplierId;
        this.name = name;
        this.contact = contact;
    }

    // Getters and setters...

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                '}';
    }
}
