package co.com.crediya.solicitudes.infrastructure.adapters;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;
import co.com.crediya.solicitudes.infrastructure.mapper.SolicitudMapper;
import co.com.crediya.solicitudes.infrastructure.r2dbc.SolicitudR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SolicitudRepositoryAdapter implements SolicitudRepositoryPort {

    private final SolicitudR2dbcRepository repository;

    // Guardar solicitud
    @Override
    public Mono<Solicitud> guardarSolicitud(Solicitud solicitud) {
        SolicitudEntity entity = SolicitudMapper.toEntity(solicitud);
        return repository.save(entity)
                .map(SolicitudMapper::toModel);
    }

    @Override
    public Mono<Boolean> existeSolicitud(String numero) {
        return repository.findByNumero(numero)
                .hasElement();
    }

    @Override
    public Mono<Solicitud> findById(UUID id) {
        return repository.findById(id)
                .map(SolicitudMapper::toModel);
    }

    @Override
    public Flux<Solicitud> findAll() {
        return repository.findAll()
                .map(SolicitudMapper::toModel);
    }

    @Override
    public Flux<Solicitud> findAllByClienteId(UUID clienteId) {
        return repository.findAllByClienteId(clienteId)
                .map(SolicitudMapper::toModel);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsByClienteId(UUID clienteId) {
        return repository.existsByClienteId(clienteId);
    }
}
