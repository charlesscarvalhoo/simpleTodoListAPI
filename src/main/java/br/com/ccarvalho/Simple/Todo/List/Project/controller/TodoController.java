package br.com.ccarvalho.Simple.Todo.List.Project.controller;

import br.com.ccarvalho.Simple.Todo.List.Project.entity.Todo;
import br.com.ccarvalho.Simple.Todo.List.Project.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> create(@Valid @RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@Valid @PathVariable Long id){
        return todoService.delete(id);
    }
}
