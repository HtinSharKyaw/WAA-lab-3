package com.example.lab3.unidirectional.service;

import com.example.lab3.unidirectional.entity.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    void save(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> getAll();

    List<Product> getProductByPriceGreaterThan(double price);

    List<Product> getProductByPriceAndCategory(String category,double price);

}
