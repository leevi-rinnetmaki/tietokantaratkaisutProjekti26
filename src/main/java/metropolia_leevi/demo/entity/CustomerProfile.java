package metropolia_leevi.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
/*
@Entity
@Table(name = "customerprofile")
public class CustomerProfile {

    @Id
    int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", unique = true, nullable = false)
    @JsonIgnore
    private Customers customers;
    String bio;
    String avatar_url;

    public CustomerProfile(){

    }

    public int getId() {
        return id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
*/