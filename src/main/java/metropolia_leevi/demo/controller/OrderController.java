package metropolia_leevi.demo.controller;

import metropolia_leevi.demo.entity.Order;
import metropolia_leevi.demo.entity.OrderItem;
import metropolia_leevi.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @PostMapping("/additem")
    public OrderItem addItem(@RequestBody OrderItem item) {
        return service.addItem(item);
    }
}