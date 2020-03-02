package com.example.demo.services;

import com.example.demo.entities.Projects;
import com.example.demo.entities.Users;
import com.example.demo.repositories.ProjectsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository repository;

    public List<Users> getAll(){
        return repository.findAll();
    }
    public Users findById(Long id){
        Optional<Users> obj= repository.findById(id);
        return obj.get();
    }
    public void Insert(Users users){
        repository.save(users);
    }
}
