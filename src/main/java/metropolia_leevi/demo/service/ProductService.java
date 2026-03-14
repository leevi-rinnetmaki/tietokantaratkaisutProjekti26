package metropolia_leevi.demo.service;

import metropolia_leevi.demo.dto.ProductCategoryDto;
import metropolia_leevi.demo.dto.ProductDto;
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
}