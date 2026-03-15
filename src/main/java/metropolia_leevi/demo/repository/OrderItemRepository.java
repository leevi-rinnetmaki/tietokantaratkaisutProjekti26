package metropolia_leevi.demo.repository;

import metropolia_leevi.demo.entity.OrderItem;
import metropolia_leevi.demo.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> { }