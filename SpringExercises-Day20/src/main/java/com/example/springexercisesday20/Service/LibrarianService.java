package com.example.springexercisesday20.Service;

import com.example.springexercisesday20.ApiException.ApiException;
import com.example.springexercisesday20.Model.Librarian;
import com.example.springexercisesday20.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getLibrarians(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);

    }
    public void updateLibrarian(Integer id, Librarian librarian){
        Librarian librarian1 = librarianRepository.findLibrarianById(id);

        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());
        librarian1.setEmail(librarian.getEmail());
        librarianRepository.save(librarian1);
    }

    public void deleteLibrarian(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian==null){
            throw new ApiException("not found");
        }
        librarianRepository.delete(librarian);
    }

    public Librarian getById(Integer id){
        Librarian librarian= librarianRepository.findLibrarianById(id);

        if (librarian==null){
            throw new ApiException("not found");
        }
        return librarian;
    }

    public  Librarian check(String username, String password){
        Librarian librarian = librarianRepository.findLibrarianByUsernameAndPassword(username,password);

        if (librarian==null){
            throw  new ApiException("not found");
        }
        return librarian;
    }

    public Librarian getLibrarianByEmail(String email){
        Librarian librarian = librarianRepository.getLibrarianByEmail(email);
        if (librarian==null){
            throw  new ApiException("not found");
        }
        return librarian;
    }


}
