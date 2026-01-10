package com.omelianenko.todo_crud;

import com.omelianenko.todo_crud.model.Todo;
import com.omelianenko.todo_crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoCrudApplication implements CommandLineRunner {

	private TodoRepository todoRepository;

	@Autowired
	public void setTodoRepository(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (todoRepository.count() == 0) {
			todoRepository.save(new Todo("Read doc", "become smarter"));
			todoRepository.save(new Todo("Create todo app", "create app with CRUD operations"));

			System.out.println("Test data added");
		}
	}
}
