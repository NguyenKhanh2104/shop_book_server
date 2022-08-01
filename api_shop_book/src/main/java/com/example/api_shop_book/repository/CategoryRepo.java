package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    @Query(value = "SELECT b FROM Category b WHERE b.name IN :name")
    Category findCategoryByName(@Param("name") String name);
    @Query(value = "SELECT b.name FROM Category b WHERE b.name IN :name")
    Category findCategoryNameByName(@Param("name") String name);
}
