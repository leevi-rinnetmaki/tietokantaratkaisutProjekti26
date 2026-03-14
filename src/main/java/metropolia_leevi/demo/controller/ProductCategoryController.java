package metropolia_leevi.demo.controller;
import metropolia_leevi.demo.dto.ProductCategoryDto;
import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.repository.ProductCategoryRepository;
import metropolia_leevi.demo.entity.ProductCategory;
import metropolia_leevi.demo.service.ProductCategoryService;
import metropolia_leevi.demo.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/productcategories")
public class ProductCategoryController {

    private final ProductCategoryService service;
    public ProductCategoryController(ProductCategoryService service) {
        this.service = service;
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ProductCategoryDto> getProductsById(@PathVariable Integer id) {

        return service.getProductCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductCategoryDto>> getAll() {
        List<ProductCategoryDto> categories = service.findAllCategories();
        return ResponseEntity.ok(categories);
    }
}