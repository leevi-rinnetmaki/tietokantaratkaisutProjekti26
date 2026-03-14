package metropolia_leevi.demo.converter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductsConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value == null) return null;
        return value ? "Y" : "N";
    }
    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value == null) return null;
        return value.equals("Y");
    }
}