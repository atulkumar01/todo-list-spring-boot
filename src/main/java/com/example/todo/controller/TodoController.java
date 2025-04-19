package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    public TodoService todoService;

    @GetMapping
    public  List<Todo> getAllTodos()
    {
        return todoService.getAllTodo();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id)
    {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo)
    {
        return todoService.createTodo(todo);
    }

    @PutMapping("{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo)
    {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id)
    {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }











}
