package com.example.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return service.getTodoById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id) {
        service.deleteTodo(id);
        return "Deleted Successfully";
    }
}
