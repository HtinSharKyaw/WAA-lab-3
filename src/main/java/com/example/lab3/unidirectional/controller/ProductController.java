package com.example.lab3.unidirectional.controller;

import com.example.lab3.unidirectional.entity.Product;
import com.example.lab3.unidirectional.service.ProductService;
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

    @GetMapping("/get/price")
    public List<Product> getProductsMoreThanMinPrice(@RequestParam String rate) {
        return productService.getProductByPriceGreaterThan(Double.parseDouble(rate));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

}
