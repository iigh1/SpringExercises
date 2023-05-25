package com.example.springexercisesday20.Controller;

import com.example.springexercisesday20.Model.Book;
import com.example.springexercisesday20.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("get")
    public ResponseEntity getBook(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book added");

    }
    @PostMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody @PathVariable Integer id, Book book){
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body("Book updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted");
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getCategory(@PathVariable String category){
       List<Book> books = bookService.getBookByCategory(category);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/get-author/{author}")
    public ResponseEntity getAuthor(@PathVariable String author){
        List<Book> books= bookService.getBookByAuthor(author);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("get-page/{num}")
    public ResponseEntity getNumber(@PathVariable Integer num){
        List<Book> books = bookService.getBookByPages(num);
        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("get-title/{title}")
    public ResponseEntity getTitle(@PathVariable String title){
        Book book =bookService.searchBook(title);
        return ResponseEntity.status(200).body(book);
    }

}
