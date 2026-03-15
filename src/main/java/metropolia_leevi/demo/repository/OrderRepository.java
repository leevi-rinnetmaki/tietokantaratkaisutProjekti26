package metropolia_leevi.demo.repository;

import metropolia_leevi.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}