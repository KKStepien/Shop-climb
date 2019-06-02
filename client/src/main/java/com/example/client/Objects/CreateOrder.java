package com.example.client.Objects;

import java.util.Map;

public class CreateOrder {
  private Customer customer;
  private Map<Long, Integer> mapa;

  public Map<Long, Integer> getMapa() {
    return mapa;
  }

  public void setMapa(Map<Long, Integer> mapa) {
    this.mapa = mapa;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
