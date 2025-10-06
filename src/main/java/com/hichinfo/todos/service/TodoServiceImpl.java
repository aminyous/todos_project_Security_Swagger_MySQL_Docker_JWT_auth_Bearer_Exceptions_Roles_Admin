package com.hichinfo.todos.service;

import com.hichinfo.todos.entity.Todo;
import com.hichinfo.todos.entity.User;
import com.hichinfo.todos.repository.TodoRepository;
import com.hichinfo.todos.request.TodoRequest;
import com.hichinfo.todos.response.TodoResponse;
import com.hichinfo.todos.util.FindAuthenticatedUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public TodoServiceImpl(TodoRepository todoRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.todoRepository = todoRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional
    public TodoResponse createTodo(TodoRequest todoRequest) throws AccessDeniedException {

        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Todo todo = new Todo(
                todoRequest.getTitle(),
                todoRequest.getDescription(),
                todoRequest.getPriority(),
                false,
                currentUser
        );

        Todo savedTodo = todoRepository.save(todo);

        return convertToTodoResponse(savedTodo);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoResponse> getAllTodos() throws AccessDeniedException {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        return todoRepository.findByOwner(currentUser)
                .stream()
                .map(this::convertToTodoResponse)
                .toList();
    }

    private TodoResponse convertToTodoResponse(Todo todo){
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getPriority(),
                todo.isComplete()
        );
    }
}
