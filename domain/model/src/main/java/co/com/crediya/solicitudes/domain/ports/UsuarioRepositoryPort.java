package co.com.crediya.solicitudes.domain.ports;

import co.com.crediya.solicitudes.domain.model.Usuario;
import reactor.core.publisher.Mono;

public interface UsuarioRepositoryPort {
    Mono<Boolean> correoExiste(String correoElectronico);
    Mono<Usuario> guardarUsuario(Usuario usuario);
}
