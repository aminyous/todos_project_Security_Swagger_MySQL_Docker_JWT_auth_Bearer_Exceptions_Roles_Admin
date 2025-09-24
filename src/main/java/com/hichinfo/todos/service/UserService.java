package com.hichinfo.todos.service;

import com.hichinfo.todos.request.PasswordUpdateRequest;
import com.hichinfo.todos.response.UserResponse;

import java.nio.file.AccessDeniedException;

public interface UserService {
    UserResponse getUserInfo() throws AccessDeniedException;
    void deleteUser() throws AccessDeniedException;
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest) throws AccessDeniedException;
}
