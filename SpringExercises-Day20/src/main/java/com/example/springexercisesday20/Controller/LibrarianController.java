package com.example.springexercisesday20.Controller;

import com.example.springexercisesday20.Model.Librarian;
import com.example.springexercisesday20.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {

    private final LibrarianService librarianService;


    @GetMapping("/get")
    public ResponseEntity getLibrarians(){
       return ResponseEntity.status(200).body(librarianService.getLibrarians());
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@Valid @RequestBody @PathVariable Integer id, Librarian librarian){
        librarianService.updateLibrarian(id,librarian);
        return ResponseEntity.status(200).body("updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("deleted");

    }

    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        Librarian librarian = librarianService.getById(id);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity check(@PathVariable String username, @PathVariable String password){
        librarianService.check(username,password);
        return ResponseEntity.status(200).body("checked succeeded");
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        Librarian librarian = librarianService.getLibrarianByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }
}
