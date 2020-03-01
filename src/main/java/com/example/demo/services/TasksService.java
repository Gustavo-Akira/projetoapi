package com.example.demo.services;

import com.example.demo.entities.Projects;
import com.example.demo.entities.Tasks;
import com.example.demo.repositories.ProjectsRepository;
import com.example.demo.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TasksService {
    @Autowired
    private TasksRepository repository;

    public List<Tasks> getTasks(){
        return repository.findAll();
    }
    public List<Tasks> getTasksByProjectId(Projects project){
        List<Tasks> tasks =  repository.findAll().stream().filter((x -> x.getProject().getId()==project.getId())).collect(Collectors.toList());
        return tasks;
    }

    public void newInsert(Tasks task){
        repository.save(task);
    }
}
