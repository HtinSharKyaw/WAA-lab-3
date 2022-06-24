package com.example.lab3.bidirectional.controller;

import com.example.lab3.bidirectional.entity.Product;
import com.example.lab3.bidirectional.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/save")
    public void createProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/get")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/get/item")
    public List<Product> getProductsMoreThanMinPrice(@RequestParam String price) {
        return productService.getProductByPriceGreaterThan(Double.parseDouble(price));
    }

    @GetMapping("/get/item")
    public List<Product> getProductsByPriceLessThanAndCategory_Name(@RequestParam String price, @RequestParam String category) {
        return productService.getProductsByPriceLessThanAndCategory_Name(Double.parseDouble(price),category);
    }

    @GetMapping("/get/item")
    public List<Product> getProductsByNameContains(@RequestParam String name){
        return productService.getProductsByNameContains(name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

}
