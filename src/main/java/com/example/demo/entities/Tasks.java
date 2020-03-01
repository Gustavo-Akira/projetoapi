package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.demo.entities.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Tasks  implements Serializable {
    private static final Long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/mm/dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant prevision;
    @ManyToOne
    private Projects project;
    private Status status;

    public Tasks(Long id, String name, Instant prevision, Projects project, Status status) {
        super();
        Id = id;
        this.name = name;
        this.prevision = prevision;
        this.project = project;
        this.status = status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getPrevision() {
        return prevision;
    }

    public void setPrevision(Instant prevision) {
        this.prevision = prevision;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Id.equals(tasks.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
