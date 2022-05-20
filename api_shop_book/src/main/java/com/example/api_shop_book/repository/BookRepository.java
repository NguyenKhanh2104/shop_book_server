package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
        

        @Query(value = "SELECT b FROM Book b WHERE b.name IN :name")
        Book finBookByname(@Param("name") String name);


        void deleteBookById(Integer id);
}
