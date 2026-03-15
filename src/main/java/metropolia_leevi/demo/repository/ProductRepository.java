package metropolia_leevi.demo.repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import metropolia_leevi.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("""
        UPDATE Product p
        SET p.price = p.price + 1
    """)
    int increaseAllPricesByOne();

    @Query("""
        SELECT p FROM Product p
        WHERE
        (:search IS NULL OR
        LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) OR
        LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%')))
        """)
    List<Product> searchByText(@Param("search") String search);

}