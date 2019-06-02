package com.example.shop.order;

import com.example.shop.customer.Customer;
import com.example.shop.orderItem.OrderItem;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime createdDate;
  @ManyToOne(optional = false)
  @JoinColumn(name = "customer_id")
  private Customer customer;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
  private List<OrderItem> orderItemList;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }
}
