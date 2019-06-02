package com.example.shop.order;

import java.util.Map;

public class CreateOrderDTO {
  private LoggedCustomerDTO customer;
  private Map<Long, Integer> mapa;

  public Map<Long, Integer> getMapa() {
    return mapa;
  }

  public void setMapa(Map<Long, Integer> mapa) {
    this.mapa = mapa;
  }

  public LoggedCustomerDTO getCustomer() {
    return customer;
  }

  public void setCustomer(LoggedCustomerDTO customer) {
    this.customer = customer;
  }
}
