package com.ritesh.boot.todo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ritesh.boot.todo.template.User;

@Service
public class LoginSecurity {

	public static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("Ritesh", "Ritesh@123"));
		users.add(new User("user", "123"));
	}

	public boolean validateUser(String u, String p) {
		for (User user : users) {
			if (user.userId.equalsIgnoreCase(u) && user.password.equals(p)) {
				return true;
			}
		}
		return false;
	}

}