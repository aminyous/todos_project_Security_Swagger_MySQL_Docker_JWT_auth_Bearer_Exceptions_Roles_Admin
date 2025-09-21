package com.hichinfo.todos.util;

import com.hichinfo.todos.entity.User;

import java.nio.file.AccessDeniedException;

public interface FindAuthenticatedUser {
    User getAuthenticatedUser() throws AccessDeniedException;
}
