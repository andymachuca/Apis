package apigateway.com.api_gateway.jwt.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.http.HttpMethod; // Asegúrate de importar esto arriba

import static apigateway.com.api_gateway.jwt.security.PublicRoutes.*;
import static apigateway.com.api_gateway.redireccion.Contenidos.ContenidosPublicRoutes.*; //importa las rutas publicas de API Personas
import static apigateway.com.api_gateway.redireccion.analiticas.AnaliticasPublicRoutes.*; //importa las rutas publicas de API Productos
import static apigateway.com.api_gateway.redireccion.cursos.CursoPublicRoutes.*;
import static apigateway.com.api_gateway.redireccion.evaluacion.EvaluacionPublicRoutes.*;
import static apigateway.com.api_gateway.redireccion.matricula.MatriculaPublicRoutes.*;
import static apigateway.com.api_gateway.redireccion.notificaciones.NotificacionesPublicRoutes.*;
import static apigateway.com.api_gateway.redireccion.pago.PagoPublicRoutes.*;
import static apigateway.com.api_gateway.redireccion.usuario.UsuarioPublicRoutes.*;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // URL públicas JWT
                .requestMatchers(HttpMethod.POST, PUBLIC_POST).permitAll() // rutas publicas POST de PublicRoutes de JWT
                .requestMatchers(HttpMethod.GET, PUBLIC_GET).permitAll() // rutas publicas GET de PublicRoutes de JWT

                // URL públicas API Personas
                .requestMatchers(HttpMethod.GET, CONTENIDOS_PUBLIC_GET).permitAll()   // lista pública api Personas GET

                // URL públicas API Productos
                .requestMatchers(HttpMethod.GET, ANALITICAS_PUBLIC_GET).permitAll() 
                
                .requestMatchers(HttpMethod.GET, CURSO_PUBLIC_GET ).permitAll()
                
                .requestMatchers(HttpMethod.GET, EVALUACIONES_PUBLIC_GET).permitAll()
                
                .requestMatchers(HttpMethod.GET, MATRICULAS_PUBLIC_GET).permitAll()
                
                .requestMatchers(HttpMethod.GET,NOTIFICACIONES_PUBLIC_GET ).permitAll()
                
                .requestMatchers(HttpMethod.GET, PAGO_PUBLIC_GET).permitAll()
                
                .requestMatchers(HttpMethod.GET, USUARIOS_PUBLIC_GET ).permitAll()// lista pública api Productos GET

                // Otras URL Token obligatorio
                .anyRequest().authenticated()

            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
