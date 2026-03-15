package metropolia_leevi.demo.controller;

import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String q,
            @RequestParam(required = false) BigDecimal minprice,
            @RequestParam(required = false) BigDecimal maxprice,
            @RequestParam(required = false) String available
    ) {
        Boolean availableFilter = null;
        boolean filterNull = false;

        if (available != null) {
            if (available.equalsIgnoreCase("null")) {
                filterNull = true;
            } else {
                availableFilter = parseAvailableParam(available);
            }
        }

        return service.searchProducts(id, q, minprice, maxprice, availableFilter, filterNull);
    }

    private Boolean parseAvailableParam(String available) {
        switch (available.toLowerCase()) {
            case "true": case "yes": case "y": case "1": return true;
            case "false": case "no": case "n": case "0": return false;
            default: return null;
        }
    }
}