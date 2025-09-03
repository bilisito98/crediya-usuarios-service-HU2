package co.com.crediya.solicitudes.infrastructure.service;

import co.com.crediya.solicitudes.domain.usecase.ClienteUseCase;
import co.com.crediya.solicitudes.domain.model.Cliente;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteUseCase clienteUseCase;

    public ClienteService(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    public Mono<Cliente> crearCliente(Cliente cliente) {
        return clienteUseCase.crearCliente(cliente);
    }

    public Mono<Cliente> obtenerClientePorId(UUID id) {
        return clienteUseCase.obtenerClientePorId(id);
    }

    public Flux<Cliente> obtenerTodosLosClientes() {
        return clienteUseCase.obtenerTodosLosClientes();
    }

    public Mono<Void> eliminarCliente(UUID id) {
        return clienteUseCase.eliminarCliente(id);
    }
}
