package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
        void deleteBookById(Integer id);
}
