package com.ritesh.boot.todo.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ritesh.boot.todo.persistence.TodoRepository;
import com.ritesh.boot.todo.template.Todo;

import jakarta.validation.Valid;

//http://localhost:8080/TodoManagement/login

@Controller
@SessionAttributes("userid")
public class TodoJpaController {

	@Autowired
	TodoRepository todoRepository;

	Logger logger = LoggerFactory.getLogger(getClass().getName());

	public TodoJpaController() {
		super();

	}

	public TodoJpaController(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	// to see list of toDoes
	@RequestMapping("/todoes")
	public ModelMap getAllTodoes(ModelMap mm) {
		List<Todo> listTodo = todoRepository.findByUsername(getLoggedInUserName());
		mm.addAttribute("todoes", listTodo);
		return mm;
	}

	// To show Add TODO page
	@RequestMapping("/add-todo")
	public String showAddTodoPage(ModelMap mm) {
		Todo todo = new Todo(0, getLoggedInUserName(), "", LocalDate.now(), false);
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
		todo.setUsername(getLoggedInUserName());
		todoRepository.save(todo);
		logger.debug("Todo added by" + getLoggedInUserName());
		return "redirect:/todoes";
	}

	// to Delete a Todo
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam("id") int id) {
		todoRepository.deleteById(id);
		logger.debug("A Todo is deleted by  " + getLoggedInUserName() + " with id: " + id);
		return "redirect:/todoes";
	}

	// to show update TODO page with existing details
	@RequestMapping("/update-todo")
	public String showUpdateTodo(@RequestParam int id, ModelMap mm) {
		Optional<Todo> todo = todoRepository.findById(id);
		mm.addAttribute("todo", todo.get());
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
		todoRepository.save(todo);
		logger.debug("A Todo is updated by " + getLoggedInUserName() + " with id: " + todo.getId());
		return "redirect:/todoes";
	}

	private String getLoggedInUserName() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}

}