package com.ritesh.boot.todo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ritesh.boot.todo.service.TodoService;
import com.ritesh.boot.todo.template.Todo;

//http://localhost:8080/TodoManagement/login

@Controller
@SessionAttributes("userid")
public class TodoController {

	@Autowired
	TodoService todoService;

	// to see list of toDoes
	@RequestMapping("/todoes")
	public ModelMap getAllTodoes(ModelMap mm) {
		List<Todo> listTodo = todoService.getAlltodoes();
		mm.addAttribute("todoes", listTodo);
		return mm;
	}

	// @RequestMapping(path = "/todoes",method = RequestMethod.POST)
	public ModelMap postAllTodoes(ModelMap mm) {

		List<Todo> listTodo = todoService.getAlltodoes();
		mm.addAttribute("todoes", listTodo);
		return mm;
	}

	// To show Add todo page
	@RequestMapping("/add-todo")
	public String addTodo(ModelMap mm) {
		Todo todo = new Todo(0, (String) mm.get("userid"), "", LocalDate.now().plusYears(1), false);
		mm.put("todo", todo);
		return "addTodo";
	}

	// to show updated todo
	@RequestMapping(path = "/add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap mm, Todo todo) {
		todoService.addtodo((String) mm.get("userid"), todo.getDescription(), LocalDate.now().plusMonths(1), false);
		return "redirect:/todoes";
	}
}