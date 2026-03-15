package metropolia_leevi.demo.service;

import metropolia_leevi.demo.entity.Order;
import metropolia_leevi.demo.entity.OrderItem;
import metropolia_leevi.demo.entity.OrderItemId;
import metropolia_leevi.demo.entity.Product;
import metropolia_leevi.demo.repository.OrderItemRepository;
import metropolia_leevi.demo.repository.OrderRepository;
import metropolia_leevi.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository itemRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository itemRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.productRepository = productRepository;
    }

    // Create a new order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public OrderItem addItem(OrderItem item) {
        // Fetch full order and product from DB
        Order order = orderRepository.findById(item.getOrder().getId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        Product product = productRepository.findById(item.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // Assign the fetched entities
        item.setOrder(order);
        item.setProduct(product);

        // Check availability
        Boolean available = product.getAvailable();
        if (available != null && !available) {
            throw new IllegalArgumentException("Product '" + product.getName() + "' is not available");
        }

        // Check stock
        if (product.getStockQuantity() < item.getQuantity()) {
            throw new IllegalArgumentException(
                    "Not enough stock for product '" + product.getName() + "'"
            );
        }

        // Reduce stock
        product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
        productRepository.save(product);

        // Set embedded ID
        if (item.getId() == null) {
            item.setId(new OrderItemId(order.getId(), product.getId()));
        }

        return itemRepository.save(item);
    }
}