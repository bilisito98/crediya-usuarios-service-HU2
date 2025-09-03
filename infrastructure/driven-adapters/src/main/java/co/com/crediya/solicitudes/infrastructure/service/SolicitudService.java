package co.com.crediya.solicitudes.infrastructure.service;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.RegistrarSolicitudUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private static final Logger log = LoggerFactory.getLogger(SolicitudService.class);

    private final RegistrarSolicitudUseCase useCase;
    private final SolicitudRepositoryPort repository; // 👈 agregado

    // Registrar nueva solicitud
    public Mono<Solicitud> registrarSolicitud(Solicitud solicitud) {
        return Mono.just(solicitud)
                .flatMap(this::validarSolicitud)
                .map(this::asignarEstadoInicial)
                .doOnSubscribe(sub -> log.info("Iniciando registro de solicitud para cliente [{}]", solicitud.getDocumentoIdentidad()))
                .flatMap(useCase::ejecutar)
                .doOnSuccess(s -> log.info("Solicitud registrada exitosamente con número: {}", s.getNumero()))
                .doOnError(e -> log.error("Error registrando solicitud: {}", e.getMessage(), e))
                .onErrorResume(this::manejarErrores);
    }

    // Obtener todas las solicitudes
    public Flux<Solicitud> obtenerTodas() {
        log.info("Consultando todas las solicitudes registradas");
        return repository.findAll()
                .doOnError(e -> log.error("Error obteniendo todas las solicitudes: {}", e.getMessage(), e));
    }

    // Obtener solicitud por ID
    public Mono<Solicitud> obtenerPorId(String id) {
        log.info("Consultando solicitud con id [{}]", id);
        return repository.findById(UUID.fromString(id))
                .switchIfEmpty(Mono.error(new RuntimeException("Solicitud no encontrada")))
                .doOnError(e -> log.error("Error obteniendo solicitud con id [{}]: {}", id, e.getMessage(), e));
    }

    // --------- Validaciones internas ---------
    private Mono<Solicitud> validarSolicitud(Solicitud solicitud) {
        if (solicitud.getDocumentoIdentidad() == null || solicitud.getDocumentoIdentidad().isBlank()) {
            return Mono.error(new IllegalArgumentException("El documento del cliente es obligatorio."));
        }
        if (solicitud.getMonto() == null || solicitud.getMonto() <= 0) {
            return Mono.error(new IllegalArgumentException("El monto solicitado debe ser mayor a 0."));
        }
        if (solicitud.getPlazoMeses() == null || solicitud.getPlazoMeses() <= 0) {
            return Mono.error(new IllegalArgumentException("El plazo debe ser mayor a 0 meses."));
        }
        if (solicitud.getTipoPrestamo() == null || solicitud.getTipoPrestamo().isBlank()) {
            return Mono.error(new IllegalArgumentException("El tipo de préstamo es obligatorio."));
        }
        return Mono.just(solicitud);
    }

    private Solicitud asignarEstadoInicial(Solicitud solicitud) {
        solicitud.setEstado("Pendiente de revisión");
        return solicitud;
    }

    private Mono<Solicitud> manejarErrores(Throwable e) {
        String mensaje = "No se pudo registrar la solicitud. Motivo: " + e.getMessage();
        log.warn("Manejando error de negocio: {}", mensaje);
        return Mono.error(new RuntimeException(mensaje));
    }
}
