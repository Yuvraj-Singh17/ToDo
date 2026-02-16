package com.example.todoapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Optional<Todo> getTodoById(String id) {
        return repository.findById(id);
    }

    public Todo updateTodo(String id, Todo newTodo) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setTitle(newTodo.getTitle());
                    todo.setDescription(newTodo.getDescription());
                    todo.setCompleted(newTodo.isCompleted());
                    return repository.save(todo);
                }).orElse(null);
    }

    public void deleteTodo(String id) {
        repository.deleteById(id);
    }
}
