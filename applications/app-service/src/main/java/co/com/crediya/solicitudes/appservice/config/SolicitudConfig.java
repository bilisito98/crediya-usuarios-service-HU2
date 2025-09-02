package co.com.crediya.solicitudes.appservice.config;

import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.SolicitudUseCase;
import co.com.crediya.solicitudes.infrastructure.iml.SolicitudUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolicitudConfig {

    @Bean
    public SolicitudUseCase solicitudUseCase(SolicitudRepositoryPort repository) {
        return new SolicitudUseCaseImpl(repository);
    }
}
