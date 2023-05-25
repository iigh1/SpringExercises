package com.example.springexercisesday20.Repository;


import com.example.springexercisesday20.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByUsernameAndPassword(String username, String password);

    @Query("select s from Librarian s where s.email=?1")
    Librarian getLibrarianByEmail(String email);
}
