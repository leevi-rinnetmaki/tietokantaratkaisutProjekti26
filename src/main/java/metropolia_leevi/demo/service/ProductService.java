package metropolia_leevi.demo.service;

import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.entity.Product;
import metropolia_leevi.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDto> searchProducts(
            Integer id,
            String q,
            BigDecimal minprice,
            BigDecimal maxprice,
            Boolean available,
            boolean filterNull
    ) {
        // Step 1: fetch filtered products from DB
        List<Product> products = repository.searchProducts(id, minprice, maxprice, available, filterNull);

        // Step 2: text search on name/description if `q` is provided
        if (q != null && !q.isBlank()) {
            String[] words = q.toLowerCase().trim().split("\\s+");

            products = products.stream()
                    .filter(p -> {
                        String name = p.getName() != null ? p.getName().toLowerCase() : "";
                        String description = p.getDescription() != null ? p.getDescription().toLowerCase() : "";

                        for (String word : words) {
                            if (!(name.contains(word) || description.contains(word))) {
                                return false;
                            }
                        }
                        return true;
                    })
                    .toList();
        }

        // Step 3: map to DTO
        return products.stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getAvailable(),
                        p.getCategoryId().getName(),
                        p.getStockQuantity()
                ))
                .toList();
    }
}