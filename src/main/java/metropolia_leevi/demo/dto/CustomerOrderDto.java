package metropolia_leevi.demo.dto;
import java.math.BigDecimal;

public class CustomerOrderDto {

    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal quantityOfOrders;
    private BigDecimal priceOfOrders;

    public CustomerOrderDto(int id, String firstName, String lastName, BigDecimal quantityOfOrders, BigDecimal priceOfOrders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.quantityOfOrders = quantityOfOrders;
        this.priceOfOrders = priceOfOrders;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public BigDecimal getQuantityOfOrders() { return quantityOfOrders; }
    public BigDecimal getPriceOfOrders() { return priceOfOrders; }

}