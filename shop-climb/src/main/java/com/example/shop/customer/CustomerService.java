package com.example.shop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public Customer create(String login, String password) {
    Customer customer = new Customer();
    customer.setCreatedDate(LocalDateTime.now());
    if (login != null) {
      if (!checkLogin(login)) {
        customer.setLogin(login);
      }
    }
    if (password != null) {
      customer.setPassword(password);
    }
    return customerRepository.save(customer);
  }


  public boolean checkLogin(String login) { //todo dodac sprawdzanie po Liscie rowniez dla Moderatorow
    List<Customer> customer = findAll();
    boolean yesOrNo;
    for (int i = 0; i < customer.size(); i++) {
      yesOrNo = Objects.equals(customer.get(i).getLogin(), login);
      if (yesOrNo) {
        return true;
      }
    }
    return false;
  }

  public Customer checkCustomer(String login, String password) {
    Customer customer = customerRepository.findByLogin(login);
    if (customer != null) {
      if (Objects.equals(customer.getPassword(), password)) {
        return customer;
      }
    }
    return null;
  }


  public List<Customer> findAll() {
    return customerRepository.findAll();
  }
}
