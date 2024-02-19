package com.ritesh.boot.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ritesh.boot.todo.security.LoginSecurity;

@Controller
@SessionAttributes("userid")
public class HomeController {

	@Autowired
	LoginSecurity loginSecurity;

	@RequestMapping(value = "")
	public String hello() {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String login(@RequestParam("userid") String userid, @RequestParam("password") String password, ModelMap mm) {
		if (loginSecurity.validateUser(userid, password)) {
			mm.put("userid", userid);
			return "Home";
		}
		return "login";
	}
}
