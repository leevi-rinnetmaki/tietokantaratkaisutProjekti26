package metropolia_leevi.demo.controller;
import metropolia_leevi.demo.dto.CustomerOrderDto;
import metropolia_leevi.demo.service.CustomerOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/customerorders")
public class CustomerOrdersController {

    private final CustomerOrderService service;
    public CustomerOrdersController(CustomerOrderService service) {
        this.service = service;
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<CustomerOrderDto> getCustomerOrderById(@PathVariable Integer id) {

        return service.getCustomerOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOrderDto>> getAll() {
        List<CustomerOrderDto> customerOrders = service.findAllCustomerOrders();
        return ResponseEntity.ok(customerOrders);
    }
}