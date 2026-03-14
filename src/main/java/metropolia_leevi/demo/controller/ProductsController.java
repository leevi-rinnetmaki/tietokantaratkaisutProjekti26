package metropolia_leevi.demo.controller;
import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
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


    @GetMapping("/findbypricerange")
    public List<ProductDto> searchByPrice(
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice){

        return service.findByPriceRange(minprice, maxprice);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice,
            @RequestParam(required = false) String available
    ) {
        Boolean availableFilter = parseAvailableParam(available);
        boolean filterNull = available != null && available.equalsIgnoreCase("null");
        return service.searchProducts(id, minprice, maxprice, availableFilter, filterNull);
    }

    // Helper to convert browser string → Boolean/null safely
    private Boolean parseAvailableParam(String available) {
        if (available == null) return null; // param omitted → don't filter
        switch (available.toLowerCase()) {
            case "true": case "yes": case "y": case "1": return true;
            case "false": case "no": case "n": case "0": return false;
            case "null": return null; // explicitly filter for null
            default: return null; // invalid → treat as no filter
        }
    }
}