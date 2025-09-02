package co.com.crediya.solicitudes.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Table("solicitudes")
public class SolicitudEntity {

    @Id
    private UUID id;

    @Column("cliente_id")
    private UUID clienteId;

    @Column("documento_identidad")
    private String documentoIdentidad;

    private String numero;

    private Double monto;

    @Column("plazo_meses")
    private Integer plazoMeses;

    @Column("tipo_prestamo")
    private String tipoPrestamo;

    private String estado; // Por defecto "Pendiente de revisión"

    @Column("fecha_creacion")
    private LocalDate fechaCreacion;

    @Column("usuario_id")
    private UUID usuarioId;
}
