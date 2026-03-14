package metropolia_leevi.demo.entity;
import jakarta.persistence.*;
import metropolia_leevi.demo.converter.ProductConverter;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    private Integer supplierId;
    @Column(name = "available", columnDefinition = "CHAR(1)")
    @Convert(converter = ProductConverter.class)
    private Boolean available;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public ProductCategory getCategoryId() {
        return productCategory;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setCategoryId(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}