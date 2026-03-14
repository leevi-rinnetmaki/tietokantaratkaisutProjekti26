package metropolia_leevi.demo.service;

import metropolia_leevi.demo.dto.ProductCategoryDto;
import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.entity.Product;
import metropolia_leevi.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<ProductDto> getProductById(Integer id) {
        return repository.findById(id)
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getAvailable()
                ));
    }

    public List<ProductDto> findAllProducts() {
        return repository.findAll()
                .stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getAvailable()
                )).toList();
    }

    public List<ProductDto> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return repository.findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getAvailable()
                ))
                .toList();
    }

    public List<ProductDto> searchProducts(
            Integer id,
            BigDecimal minprice,
            BigDecimal maxprice,
            Boolean available,
            boolean filterNull
    ) {
        List<Product> products = repository.findAll(); // start with all

        if (id != null) {
            products = products.stream()
                    .filter(p -> p.getId() == id)
                    .toList();
        }
        if (minprice != null) {
            products = products.stream()
                    .filter(p -> p.getPrice().compareTo(minprice) >= 0)
                    .toList();
        }
        if (maxprice != null) {
            products = products.stream()
                    .filter(p -> p.getPrice().compareTo(maxprice) <= 0)
                    .toList();
        }

        if (available != null) {
            // Filter for true or false safely
            products = products.stream()
                    .filter(p -> available.equals(p.getAvailable()))
                    .toList();
        } else if (filterNull) {
            // Explicitly filter for null availability
            products = products.stream()
                    .filter(p -> p.getAvailable() == null)
                    .toList();
        }
        // else: available parameter omitted → don't filter

        // Map to DTO
        return products.stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getAvailable()))
                .toList();
    }
}