package metropolia_leevi.demo.dto;

import java.math.BigDecimal;

public class ProductDto {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
    private String productCategory;

    public ProductDto(int id, String name, String description, BigDecimal price, Boolean available,  String productCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.productCategory = productCategory;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public Boolean getAvailable() { return available; }
    public String getProductCategory() { return productCategory; }
}