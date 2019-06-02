package com.example.shop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/api/products")
  public List<ProductDTO> getProducts() {
    List<Product> products = productService.findAll();
    return getProductDTOS(products);
  }

  @GetMapping("/api/products/{categoryId}")
  public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
    List<Product> products = productService.findByCategoryId(categoryId);
    return getProductDTOS(products);
  }

  private List<ProductDTO> getProductDTOS(List<Product> products) {
    List<ProductDTO> productsDTO = new ArrayList<>();
    for (int i = 0; i < products.size(); i++) {
      ProductDTO productDTO = new ProductDTO();
      productDTO.setName(products.get(i).getName());
      productDTO.setAmount(products.get(i).getAmount());
      productDTO.setPrize(products.get(i).getPrize());
      productDTO.setSize(products.get(i).getSize());
      productDTO.setCategory(products.get(i).getCategory().getName());
      productDTO.setId(products.get(i).getId());
      productsDTO.add(productDTO);
    }
    return productsDTO;
  }

  @DeleteMapping("/api/product/{id}")
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }

  @PutMapping("/api/product")
  public ProductDTO create(@RequestBody CreateProductDTO createProductDTO) {
    Product product = productService.create(createProductDTO.getName(), createProductDTO.getSize(), createProductDTO.getPrize(),
        createProductDTO.getAmount(), createProductDTO.getCategory());
    ProductDTO productDTO = new ProductDTO();
    productDTO.setCategory(product.getCategory().getName());
    productDTO.setSize(product.getSize());
    productDTO.setPrize(product.getPrize());
    productDTO.setAmount(product.getAmount());
    productDTO.setName(product.getName());
    productDTO.setId(product.getId());
    return productDTO;
  }

  @PostMapping("/api/product/{id}")
  public ProductDTO update(@RequestBody UpdateProductDTO updateProductDTO,@PathVariable Long id){
    ProductUpdate productUpdate = new ProductUpdate();
    productUpdate.setAmount(updateProductDTO.getAmount());
    productUpdate.setName(updateProductDTO.getName());
    productUpdate.setPrize(updateProductDTO.getPrize());
    Product product = productService.update(productUpdate, id);
    ProductDTO productDTO = new ProductDTO();
    productDTO.setName(product.getName());
    productDTO.setAmount(product.getAmount());
    productDTO.setPrize(product.getPrize());
    productDTO.setCategory(product.getCategory().getName());
    productDTO.setSize(product.getSize());
    return  productDTO;
  }
}
