package com.example.shop.products;

import com.example.shop.category.Category;

public class ProductDTO {
  private Long id;
  private String name;
  private Double size;
  private Double prize;
  private Integer amount;
  private String category;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
