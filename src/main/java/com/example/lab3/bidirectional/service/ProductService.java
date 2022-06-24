package com.example.lab3.bidirectional.service;

import com.example.lab3.bidirectional.entity.Product;

import java.util.List;


public interface ProductService {
    void save(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> getAll();

    List<Product> getProductByPriceGreaterThan(double parseDouble);

    List<Product> getProductsByPriceLessThanAndCategory_Name(double price,String category);

    List<Product> getProductsByNameContains(String name);
}
