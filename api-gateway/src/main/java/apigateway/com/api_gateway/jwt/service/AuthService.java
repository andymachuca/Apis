package apigateway.com.api_gateway.jwt.service;

import apigateway.com.api_gateway.jwt.dto.*;
import apigateway.com.api_gateway.jwt.model.Usuario;
import apigateway.com.api_gateway.jwt.repository.UsuarioRepository;
import apigateway.com.api_gateway.jwt.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasena()));

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtUtil.generateToken(usuario.getEmail());
        return new AuthResponse(token, usuario.getNombreUsuario());
    }

    public String register(RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setContrasena(passwordEncoder.encode(request.getContrasena()));
        usuario.setEstado("activo"); // o lo que recibas del request
        usuario.setRol(request.getRol());
        usuario.setNombreUsuario(request.getNombreUsuario());

        usuarioRepository.save(usuario);
        return "Usuario registrado con éxito";
    }
}
