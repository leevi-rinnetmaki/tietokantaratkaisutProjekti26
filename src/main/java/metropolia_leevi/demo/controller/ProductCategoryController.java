package metropolia_leevi.demo.controller;
import metropolia_leevi.demo.repository.ProductCategoryRepository;
import metropolia_leevi.demo.entity.ProductCategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {

    private final ProductCategoryRepository repository;
    public ProductCategoryController(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ProductCategory> getProductsById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(product_categories -> ResponseEntity.ok(product_categories))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<ProductCategory> getAll() {
        return repository.findAll();
    }
}
