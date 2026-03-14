package metropolia_leevi.demo;
import metropolia_leevi.demo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customers, Integer>{
}
