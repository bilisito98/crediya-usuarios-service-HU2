package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.model.TipoPrestamo;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import reactor.core.publisher.Mono;

public class RegistrarSolicitudUseCase {

    private final SolicitudRepositoryPort repositoryPort;

    public RegistrarSolicitudUseCase(SolicitudRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Mono<Solicitud> ejecutar(Solicitud solicitud) {
        // Validaciones
        if (solicitud.getNumero() == null || solicitud.getNumero().isEmpty()) {
            return Mono.error(new IllegalArgumentException("El número de solicitud es obligatorio"));
        }
        if (solicitud.getMonto() == null || solicitud.getMonto() <= 0 || solicitud.getMonto() > 15000000) {
            return Mono.error(new IllegalArgumentException("El monto debe estar entre 1 y 15.000.000"));
        }
        if (solicitud.getPlazoMeses() == null || solicitud.getPlazoMeses() <= 0) {
            return Mono.error(new IllegalArgumentException("El plazo debe ser mayor a cero"));
        }
        if (solicitud.getTipoPrestamo() == null || !TipoPrestamo.isValid(solicitud.getTipoPrestamo())) {
            return Mono.error(new IllegalArgumentException("El tipo de préstamo es inválido"));
        }

        // Estado inicial
        solicitud.setEstado("Pendiente de revisión");

        return repositoryPort.existeSolicitud(solicitud.getNumero())
                .flatMap(existe -> {
                    if (existe) return Mono.error(new IllegalArgumentException("Número de solicitud ya registrado"));
                    return repositoryPort.guardarSolicitud(solicitud);
                });
    }
}
