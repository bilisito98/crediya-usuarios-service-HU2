package co.com.crediya.solicitudes.appservice;

import co.com.crediya.solicitudes.domain.ports.UsuarioRepositoryPort;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import co.com.crediya.solicitudes.domain.usecase.RegistrarUsuarioUseCase;
import co.com.crediya.solicitudes.domain.usecase.RegistrarSolicitudUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = {
        "co.com.crediya.solicitudes.infrastructure.service",
        "co.com.crediya.usuariosservice.entrypoints.reactiveweb.controller",
        "co.com.crediya.solicitudes.domain.usecase",
        "co.com.crediya.solicitudes.infrastructure.adapters",
        "co.com.crediya.solicitudes.infrastructure.r2dbc",
        "co.com.crediya.solicitudes.infrastructure.mapper",
        "co.com.crediya.solicitudes.infrastructure.iml",
        "co.com.crediya.solicitudes.appservice.config"
})
@EnableR2dbcRepositories(basePackages = "co.com.crediya.solicitudes.infrastructure.r2dbc")
@EntityScan(basePackages = "co.com.crediya.solicitudes.infrastructure.entity")
public class AppServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppServiceApplication.class, args);
    }

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(
            @Qualifier("usuarioRepositoryAdapter") UsuarioRepositoryPort usuarioRepository) {
        return new RegistrarUsuarioUseCase(usuarioRepository);
    }

    @Bean
    public RegistrarSolicitudUseCase registrarSolicitudUseCase(
            @Qualifier("solicitudRepositoryAdapter") SolicitudRepositoryPort solicitudRepository) {
        return new RegistrarSolicitudUseCase(solicitudRepository);
    }
}
