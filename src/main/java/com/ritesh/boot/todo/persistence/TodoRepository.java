package com.ritesh.boot.todo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.boot.todo.template.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	public List<Todo> findByUsername(String username);
}
