package com.example.shop.products;

import com.example.shop.category.Category;
import com.example.shop.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private CategoryRepository categoryRepository;

  Product update(ProductUpdate productUpdate, Long id) {
    Product product = productRepository.findById(id);
    if (productUpdate.getName() != null) {
      product.setName(productUpdate.getName());
    }

    if (productUpdate.getAmount() != null) {
      product.setAmount(productUpdate.getAmount());
    }
    if (productUpdate.getPrize() != null) {
      product.setPrize(productUpdate.getPrize());
    }

    return productRepository.save(product);
  }

  @Transactional
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  public Product create(String name, Double size, Double prize, Integer amount, String categoryName) {
    Product product = new Product();
    //todo wyjątki jesli null
    if (name != null) {
      product.setName(name);
    }
    if (size != null) {
      product.setSize(size);
    }
    if (prize != null) {
      product.setPrize(prize);
    }
    if (amount != null) {
      product.setAmount(amount);
    }
    if (categoryName != null) {
      Category cat = categoryRepository.findByName(categoryName);
      product.setCategory(cat);
    }
    return productRepository.save(product);
  }

  public List<Product> findByCategoryId(Long categoryId) {
    return productRepository.findByCategoryId(categoryId);
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }
}
