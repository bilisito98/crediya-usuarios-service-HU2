package co.com.crediya.solicitudes.infrastructure.r2dbc;

import co.com.crediya.solicitudes.infrastructure.entity.UsuarioEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UsuarioR2dbcRepository extends ReactiveCrudRepository<UsuarioEntity, UUID> {
    Mono<Boolean> existsByCorreoElectronico(String correoElectronico);
    Mono<UsuarioEntity> findByCorreoElectronico(String correoElectronico); // agregado
}
