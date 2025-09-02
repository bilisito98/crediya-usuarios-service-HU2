package co.com.crediya.solicitudes.appservice.controller;

import co.com.crediya.solicitudes.domain.model.Cliente;
import co.com.crediya.solicitudes.appservice.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Mono<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping("/{id}")
    public Mono<Cliente> obtenerCliente(@PathVariable UUID id) {
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping
    public Flux<Cliente> listarClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCliente(@PathVariable UUID id) {
        return clienteService.eliminarCliente(id);
    }
}
