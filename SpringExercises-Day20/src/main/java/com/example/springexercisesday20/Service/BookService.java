package com.example.springexercisesday20.Service;

import com.example.springexercisesday20.ApiException.ApiException;
import com.example.springexercisesday20.Model.Book;
import com.example.springexercisesday20.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book){

        Book book1 = bookRepository.findBookById(id);
        if (book1==null){
            throw new ApiException("book not found");
        }
        book1.setTitle(book.getTitle());
        book1.setCategory(book.getCategory());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages((book.getNumberOfPages()));
        book1.setAuthor(book.getAuthor());
        bookRepository.save(book1);

    }

    public void deleteBook(Integer id){

        Book book1 = bookRepository.findBookById(id);
        if (book1==null){
            throw new ApiException("book not found");
        }
        bookRepository.delete(book1);
    }

    public List<Book> getBookByCategory(String category){
        List<Book> books = bookRepository.findBookByCategory(category);
        if (books== null){
            throw new ApiException("books not found");
        }
        return books;
    }

    public List<Book> getBookByPages(Integer num){
        List<Book> books = bookRepository.getBookByNumberOfPages(num);
        if (books == null){
            throw new ApiException("not found");
        }
        return books;
    }

    public List<Book> getBookByAuthor(String author){
        List<Book> books = bookRepository.getBookByAuthor(author);
        if (books==null){
            throw new ApiException("books not found");
        }
        return books;
    }

    public Book searchBook(String title){
        Book book1 = bookRepository.findBookByTitle(title);
        if (book1==null){
            throw new ApiException("book not fond");
        }
        return book1;
    }




}
