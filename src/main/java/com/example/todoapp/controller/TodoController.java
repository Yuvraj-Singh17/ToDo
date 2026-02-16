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
    public Todo create(@RequestBody Todo todo) {
        return service.create(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable String id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable String id, @RequestBody Todo todo) {
        return service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}
