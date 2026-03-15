package metropolia_leevi.demo.service;

import metropolia_leevi.demo.entity.Order;
import metropolia_leevi.demo.entity.OrderItem;
import metropolia_leevi.demo.repository.OrderItemRepository;
import metropolia_leevi.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public OrderItem addItem(OrderItem item) {
        return itemRepository.save(item);
    }
}