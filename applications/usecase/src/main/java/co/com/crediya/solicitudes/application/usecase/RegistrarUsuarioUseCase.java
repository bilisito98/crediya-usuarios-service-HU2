package co.com.crediya.solicitudes.application.usecase;

import co.com.crediya.solicitudes.domain.model.Usuario;
import co.com.crediya.solicitudes.domain.ports.UsuarioRepositoryPort;
import reactor.core.publisher.Mono;

public class RegistrarUsuarioUseCase {

    private final UsuarioRepositoryPort repository;

    public RegistrarUsuarioUseCase(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<Usuario> ejecutar(Usuario usuario) {
        if (usuario.getNombres() == null || usuario.getNombres().isBlank()) {
            return Mono.error(new IllegalArgumentException("El nombre es obligatorio"));
        }
        if (usuario.getApellidos() == null || usuario.getApellidos().isBlank()) {
            return Mono.error(new IllegalArgumentException("El apellido es obligatorio"));
        }
        if (usuario.getCorreoElectronico() == null || usuario.getCorreoElectronico().isBlank()) {
            return Mono.error(new IllegalArgumentException("El correo electrónico es obligatorio"));
        }
        if (usuario.getSalarioBase() == null || usuario.getSalarioBase() < 0 || usuario.getSalarioBase() > 15000000) {
            return Mono.error(new IllegalArgumentException("El salario base es inválido"));
        }

        if (!usuario.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return Mono.error(new IllegalArgumentException("El correo electrónico tiene un formato inválido"));
        }

        return repository.correoExiste(usuario.getCorreoElectronico())
                .flatMap(existe -> {
                    if (existe) {
                        return Mono.error(new IllegalArgumentException("Correo electrónico ya registrado"));
                    }
                    return repository.guardarUsuario(usuario);
                });
    }
}
