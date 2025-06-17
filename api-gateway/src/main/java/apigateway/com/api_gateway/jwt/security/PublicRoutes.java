package apigateway.com.api_gateway.jwt.security;

public class PublicRoutes {

    // Rutas públicas para GET
    public static final String[] PUBLIC_GET = {
        "/api/ping"
    };


    // Rutas públicas para POST
    public static final String[] PUBLIC_POST = {
        "/api/auth/login",
        "/api/auth/register"
        // puedes agregar otras si es necesario
    };

}
