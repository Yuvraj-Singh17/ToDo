package com.example.todoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.todoapp.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
