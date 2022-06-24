package com.example.lab3.bidirectional.service.impl;

import com.example.lab3.bidirectional.dto.ProductDTO;
import com.example.lab3.bidirectional.entity.Product;
import com.example.lab3.bidirectional.repository.ProductRepository;
import com.example.lab3.bidirectional.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        if (null != product) productRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> getProductByPriceGreaterThan(double parseDouble) {
        return productRepository.getProductByPriceGreaterThan(parseDouble);
    }

    @Override
    public List<Product> getProductsByPriceLessThanAndCategory_Name(double price, String category) {
        return productRepository.getProductsByPriceLessThanAndCategory_Name(price,category);
    }

    @Override
    public List<Product> getProductsByNameContains(String name) {
        return productRepository.getProductsByNameContains(name);
    }

    //use model mapper here
    public ProductDTO toDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
}
