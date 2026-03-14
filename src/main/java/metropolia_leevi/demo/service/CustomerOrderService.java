package metropolia_leevi.demo.service;
import metropolia_leevi.demo.dto.CustomerOrderDto;
import metropolia_leevi.demo.repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository repository;

    public CustomerOrderService(CustomerOrderRepository repository) {
        this.repository = repository;
    }

    public Optional<CustomerOrderDto> getCustomerOrderById(Integer id) {
        return repository.findById(id)
                .map(customerOrder -> new CustomerOrderDto(
                        customerOrder.getId(),
                        customerOrder.getFirstName(),
                        customerOrder.getLastName(),
                        customerOrder.getQuantityOfOrders(),
                        customerOrder.getPriceOfOrders()
                ));
    }

    public List<CustomerOrderDto> findAllCustomerOrders() {
        return repository.findAll()
                .stream()
                .map(customerOrder -> new CustomerOrderDto(
                        customerOrder.getId(),
                        customerOrder.getFirstName(),
                        customerOrder.getLastName(),
                        customerOrder.getQuantityOfOrders(),
                        customerOrder.getPriceOfOrders()
                )).toList();
    }
}