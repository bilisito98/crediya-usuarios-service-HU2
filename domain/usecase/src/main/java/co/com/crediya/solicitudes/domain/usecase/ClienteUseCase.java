package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class ClienteUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    public Mono<Cliente> crearCliente(Cliente cliente) {
        return clienteRepositoryPort.save(cliente);
    }

    public Mono<Cliente> obtenerClientePorId(UUID id) {
        return clienteRepositoryPort.findById(id);
    }

    public Flux<Cliente> obtenerTodosLosClientes() {
        return clienteRepositoryPort.findAll();
    }

    public Mono<Void> eliminarCliente(UUID id) {
        return clienteRepositoryPort.deleteById(id);
    }
}
