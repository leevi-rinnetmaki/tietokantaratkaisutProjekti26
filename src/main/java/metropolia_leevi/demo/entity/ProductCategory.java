package metropolia_leevi.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "productcategories")
public class ProductCategory {
    @Id
    private Integer id;
    private String name;
    private String description;

    public ProductCategory() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {}
}