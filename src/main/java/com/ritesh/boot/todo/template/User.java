package com.ritesh.boot.todo.template;

public class User {

	public String userId;
	public String password;

	public User() {
		super();
	}

	public User(String login, String password) {
		super();
		this.userId = login;
		this.password = password;
	}

	public String getLogin() {
		return userId;
	}

	public void setLogin(String login) {
		this.userId = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [login=" + userId + ", password=" + password + "]";
	}

}