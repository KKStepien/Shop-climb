package com.example.shop.orderItem;

import com.example.shop.order.Orders;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderItemRepository extends Repository<OrderItem, Long> {

  OrderItem save(OrderItem orderitem);

}
