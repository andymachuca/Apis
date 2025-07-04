package gestionpago.com.gestion_pago.service;

import gestionpago.com.gestion_pago.dto.CrearPagoRequest;
import gestionpago.com.gestion_pago.models.Pago;
import gestionpago.com.gestion_pago.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago crear(CrearPagoRequest request) {
        Pago p = new Pago();

        p.setIdCliente(request.getIdCliente()); // ← ahora sí se guarda
        p.setMonto(request.getMonto());
        p.setMetodo(request.getMetodo());
        p.setDescripcion(request.getDescripcion());
        p.setEstado(request.getEstado());
        p.setFechaPago(LocalDateTime.now());

        return pagoRepository.save(p);
    }

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + id));
    }
}
