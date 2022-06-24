package com.example.lab3.unidirectional.service.impl;

import com.example.lab3.unidirectional.dto.ProductDTO;
import com.example.lab3.unidirectional.entity.Product;
import com.example.lab3.unidirectional.repository.ProductRepository;
import com.example.lab3.unidirectional.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Product> getProductByPriceGreaterThan(double price) {
        return productRepository.getProductByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getProductByPriceAndCategory(String category, double price) {
        return null;
    }


    //use model mapper here
    public ProductDTO toDTO(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO,Product.class);
    }
}
