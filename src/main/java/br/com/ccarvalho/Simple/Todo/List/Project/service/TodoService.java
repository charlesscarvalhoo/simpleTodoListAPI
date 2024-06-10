package br.com.ccarvalho.Simple.Todo.List.Project.service;

import br.com.ccarvalho.Simple.Todo.List.Project.entity.Todo;
import br.com.ccarvalho.Simple.Todo.List.Project.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }


    public List<Todo> list(){
        Sort sorted = Sort.by("priority").descending().and(
                Sort.by("name").ascending());
                return todoRepository.findAll(sorted);
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
