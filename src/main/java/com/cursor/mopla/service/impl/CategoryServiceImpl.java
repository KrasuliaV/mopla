package com.cursor.mopla.service.impl;

import com.cursor.mopla.entities.Category;
import com.cursor.mopla.repositories.CategoryRepository;
import com.cursor.mopla.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll(Sort.by("shortName"));
    }
}
