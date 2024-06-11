package br.com.ccarvalho.Simple.Todo.List.Project.configuration;

import br.com.ccarvalho.Simple.Todo.List.Project.entity.Todo;
import br.com.ccarvalho.Simple.Todo.List.Project.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

        @Autowired
        TodoRepository todoRepository;

        @Override
        public void run(String... args) throws Exception {
            Todo todo1 = new Todo("Estudar", "Um pouco a cada dia", false, 5);
            Todo todo2 = new Todo("Ligar pra Tati", "Fazer isso todos os dias", false, 5);
            Todo todo3 = new Todo("Descansar", "Tentar se distrair com outras coisas", false, 3);
            Todo todo4 = new Todo("Trabalhar", "O mínimo necessário", false, 1);

            todoRepository.saveAll(Arrays.asList(todo1, todo2, todo3, todo4));
        }
    }


