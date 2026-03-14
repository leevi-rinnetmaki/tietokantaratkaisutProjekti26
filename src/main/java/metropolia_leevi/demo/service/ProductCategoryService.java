package metropolia_leevi.demo.service;

import metropolia_leevi.demo.dto.ProductCategoryDto;
import metropolia_leevi.demo.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository repository;

    public ProductCategoryService(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public Optional<ProductCategoryDto> getProductCategoryById(Integer id) {
        return repository.findById(id)
                .map(productCategory -> new ProductCategoryDto(
                        productCategory.getId(),
                        productCategory.getName(),
                        productCategory.getDescription()
                ));
    }

    public List<ProductCategoryDto> findAllCategories() {
        return repository.findAll()
                .stream()
                .map(product -> new ProductCategoryDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription()
                )).toList();
    }
}