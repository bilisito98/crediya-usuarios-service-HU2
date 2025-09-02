package com.crediya.solicitudes.aplication;

import com.crediya.solicitudes.domain.model.Solicitud;
import com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public class CrearSolicitudUseCase {

    private final SolicitudRepositoryPort repository;

    public CrearSolicitudUseCase(SolicitudRepositoryPort repository) {
        this.repository = repository;
    }

    public Mono<Solicitud> ejecutar(@NotBlank String nombre,
                                    @NotBlank String documento,
                                    @NotNull @Min(1) Double monto,
                                    @NotNull @Min(1) Integer plazoMeses) {
        // Aquí podrías llamar reglas de negocio (capacidad endeudamiento, etc.)
        var solicitud = Solicitud.nueva(nombre, documento, monto, plazoMeses);
        return repository.save(solicitud);
    }
}

