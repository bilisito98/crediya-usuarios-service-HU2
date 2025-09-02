package co.com.crediya.solicitudes.infrastructure.adapters;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import co.com.crediya.solicitudes.infrastructure.entity.ClienteEntity;
import co.com.crediya.solicitudes.infrastructure.mapper.ClienteMapper;
import co.com.crediya.solicitudes.infrastructure.r2dbc.ClienteR2dbcRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteR2dbcRepository repository;

    public ClienteRepositoryAdapter(ClienteR2dbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        ClienteEntity entity = ClienteMapper.toEntity(cliente);
        return repository.save(entity)
                .map(ClienteMapper::toDomain);
    }

    @Override
    public Mono<Cliente> findById(UUID id) {
        return repository.findById(id)
                .map(ClienteMapper::toDomain);
    }

    @Override
    public Flux<Cliente> findAll() {
        return repository.findAll()
                .map(ClienteMapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }
}