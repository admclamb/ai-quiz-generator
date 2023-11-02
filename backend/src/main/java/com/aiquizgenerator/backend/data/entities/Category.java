package com.aiquizgenerator.backend.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonBackReference
    @ManyToMany
    private Set<Quiz> quizes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Quiz> getQuizes() {
        return quizes;
    }

    public void setQuizes(Set<Quiz> quizes) {
        this.quizes = quizes;
    }
}
