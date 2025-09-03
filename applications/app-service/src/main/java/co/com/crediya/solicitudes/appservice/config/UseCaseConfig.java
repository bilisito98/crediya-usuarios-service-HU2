package co.com.crediya.solicitudes.appservice.config;

import co.com.crediya.solicitudes.domain.usecase.CrearSolicitudUseCase;
import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final SolicitudRepositoryPort solicitudRepository;
    private final ClienteRepositoryPort clienteRepository;

    public UseCaseConfig(SolicitudRepositoryPort solicitudRepository,
                         ClienteRepositoryPort clienteRepository) {
        this.solicitudRepository = solicitudRepository;
        this.clienteRepository = clienteRepository;
    }

    @Bean
    public CrearSolicitudUseCase crearSolicitudUseCase() {
        return new CrearSolicitudUseCase(solicitudRepository, clienteRepository);
    }
}
