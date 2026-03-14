package metropolia_leevi.demo.controller;
import metropolia_leevi.demo.ProductsRepository;
import metropolia_leevi.demo.entity.Products;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/product")
public class ProductsController {

    private final ProductsRepository repository;
    public ProductsController(ProductsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(products -> ResponseEntity.ok(products))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        return repository.findById(id)
                .map(product -> {
                    repository.delete(product);
                    return ResponseEntity.ok("deleting cascade");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/increaseallpricesbyone")
    public String increaseAll() {
        int count = repository.increaseAllPricesByOne();
        return count + " products updated";
    }
}