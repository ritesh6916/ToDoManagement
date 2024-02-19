package com.ritesh.boot.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ritesh.boot.todo.template.Todo;

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
}