package com.ritesh.boot.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userid")
public class HomeController {

	/*
	 * @Autowired LoginSecurity loginSecurity;
	 */

	@RequestMapping(value = "/")
	public String welcome(ModelMap mm) {
		mm.put("userid", "Ritesh6916");
		return "Home";
	}

	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.GET) public String
	 * login(@RequestParam("userid") String userid, @RequestParam("password") String
	 * password, ModelMap mm) { if (loginSecurity.validateUser(userid, password)) {
	 * mm.put("userid", userid); //mm.addAttribute("userid", userid); return "Home";
	 * } mm.addAttribute("Error", "UserID or Password Incorrect"); return "login"; }
	 */
}