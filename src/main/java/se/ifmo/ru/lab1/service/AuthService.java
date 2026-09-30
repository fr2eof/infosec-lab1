package se.ifmo.ru.lab1.service;

import se.ifmo.ru.lab1.dto.LoginRequest;
import se.ifmo.ru.lab1.dto.LoginResponse;
import se.ifmo.ru.lab1.dto.RegisterRequest;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    void register(RegisterRequest request);
}
