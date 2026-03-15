package metropolia_leevi.demo.repository;

import metropolia_leevi.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("""
    SELECT p FROM Product p
    WHERE
      (:id IS NULL OR p.id = :id)
      AND (:minprice IS NULL OR p.price >= :minprice)
      AND (:maxprice IS NULL OR p.price <= :maxprice)
      AND (
          (:filterNull = true AND p.available IS NULL)
          OR
          (:filterNull = false AND (:available IS NULL OR p.available = :available))
      )
    """)
    List<Product> searchProducts(
            Integer id,
            BigDecimal minprice,
            BigDecimal maxprice,
            Boolean available,
            boolean filterNull
    );

}