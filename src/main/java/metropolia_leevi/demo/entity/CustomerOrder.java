package metropolia_leevi.demo.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "customer_orders")
public class CustomerOrder {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal quantityOfOrders;
    private BigDecimal priceOfOrders;

    public CustomerOrder() {}

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

    public BigDecimal getQuantityOfOrders() {
        return quantityOfOrders;
    }

    public void setQuantityOfOrders(BigDecimal quantityOfOrders) {
        this.quantityOfOrders = quantityOfOrders;
    }

    public BigDecimal getPriceOfOrders() {
        return priceOfOrders;
    }

    public void setPriceOfOrders(BigDecimal priceOfOrders) {
        this.priceOfOrders = priceOfOrders;
    }
}
