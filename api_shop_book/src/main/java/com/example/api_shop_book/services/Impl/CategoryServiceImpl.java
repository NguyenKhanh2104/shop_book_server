package com.example.api_shop_book.services.Impl;

import com.example.api_shop_book.model.Category;
import com.example.api_shop_book.repository.CategoryRepo;
import com.example.api_shop_book.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepo.getById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepo.findCategoryByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
