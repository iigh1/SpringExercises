package com.example.springexercisesday20.Repository;

import com.example.springexercisesday20.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);
    Book findBookByTitle(String title);

    List<Book> findBookByCategory(String category);

    @Query("select s from Book s where s.numberOfPages >= ?1")
    List<Book> getBookByNumberOfPages(Integer num);

    List<Book> getBookByAuthor(String author);
}
