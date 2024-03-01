package com.ritesh.boot.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.ritesh.boot.todo.template.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todoes = new ArrayList<Todo>();
	private static int countTodo;
	static {
		todoes.add(new Todo(++countTodo, "Ritesh", "Learn Spring Boot MVC ", LocalDate.now().plusMonths(1), false));
		todoes.add(new Todo(++countTodo, "Ritesh", "Brindavan Holi ", LocalDate.now().plusDays(30), false));
		todoes.add(
				new Todo(++countTodo, "Ritesh", "Learn Spring Boot Security ", LocalDate.now().plusMonths(1), false));
	}

	public List<Todo> getAlltodoes() {
		return todoes;
	}

	public void addtodo(String user, String description, LocalDate targetDate, boolean done) {
		todoes.add(new Todo(++countTodo, user, description, targetDate, done));
	}

	public void deleteById(int id) {

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todoes.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todoes.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public List<Todo> findByName(String name) {
		List<Todo> list = new ArrayList<>();
		for (Todo todo : todoes) {
			if(todo.getUsername().equalsIgnoreCase(name)) {
				list.add(todo);
			}
		}
		return list;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		//todoes.add(new Todo(todo.getId(),todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
		todoes.add(todo);
	}
}