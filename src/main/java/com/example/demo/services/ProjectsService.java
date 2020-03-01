package com.example.demo.services;

import com.example.demo.entities.Projects;
import com.example.demo.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProjectsService {
    @Autowired
    private ProjectsRepository repository;

    public List<Projects> getAll(){
        return repository.findAll();
    }
    public Projects findById(Long id){
        Optional<Projects> obj= repository.findById(id);
        return obj.get();
    }
    public void Insert(Projects project){
        repository.save(project);
    }
}
