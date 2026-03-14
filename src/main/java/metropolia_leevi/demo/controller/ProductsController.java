package metropolia_leevi.demo.controller;
import metropolia_leevi.demo.dto.ProductCategoryDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService service;
    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ProductDto> getProductsById(@PathVariable Integer id) {

        return service.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> products = service.findAllProducts();
        return ResponseEntity.ok(products);
    }
}