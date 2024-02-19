package com.ritesh.boot.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ritesh.boot.todo.security.LoginSecurity;
import com.ritesh.boot.todo.service.TodoService;
import com.ritesh.boot.todo.template.Todo;

//http://localhost:8080/TodoManagement/login

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;

	@Autowired
	LoginSecurity loginSecurity;

	@RequestMapping(value = "")
	public String hello(ModelMap Model) {
		return "Home";
	}

	@RequestMapping(value = "/login")
	public String login(ModelMap Model) {
		return "login";
	}

	@RequestMapping("/todoes")
	public ModelMap getAllTodoes(ModelMap mm) {
		List<Todo> listTodo = todoService.getAlltodoes();
		mm.addAttribute("todoes", listTodo);
		return mm;
	}

	//@RequestMapping(path = "/todoes",method = RequestMethod.GET)
	public ModelMap postAllTodoes(ModelMap mm) {
		
		List<Todo> listTodo = todoService.getAlltodoes();
		mm.addAttribute("todoes", listTodo);
		return mm;
	}
}