package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;


@Entity
public class Projects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy/mm/dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant start;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/mm/dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant prevision;
    @OneToMany
    private Set<Tasks> tasks;
    @ManyToOne
    private Users user;
    public Projects(Long id, String name, Instant start, Instant prevision, Users user) {
        super();
        Id = id;
        this.name = name;
        this.start = start;
        this.prevision = prevision;
        this.user = user;
    }

    public Set<Tasks> getTasks() {
        return tasks;
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

    public Users getUser(){return user;}

    public void setUser(Users user){ this.user = user;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projects projects = (Projects) o;
        return Id.equals(projects.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getPrevision() {
        return prevision;
    }

    public void setPrevision(Instant prevision) {
        this.prevision = prevision;
    }
}
