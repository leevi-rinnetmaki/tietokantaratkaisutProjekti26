package metropolia_leevi.demo.entity;

import metropolia_leevi.demo.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository repository;
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(customers -> ResponseEntity.ok(customers))
                .orElse(ResponseEntity.notFound().build());
    }

}