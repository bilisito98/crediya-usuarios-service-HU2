package co.com.crediya.solicitudes.infrastructure.iml;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.SolicitudUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class SolicitudUseCaseImpl implements SolicitudUseCase {

    private final SolicitudRepositoryPort repository;

    public SolicitudUseCaseImpl(SolicitudRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Solicitud> crearSolicitud(Solicitud solicitud) {
        return repository.guardarSolicitud(solicitud);
    }

    @Override
    public Mono<Solicitud> obtenerSolicitudPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Solicitud> obtenerTodasLasSolicitudes() {
        return repository.findAll();
    }

    @Override
    public Mono<Boolean> existeSolicitudPorClienteId(UUID clienteId) {
        return repository.findAllByClienteId(clienteId).hasElements();
    }

    @Override
    public Mono<Void> eliminarSolicitud(UUID id) {
        return repository.deleteById(id);
    }
}
