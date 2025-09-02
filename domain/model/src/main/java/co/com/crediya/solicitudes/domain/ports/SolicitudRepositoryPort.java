package co.com.crediya.solicitudes.domain.ports;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SolicitudRepositoryPort {
    Mono<Solicitud> guardarSolicitud(Solicitud solicitud);

    Mono<Boolean> existeSolicitud(String numero);

    Mono<Solicitud> findById(UUID id);

    Flux<Solicitud> findAll();

    Flux<Solicitud> findAllByClienteId(UUID clienteId);

    Mono<Void> deleteById(UUID id);

    Mono<Boolean> existsByClienteId(UUID clienteId);
}
