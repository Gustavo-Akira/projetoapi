package com.example.demo.resources;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UsersResource {
    @Autowired
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity add(@RequestBody Users user){
        service.Insert(user);
        return ResponseEntity.ok().build();
    }
}
