package metropolia_leevi.demo.service;

import metropolia_leevi.demo.dto.ProductCategoryDto;
import metropolia_leevi.demo.dto.ProductDto;
import metropolia_leevi.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

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
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getAvailable()
                ));
    }

    public List<ProductDto> findAllProducts() {
        return repository.findAll()
                .stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getAvailable()
                )).toList();
    }
}