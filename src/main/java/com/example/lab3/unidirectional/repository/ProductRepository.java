package com.example.lab3.unidirectional.repository;

import com.example.lab3.unidirectional.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    List<Product> getProductByPriceGreaterThan(double price);
    //List<Product> getProductsByPriceLessThanAnd

}
