package com.example.shop.products;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductRepository extends Repository<Product, Long> {

  List<Product> findByCategoryId(Long categoryId);

  Product findById(Long id);

  Product save(Product product);

  void deleteById(Long Id);

  List<Product> findAll();

}
