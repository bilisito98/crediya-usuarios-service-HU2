package co.com.crediya.solicitudes.infrastructure.r2dbc;

import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SolicitudR2dbcRepository extends R2dbcRepository<SolicitudEntity, UUID> {

    Flux<SolicitudEntity> findAllByClienteId(UUID clienteId);
    Mono<Boolean> existsByClienteId(UUID clienteId);
    Mono<SolicitudEntity> findByNumero(String numero);
}
