package com.hichinfo.todos.service;

import com.hichinfo.todos.request.AuthenticationRequest;
import com.hichinfo.todos.request.RegisterRequest;
import com.hichinfo.todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}
