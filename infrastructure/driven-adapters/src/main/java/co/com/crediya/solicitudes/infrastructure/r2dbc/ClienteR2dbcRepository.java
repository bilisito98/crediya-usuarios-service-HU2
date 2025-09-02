package co.com.crediya.solicitudes.infrastructure.r2dbc;

import co.com.crediya.solicitudes.infrastructure.entity.ClienteEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ClienteR2dbcRepository extends ReactiveCrudRepository<ClienteEntity, UUID> {
    // Cambiado de findByEmail a findByCorreoElectronico
    Mono<ClienteEntity> findByCorreoElectronico(String correoElectronico);
}
