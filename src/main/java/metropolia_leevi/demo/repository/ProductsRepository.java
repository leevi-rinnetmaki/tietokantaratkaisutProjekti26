package metropolia_leevi.demo.repository;
import org.springframework.transaction.annotation.Transactional;
import metropolia_leevi.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Products, Integer>{
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
        UPDATE Products p
        SET p.price = p.price + 1
    """)
    int increaseAllPricesByOne();
}