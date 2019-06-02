package com.example.shop.orderItem;

import com.example.shop.order.Orders;
import com.example.shop.products.Product;

import javax.persistence.*;

@Entity
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(optional = false)
  @JoinColumn(name = "product_id")
  private Product product;
  private Integer amountBuy;
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Orders orders;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getAmountBuy() {
    return amountBuy;
  }

  public void setAmountBuy(Integer amountBuy) {
    this.amountBuy = amountBuy;
  }

  public Orders getOrders() {
    return orders;
  }

  public void setOrders(Orders orders) {
    this.orders = orders;
  }
}
