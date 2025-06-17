package apigateway.com.api_gateway.jwt.dto;

import lombok.Data;

@Data
public class LoginRequest {
   private String email;
   private String contrasena;

}
