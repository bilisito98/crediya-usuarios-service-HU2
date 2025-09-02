package co.com.crediya.solicitudes.infrastructure.mapper;

import co.com.crediya.solicitudes.domain.model.Solicitud;
import co.com.crediya.solicitudes.infrastructure.entity.SolicitudEntity;

public class SolicitudMapper {

    public static SolicitudEntity toEntity(Solicitud solicitud) {
        if (solicitud == null) return null;

        return SolicitudEntity.builder()
                .id(solicitud.getId())
                .clienteId(solicitud.getClienteId())
                .documentoIdentidad(solicitud.getDocumentoIdentidad())
                .numero(solicitud.getNumero())
                .monto(solicitud.getMonto())
                .plazoMeses(solicitud.getPlazoMeses())
                .tipoPrestamo(solicitud.getTipoPrestamo())
                .estado(solicitud.getEstado())
                .fechaCreacion(solicitud.getFechaCreacion())
                .usuarioId(solicitud.getUsuarioId())
                .build();
    }

    public static Solicitud toModel(SolicitudEntity entity) {
        if (entity == null) return null;

        return Solicitud.builder()
                .id(entity.getId())
                .clienteId(entity.getClienteId())
                .documentoIdentidad(entity.getDocumentoIdentidad())
                .numero(entity.getNumero())
                .monto(entity.getMonto())
                .plazoMeses(entity.getPlazoMeses())
                .tipoPrestamo(entity.getTipoPrestamo())
                .estado(entity.getEstado())
                .fechaCreacion(entity.getFechaCreacion())
                .usuarioId(entity.getUsuarioId())
                .build();
    }
}
