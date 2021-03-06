package com.example.demo.resources;

import com.example.demo.entities.Projects;
import com.example.demo.entities.Tasks;
import com.example.demo.services.ProjectsService;
import com.example.demo.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value="/projects")
public class ProjectsResources {
    @Autowired
    private TasksService tasksservice;
    @Autowired
    private ProjectsService service;

    @GetMapping
    public ResponseEntity<List<Projects>> getAll(){
        List<Projects> project = service.getAll();
        return ResponseEntity.ok(project);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Projects> getByName(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity createProject(@RequestBody Projects project){
        service.Insert(project);
        return  ResponseEntity.ok().build();
    }
    @PostMapping(value="/tasks")
    public ResponseEntity createTask(@RequestBody Tasks tasks){
        tasksservice.newInsert(tasks);
        return ResponseEntity.ok().build();
    }

}
