package com.hichinfo.todos.service;

import com.hichinfo.todos.entity.User;
import com.hichinfo.todos.request.TodoRequest;
import com.hichinfo.todos.response.TodoResponse;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface TodoService {

    TodoResponse createTodo(TodoRequest todoRequest) throws AccessDeniedException;
    List<TodoResponse> getAllTodos() throws AccessDeniedException;
}
