package com.hichinfo.todos.service;

import com.hichinfo.todos.entity.User;

import java.nio.file.AccessDeniedException;

public interface UserService {
    User getUserInfo() throws AccessDeniedException;
}
