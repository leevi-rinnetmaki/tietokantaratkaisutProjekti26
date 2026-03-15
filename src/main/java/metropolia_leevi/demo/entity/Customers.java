package metropolia_leevi.demo.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
/*
@Entity
public class Customers {

    @Id
    int id;
    String firstName;
    String lastName;
    String email;
    String phone;
    @OneToOne(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    CustomerProfile customerProfile;
    @ManyToMany
    @JoinTable(
            name = "customer_group_link",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    Set<CustomerGroup> customerGroups = new HashSet<>();


    public Customers(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public Set<CustomerGroup> getCustomerGroups() {
        return customerGroups;
    }

    public void setCustomerGroups(Set<CustomerGroup> customerGroups) {
        this.customerGroups = customerGroups;
    }
}
*/