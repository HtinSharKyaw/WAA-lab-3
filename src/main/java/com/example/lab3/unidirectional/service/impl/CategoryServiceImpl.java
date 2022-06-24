package com.example.lab3.unidirectional.service.impl;

import com.example.lab3.unidirectional.dto.CategoryDTO;
import com.example.lab3.unidirectional.entity.Category;
import com.example.lab3.unidirectional.repository.CategoryRepository;
import com.example.lab3.unidirectional.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        Category category = findById(id);
        if(null != category){
            categoryRepository.delete(category);
        }

    }

    @Override
    public Category findById(int id) {
        return (categoryRepository.findById(id).isPresent()) ? categoryRepository.findById(id).get() : null;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    //use model mapper here
    public CategoryDTO toDTO(Category category){
        return modelMapper.map(category,CategoryDTO.class);
    }

    public Category toEntity(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO,Category.class);
    }

}
