package metropolia_leevi.demo.repository;
import org.springframework.transaction.annotation.Transactional;
import metropolia_leevi.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
        UPDATE Product p
        SET p.price = p.price + 1
    """)
    int increaseAllPricesByOne();
}