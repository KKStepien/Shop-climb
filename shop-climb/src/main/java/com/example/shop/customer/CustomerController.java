package com.example.shop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping("/api/customer")
  public List<CustomerDTO> getAll() {
    List<Customer> customers = customerService.findAll();
    List<CustomerDTO> customersDTO = new ArrayList<>();
    for (int i = 0; i < customers.size(); i++) {
      CustomerDTO customerDTO = new CustomerDTO();
      customerDTO.setLogin(customers.get(i).getLogin());
      customersDTO.add(customerDTO);
    }
    return customersDTO;
  }

  @PutMapping("/api/customer")
  public CustomerDTO create(@RequestBody CreateCustomerDTO createCustomerDTO) {
    Customer customer = customerService.create(createCustomerDTO.getLogin(),createCustomerDTO.getPassword());
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setLogin(customer.getLogin());

    return customerDTO;
  }
}
