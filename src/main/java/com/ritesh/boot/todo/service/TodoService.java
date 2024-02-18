package com.ritesh.boot.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ritesh.boot.todo.template.Todo;

@Service
public class TodoService {

	private static List<Todo> todoes = new ArrayList<Todo>();

	static {
		todoes.add(new Todo(1, "Ritesh", "Learn Spring Boot MVC ", LocalDate.now().plusMonths(1), false));
		todoes.add(new Todo(1, "Ritesh", "Brindavan Holi ", LocalDate.now().plusDays(30), false));
		todoes.add(new Todo(1, "Ritesh", "Learn Spring Boot Security ", LocalDate.now().plusMonths(1), false));

	}
	public List<Todo> getAlltodoes()
	{
		return todoes;
	}
}