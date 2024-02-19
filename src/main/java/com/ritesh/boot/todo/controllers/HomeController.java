package com.ritesh.boot.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ritesh.boot.todo.security.LoginSecurity;

@Controller
public class HomeController {

	@Autowired
	LoginSecurity loginSecurity;
	
	@RequestMapping(value = "")
	public String hello(@RequestParam("userid") String userid, @RequestParam("password") String password, ModelMap mm) {
		mm.put("userid", userid);
		return "login";
	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam("userid") String userid, @RequestParam("password") String password, ModelMap mm) {
		mm.put("userid", userid);
		return "Home";
	}
}
