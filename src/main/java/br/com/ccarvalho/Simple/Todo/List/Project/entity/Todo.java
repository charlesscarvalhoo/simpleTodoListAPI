package br.com.ccarvalho.Simple.Todo.List.Project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name ="tb_todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Task must have a name!")
    private String name;

    @NotBlank(message = "Tasks must have a description!")
    private String description;

    private boolean completed;
    private int priority;

    public Todo(){
    }

    public Todo(Long id, @NotBlank String name, @NotBlank String description, boolean completed, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }

    public Todo(@NotBlank String name, @NotBlank String description, boolean completed, int priority) {
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
