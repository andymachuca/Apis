package apigateway.com.api_gateway.jwt.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String contrasena;
    private String rol;
    private String estado;
    private String nombreUsuario;

}
