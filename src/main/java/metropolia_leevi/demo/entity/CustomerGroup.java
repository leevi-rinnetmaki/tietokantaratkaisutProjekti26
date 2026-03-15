package metropolia_leevi.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
/*
@Entity
@Table(name = "customergroup")
public class CustomerGroup {
    @Id
    int  id;
    String name;
    @ManyToMany(mappedBy = "customerGroups")
    @JsonIgnore
    Set<Customers> customers = new HashSet<>();

    public CustomerGroup() {}

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

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }
}
*/