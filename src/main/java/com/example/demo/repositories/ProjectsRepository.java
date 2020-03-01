package com.example.demo.repositories;

import com.example.demo.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {
}
