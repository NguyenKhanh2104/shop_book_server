package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
        Category getCategoryById(Integer id);
        Category getCategoryByName(String name);
        List<Category> findAll();
}
