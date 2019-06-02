package com.example.shop.category;

import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category, Long> {

  Category findByName(String name);
}
