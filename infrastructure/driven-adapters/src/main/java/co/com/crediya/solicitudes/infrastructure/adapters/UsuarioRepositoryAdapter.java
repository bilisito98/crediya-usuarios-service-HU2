package co.com.crediya.solicitudes.infrastructure.adapters;

import co.com.crediya.solicitudes.domain.model.Usuario;
import co.com.crediya.solicitudes.domain.ports.UsuarioRepositoryPort;
import co.com.crediya.solicitudes.infrastructure.entity.UsuarioEntity;
import co.com.crediya.solicitudes.infrastructure.r2dbc.UsuarioR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioR2dbcRepository repository;

    @Override
    public Mono<Boolean> correoExiste(String correo) {
        return repository.existsByCorreoElectronico(correo);
    }

    @Override
    public Mono<Usuario> guardarUsuario(Usuario usuario) {
        // Mapear Usuario -> UsuarioEntity usando builder
        UsuarioEntity entity = UsuarioEntity.builder()
                .nombres(usuario.getNombres())
                .apellidos(usuario.getApellidos())
                .correoElectronico(usuario.getCorreoElectronico())
                .telefono(usuario.getTelefono())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .direccion(usuario.getDireccion())
                .salarioBase(usuario.getSalarioBase())
                .build();

        return repository.save(entity)
                .map(savedEntity -> Usuario.builder()
                        .id(savedEntity.getId())
                        .nombres(savedEntity.getNombres())
                        .apellidos(savedEntity.getApellidos())
                        .correoElectronico(savedEntity.getCorreoElectronico())
                        .telefono(savedEntity.getTelefono())
                        .fechaNacimiento(savedEntity.getFechaNacimiento())
                        .direccion(savedEntity.getDireccion())
                        .salarioBase(savedEntity.getSalarioBase())
                        .build()
                );
    }
}
