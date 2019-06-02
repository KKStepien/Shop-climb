package com.example.shop.products;

import com.example.shop.category.Category;

public class ProductUpdate {
  private String name;
  private Double prize;
  private Integer amount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrize() {
    return prize;
  }

  public void setPrize(Double prize) {
    this.prize = prize;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

}
