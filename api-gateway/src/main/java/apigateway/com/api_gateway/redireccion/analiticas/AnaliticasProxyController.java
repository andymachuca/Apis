package apigateway.com.api_gateway.redireccion.analiticas;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/proxy/analiticas")
@RequiredArgsConstructor
public class AnaliticasProxyController {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/analiticas"; // microservicio de analíticas

    // ✅ Maneja exactamente: GET /api/proxy/analiticas
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerRaiz(@RequestHeader HttpHeaders headers) {
        HttpHeaders cleanHeaders = new HttpHeaders();
        headers.forEach((key, value) -> {
            if (!key.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                cleanHeaders.put(key, value);
            }
        });

        HttpEntity<String> entity = new HttpEntity<>(null, cleanHeaders);
        return restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    // ✅ Maneja cualquier otra ruta como: /api/proxy/analiticas/obtener, POST, etc.
    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> proxyAnaliticas(HttpServletRequest request,
                                             @RequestBody(required = false) String body,
                                             @RequestHeader HttpHeaders headers) {

        String originalPath = request.getRequestURI().replace("/api/proxy/analiticas", "");
        String targetUrl = BASE_URL + originalPath;

        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        HttpHeaders cleanHeaders = new HttpHeaders();
        headers.forEach((key, value) -> {
            if (!key.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                cleanHeaders.put(key, value);
            }
        });
        cleanHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(body, cleanHeaders);
        ResponseEntity<String> response = restTemplate.exchange(targetUrl, method, entity, String.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
