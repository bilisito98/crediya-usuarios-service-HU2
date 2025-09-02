package co.com.crediya.solicitudes.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Solicitud {
    private UUID id;
    private UUID clienteId;
    private String documentoIdentidad;
    private String numero;
    private Double monto;
    private Integer plazoMeses;
    private String tipoPrestamo;
    private String estado;
    private LocalDate fechaCreacion;
    private UUID usuarioId;
    private LocalDate fecha;
}
