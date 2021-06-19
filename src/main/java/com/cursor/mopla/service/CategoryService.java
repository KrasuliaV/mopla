package com.cursor.mopla.service;

import com.cursor.mopla.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAll();

}
