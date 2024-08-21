package com.example.todo_api.repository;

import com.example.todo_api.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
