package apigateway.com.api_gateway.jwt.controller;

import apigateway.com.api_gateway.jwt.dto.*;
import apigateway.com.api_gateway.jwt.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/logout")
    public String logout() {
        // El cliente debe borrar el token (no hay estado del lado del servidor)
        return "Logout exitoso";
    }
}
