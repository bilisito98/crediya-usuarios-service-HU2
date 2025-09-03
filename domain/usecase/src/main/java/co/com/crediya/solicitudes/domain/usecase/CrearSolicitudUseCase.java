package co.com.crediya.solicitudes.domain.usecase;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import co.com.crediya.solicitudes.domain.ports.SolicitudRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class CrearSolicitudUseCase {

    private final SolicitudRepositoryPort solicitudRepository;
    private final ClienteRepositoryPort clienteRepository;

    public Mono<Solicitud> ejecutar(UUID clienteId, Double monto, Integer plazoMeses) {

        if (clienteId == null)
            return Mono.error(new IllegalArgumentException("clienteId es requerido"));
        if (monto == null || monto <= 0)
            return Mono.error(new IllegalArgumentException("monto inválido"));
        if (plazoMeses == null || plazoMeses <= 0)
            return Mono.error(new IllegalArgumentException("plazo inválido"));

        return clienteRepository.findById(clienteId)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Cliente no existe")))
                .flatMap(cliente -> {
                    Solicitud solicitud = Solicitud.builder()
                            .clienteId(clienteId)
                            .monto(monto)
                            .plazoMeses(plazoMeses)
                            .estado("PENDIENTE")
                            .fechaCreacion(LocalDate.now())
                            .build();

                    System.out.printf("Creando solicitud para clienteId=%s monto=%s%n", clienteId, monto);

                    return solicitudRepository.guardarSolicitud(solicitud);
                });
    }
}
