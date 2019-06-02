package com.example.shop.order;

import com.example.shop.customer.Customer;
import com.example.shop.orderItem.OrderItem;
import com.example.shop.orderItem.OrderItemRepository;
import com.example.shop.products.Product;
import com.example.shop.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
  @Autowired
  private OrdersRepository ordersRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrderItemRepository orderItemRepository;

  public void buy(Customer customer, Map<Product, Integer> productMap) {
    Orders orders = new Orders();
    orders.setCreatedDate(LocalDateTime.now());
    orders.setCustomer(customer);

    List<OrderItem> orderItemList = new ArrayList<>();
    for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
      Product product = entry.getKey();
      Integer amountBuy = entry.getValue();

      validateAmount(product, amountBuy);

      OrderItem orderItem = new OrderItem();
      orderItem.setProduct(product);
      orderItem.setAmountBuy(amountBuy);
      orderItem.setOrders(orders);
      orderItemList.add(orderItem);

      product.setAmount(product.getAmount() - amountBuy);
      productRepository.save(product);
    }

    orders.setOrderItemList(orderItemList);
    ordersRepository.save(orders);
  }

  private void validateAmount(Product product, Integer amountBuy) {
    if (product.getAmount() < amountBuy) {
      throw new IllegalStateException("NIe ma tyle produktów na stanie!!!");
    }
  }
}
