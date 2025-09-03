package co.com.crediya.solicitudes.infrastructure.service;

import co.com.crediya.solicitudes.domain.model.Usuario;
import co.com.crediya.solicitudes.domain.usecase.RegistrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;

    @Transactional
    public Mono<Usuario> registrarUsuario(Usuario usuario) {
        log.info("Iniciando registro de usuario con email: {}", usuario.getCorreoElectronico());

        return registrarUsuarioUseCase.ejecutar(usuario)
                .doOnSuccess(u -> log.info("Usuario registrado correctamente: {}", u.getCorreoElectronico()))
                .doOnError(e -> log.error("Error registrando usuario: {}", e.getMessage()));
    }
}
