package com.example.todo_api.service;

import com.example.todo_api.entity.Todo;
import com.example.todo_api.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return repository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = repository.findById(id).orElseThrow(() -> new RuntimeException("404"));
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.getCompleted());
        return repository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = repository.findById(id).orElseThrow(() -> new RuntimeException("404"));
        repository.delete(todo);
    }
}
