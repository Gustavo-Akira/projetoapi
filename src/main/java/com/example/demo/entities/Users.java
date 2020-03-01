package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Users implements Serializable {
    private static final Long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Email;
    private String nome;
    private String senha;
    @OneToMany
    private List<Projects> projects;

    public Users(Long id, String email, String nome, String senha) {
        super();
        Id = id;
        Email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
