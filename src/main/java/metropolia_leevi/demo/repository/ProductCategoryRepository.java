package metropolia_leevi.demo.repository;
import metropolia_leevi.demo.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
}
