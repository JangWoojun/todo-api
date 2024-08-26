package com.example.todo_api.controller;


import com.example.todo_api.entity.Todo;
import com.example.todo_api.exception.ResourceNotFoundException;
import com.example.todo_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;


    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodos(@PathVariable("id") Long id) {

        Todo todo = todoService.getTodoById(id).orElseThrow(() ->  new ResourceNotFoundException("Todo not found"));

        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todoDetails) {
        Todo updateTodo = todoService.updateTodo(id, todoDetails);
        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

}