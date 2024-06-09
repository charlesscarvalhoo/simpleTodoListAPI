package br.com.ccarvalho.Simple.Todo.List.Project.repository;

import br.com.ccarvalho.Simple.Todo.List.Project.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
