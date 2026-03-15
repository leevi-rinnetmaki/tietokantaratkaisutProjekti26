package metropolia_leevi.demo.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {

    private Integer orderId;
    private Integer productId;

}