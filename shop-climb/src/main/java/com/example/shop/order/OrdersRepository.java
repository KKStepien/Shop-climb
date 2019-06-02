package com.example.shop.order;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrdersRepository extends Repository<Orders, Long> {

  Orders save(Orders orders);

  List<Orders> findAll();

  List<Orders> findByCustomerId(Long customerId);

}
