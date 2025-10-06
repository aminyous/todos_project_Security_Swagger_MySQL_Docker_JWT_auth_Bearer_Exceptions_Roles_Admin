package com.hichinfo.todos.controller;

import com.hichinfo.todos.request.TodoRequest;
import com.hichinfo.todos.response.TodoResponse;
import com.hichinfo.todos.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo REST API Endpoints", description = "Operations for managing user todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Operation(summary = "Create a todo for user", description = "Create todo for signed in user.")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse createTodo(@Valid @RequestBody TodoRequest todoRequest) throws AccessDeniedException {
        return todoService.createTodo(todoRequest);
    }
}
