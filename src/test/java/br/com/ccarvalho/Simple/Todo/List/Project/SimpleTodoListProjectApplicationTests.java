package br.com.ccarvalho.Simple.Todo.List.Project;

import br.com.ccarvalho.Simple.Todo.List.Project.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleTodoListProjectApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void TestCreateTodosSuccess() {
		var todo = new Todo("Todo 1","desc todo 1", false, 1);
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].completed").isEqualTo(todo.isCompleted())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
	}


		void TestCreateTodosFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todo("", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

}
