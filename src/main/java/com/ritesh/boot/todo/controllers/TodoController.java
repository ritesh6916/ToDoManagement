package com.ritesh.boot.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

	
	@RequestMapping(path = "/todoes", method = RequestMethod.GET)
	public String listAllTodoes() {

		return "listTodo";
	}
}
