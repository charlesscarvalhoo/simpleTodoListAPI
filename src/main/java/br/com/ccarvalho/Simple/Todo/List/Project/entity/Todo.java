package br.com.ccarvalho.Simple.Todo.List.Project.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="tb_todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean completed;
    private int priority;

    public Todo(){
    }

    public Todo(Long id, String name, String description, boolean completed, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }

    public Todo(String name, String description, boolean completed, int priority) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
