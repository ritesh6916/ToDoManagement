package com.ritesh.boot.todo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ritesh.boot.todo.service.TodoService;
import com.ritesh.boot.todo.template.Todo;

import jakarta.validation.Valid;

//http://localhost:8080/TodoManagement/login

//@Controller
@SessionAttributes("userid")
public class TodoController {

	TodoService todoService;

	public TodoController() {
		super();

	}

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// to see list of toDoes
	@RequestMapping("/todoes")
	public ModelMap getAllTodoes(ModelMap mm) {
		List<Todo> listTodo = todoService.findByName(getLoggedInUserName());
		mm.addAttribute("todoes", listTodo);
		return mm;
	}

	// To show Add TODO page
	@RequestMapping("/add-todo")
	public String addTodo(ModelMap mm) {
		Todo todo = new Todo(0, getLoggedInUserName(), "", LocalDate.now().plusYears(1), false);
		mm.put("todo", todo);
		return "addTodo";
	}

	// to show updated TODO
	@RequestMapping(path = "/add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap mm, @Valid Todo todo, BindingResult result) {
		// @Valid to enable validation while accepting the data
		if (result.hasErrors()) {
			return "addTodo";
		}
		todoService.addtodo(getLoggedInUserName(), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:/todoes";
	}

	// to Delete a Todo
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam("id") int id) {
		todoService.deleteById(id);
		return "redirect:/todoes";
	}

	// to show update TODO page with existing details
	@RequestMapping("/update-todo")
	public String showUpdateTodo(@RequestParam int id, ModelMap mm) {
		Todo todo = todoService.findById(id);
		mm.addAttribute("todo", todo);
		return "addTodo";
	}

	// to show updated TODO
	@RequestMapping(path = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap mm, @Valid Todo todo, BindingResult result) {
		// @Valid to enable validation while accepting the data
		if (result.hasErrors()) {
			return "addTodo";
		}
		todo.setUsername(getLoggedInUserName());
		todoService.updateTodo(todo);
		return "redirect:/todoes";
	}

	private String getLoggedInUserName() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}

}