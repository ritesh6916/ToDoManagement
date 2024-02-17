package com.ritesh.boot.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ritesh.boot.todo.template.Todo;

public class TodoService {

	private static List<Todo> todoos = new ArrayList<Todo>();
	
	static {
		todoos.add(new Todo(1, "Ritesh", "Learn Spring Boot MVC ", LocalDate.now().plusMonths(1), false));
		todoos.add(new Todo(1, "Ritesh", "Brindavan Holi ", LocalDate.now().plusDays(30), false));
		todoos.add(new Todo(1, "Ritesh", "Learn Spring Boot Security ", LocalDate.now().plusMonths(1), false));
		
	}
}
