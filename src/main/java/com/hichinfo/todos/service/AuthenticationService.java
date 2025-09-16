package com.hichinfo.todos.service;

import com.hichinfo.todos.request.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
}
