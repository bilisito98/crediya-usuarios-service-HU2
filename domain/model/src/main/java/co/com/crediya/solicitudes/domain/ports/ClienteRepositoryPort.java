package co.com.crediya.solicitudes.domain.ports;

import co.com.crediya.solicitudes.domain.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ClienteRepositoryPort {
    Mono<Cliente> save(Cliente cliente);
    Mono<Cliente> findById(UUID id);
    Flux<Cliente> findAll();
    Mono<Void> deleteById(UUID id);
}
