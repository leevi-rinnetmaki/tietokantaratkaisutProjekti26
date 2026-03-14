package metropolia_leevi.demo.repository;
import metropolia_leevi.demo.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer>{
}