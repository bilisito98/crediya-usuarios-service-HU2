package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SolicitudUseCase {
    Mono<Solicitud> crearSolicitud(Solicitud solicitud);
    Mono<Solicitud> obtenerSolicitudPorId(UUID id);
    Flux<Solicitud> obtenerTodasLasSolicitudes();
    Mono<Boolean> existeSolicitudPorClienteId(UUID clienteId);
    Mono<Void> eliminarSolicitud(UUID id);
}
