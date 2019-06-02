package com.example.shop.order;

import com.example.shop.customer.Customer;
import com.example.shop.customer.CustomerService;
import com.example.shop.products.Product;
import com.example.shop.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {
  @Autowired
  private OrdersService ordersService;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private ProductRepository productRepository;

  @PutMapping("/api/order")
  public void create(@RequestBody CreateOrderDTO createOrderDTO) {
    Customer customer = customerService.checkCustomer(createOrderDTO.getCustomer().getLogin(), createOrderDTO.getCustomer().getPassword());

    if(customer!=null){
      Map<Product, Integer> productMap= new HashMap<>();
      for (Map.Entry<Long, Integer> entry: createOrderDTO.getMapa().entrySet()){
        Long id = entry.getKey();
        Product product = productRepository.findById(id);
        productMap.put(product,entry.getValue());
      }
      ordersService.buy(customer, productMap);
    }
    //todo wyjatek jak nie istnieje
  }
}
