package com.hichinfo.todos.service;

import com.hichinfo.todos.request.TodoRequest;
import com.hichinfo.todos.response.TodoResponse;

import java.nio.file.AccessDeniedException;

public interface TodoService {

    TodoResponse createTodo(TodoRequest todoRequest) throws AccessDeniedException;
}
