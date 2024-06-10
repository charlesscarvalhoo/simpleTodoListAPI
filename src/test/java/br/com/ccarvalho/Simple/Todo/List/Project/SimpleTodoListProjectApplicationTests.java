package br.com.ccarvalho.Simple.Todo.List.Project;

import br.com.ccarvalho.Simple.Todo.List.Project.entity.Todo;
import br.com.ccarvalho.Simple.Todo.List.Project.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleTodoListProjectApplicationTests {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void TestCreateTodosSuccess() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new Todo("Aprender Testes","Testar sempre !", false, 1))
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(5)
				.jsonPath("$[0].name").isEqualTo("Estudar")
				.jsonPath("$[0].description").isEqualTo("Um pouco a cada dia")
				.jsonPath("$[0].completed").isEqualTo(false)
				.jsonPath("$[0].priority").isEqualTo(5);
	}

	@Test
	public void TestCreateTodosFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new Todo("", "", true, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	public void TestListTodosSuccess() {
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(5)
				.jsonPath("$[0].name").isEqualTo("Estudar")
				.jsonPath("$[0].description").isNotEmpty();
	}

	@Test
	public void TestDeleteTodosSuccess() {
		webTestClient
				.delete()
				.uri("/todos/1")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(4);
	}

}

